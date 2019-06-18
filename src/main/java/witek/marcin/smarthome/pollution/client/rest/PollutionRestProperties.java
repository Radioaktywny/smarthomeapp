package witek.marcin.smarthome.pollution.client.rest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pollution.rest")
public class PollutionRestProperties {

    private String apiKey;

    private String language;

}
