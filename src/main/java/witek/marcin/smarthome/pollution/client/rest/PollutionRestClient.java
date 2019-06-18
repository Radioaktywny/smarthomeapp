package witek.marcin.smarthome.pollution.client.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import witek.marcin.smarthome.pollution.client.model.PollutionData;

@Slf4j
public class PollutionRestClient {

    private static final String MEASUREMENTS_NEAREST = "/v2/measurements/nearest";

    private static final String POSITION_LAT = "lat";
    
    private static final String POSITION_LNG = "lng";     
    
    private static final String MAX_DISTANCE = "maxDistanceKM";

    private final RestTemplate restTemplate;

    public PollutionRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<PollutionData> getPollution(String latitude, String longitude) {
        try {
            return restTemplate.exchange(buildGetPollutionUrl(latitude, longitude), 
                    HttpMethod.GET, new HttpEntity<String>(new HttpHeaders()), PollutionData.class);
        } catch (HttpStatusCodeException e) {
            log.error(e.getResponseBodyAsString());
            throw e;
        }
    }

    private String buildGetPollutionUrl(String lat, String lng) {
        final String build = RestUrl.builder().withPath(MEASUREMENTS_NEAREST)
                .addParameter(MAX_DISTANCE, "-1.0")
                .addParameter(POSITION_LAT, lat)
                .addParameter(POSITION_LNG, lng)
                .build();
        log.info(build);
        return build;
    }
 
}
