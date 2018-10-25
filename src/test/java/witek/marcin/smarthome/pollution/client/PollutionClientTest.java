package witek.marcin.smarthome.pollution.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestClient;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestClientConfiguration;

@SpringBootTest(classes = PollutionRestClientConfiguration.class)
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
public class PollutionClientTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getPollution() {
        PollutionRestClient pollutionClient = new PollutionRestClient(restTemplate);
        pollutionClient.getPollution().getBody().getCurrent().getValues().forEach(System.out::println);
        
    }
}