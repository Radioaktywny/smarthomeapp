package witek.marcin.smarthome.pollution.client.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pollution {
    
    private Double pm25Value;
    private Double pm10Value;
    private Double pm25Percentage;
    private Double pm10Percentage;
    
    private String airQualityDescription;
    
    private Weather weather;
    
}
