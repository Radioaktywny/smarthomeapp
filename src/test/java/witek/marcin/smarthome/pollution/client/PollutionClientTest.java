package witek.marcin.smarthome.pollution.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import witek.marcin.smarthome.pollution.client.api.ApiConfiguration;
import witek.marcin.smarthome.pollution.client.api.GPSLocation;
import witek.marcin.smarthome.pollution.client.api.Pollution;
import witek.marcin.smarthome.pollution.client.api.PollutionRetriever;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestClient;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestClientConfiguration;

@SpringBootTest(classes = {PollutionRestClientConfiguration.class, ApiConfiguration.class})
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
public class PollutionClientTest {

    @Autowired
    private PollutionRetriever pollutionRetriever;

    @Test
    public void getPollution() {
        Pollution pollution = pollutionRetriever.getPollution(GPSLocation.builder()
                .latitude("50.062006")
                .longitude("19.940984")
                .build());

        System.out.println(pollution);
    }
}