package witek.marcin.smarthome.pollution.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import witek.marcin.smarthome.pollution.client.api.ApiConfiguration;
import witek.marcin.smarthome.pollution.client.api.Locations;
import witek.marcin.smarthome.pollution.client.api.Pollution;
import witek.marcin.smarthome.pollution.client.api.PollutionRetriever;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestClientConfiguration;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest(classes = {PollutionTestConfiguration.class, PollutionRestClientConfiguration.class, ApiConfiguration.class})
@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@ActiveProfiles("test")
public class PollutionClientTest {

    @Autowired
    private PollutionRetriever pollutionRetriever;

    @Test
    public void getPollution() {
        Pollution pollution = pollutionRetriever.getPollution(Locations.KRAKOW_CZERWONE_MAKI);
        System.out.println(pollution);
    }

    @Test
    public void isPollutionOk() {
        Boolean isOk = pollutionRetriever.isPollutionOk(Locations.KRAKOW_CZERWONE_MAKI);
        System.out.println(isOk);
        assertThat(isOk).isTrue();
        //to bedzie failowac jak bedzie smog .
    }
}