package witek.marcin.smarthome.pollution.client.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GPSLocation {
    private String latitude;
    private String longitude;
}
