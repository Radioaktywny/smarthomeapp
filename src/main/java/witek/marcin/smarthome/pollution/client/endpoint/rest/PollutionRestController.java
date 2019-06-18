package witek.marcin.smarthome.pollution.client.endpoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import witek.marcin.smarthome.pollution.client.api.Locations;
import witek.marcin.smarthome.pollution.client.api.PollutionRetriever;

@RestController
public class PollutionRestController {

    @Autowired
    private PollutionRetriever pollutionRetriever;

    @GetMapping("/getTemperature")
    public Double getTemperature() {
        return pollutionRetriever.getPollution(Locations.KRAKOW_CZERWONE_MAKI).getWeather().getTemperature();
    }


}
