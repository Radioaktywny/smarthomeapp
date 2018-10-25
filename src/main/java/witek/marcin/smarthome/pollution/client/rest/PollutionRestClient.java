package witek.marcin.smarthome.pollution.client.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import witek.marcin.smarthome.pollution.client.model.PollutionData;

public class PollutionRestClient {

    private static final String MEASUREMENTS_NEAREST = "/v2/measurements/nearest?";

    private static final String NEXT_ARG_DELIMITER = "&";

    private static final String POSITION = "lat=50.062006" + NEXT_ARG_DELIMITER + "lng=19.940984";
    
    private static final String MAX_DISTANCE = "maxDistanceKM=-1.0";

    private final RestTemplate restTemplate;

    public PollutionRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<PollutionData> getPollution() {
        return restTemplate.exchange(buildGetPollutionUrl(), HttpMethod.GET,
                new HttpEntity<String>(new HttpHeaders()), PollutionData.class);
    }

    private String buildGetPollutionUrl() {
        return MEASUREMENTS_NEAREST + POSITION + NEXT_ARG_DELIMITER + MAX_DISTANCE;
    }

}
