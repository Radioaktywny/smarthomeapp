package witek.marcin.smarthome.pollution.client.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weather {

    private Double pressure;
    private Double humidity;
    private Double temperature;

}
