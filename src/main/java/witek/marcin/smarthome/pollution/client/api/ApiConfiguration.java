package witek.marcin.smarthome.pollution.client.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import witek.marcin.smarthome.pollution.client.rest.PollutionRestClient;

@Configuration
public class ApiConfiguration {
    
    @Bean
    PollutionRetriever airilyPollutionRetriever(PollutionRestClient pollutionRestClient){
        return new AirlyPollutionRetriever(pollutionRestClient);
    }
    
    
}
