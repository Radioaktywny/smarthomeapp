package witek.marcin.smarthome.pollution.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestProperties;

@Configuration
@Profile("test")
public class PollutionTestConfiguration {
    
    @Bean
    PollutionRestProperties pollutionRestProperties(){
        final PollutionRestProperties pollutionRestProperties = new PollutionRestProperties();
        pollutionRestProperties.setApiKey("0O2wiFgoq1aitpEbyr3h13oGw1e9NOFQ");
        pollutionRestProperties.setLanguage("pl");
        return pollutionRestProperties;
    }
    
}
