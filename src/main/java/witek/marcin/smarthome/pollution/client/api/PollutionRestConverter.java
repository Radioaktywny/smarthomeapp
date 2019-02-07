package witek.marcin.smarthome.pollution.client.api;

import org.springframework.http.ResponseEntity;
import witek.marcin.smarthome.pollution.client.model.*;

import java.util.Optional;

public class PollutionRestConverter {

    public static Pollution convertToPollutionObj(ResponseEntity<PollutionData> pollution) {
        Current currentPollution = Optional.ofNullable(pollution.getBody())
                .orElse(new PollutionData()).getCurrent();
        return Pollution.builder()
                .airQualityDescription(getAirlyCaqiDescription(currentPollution))
                .pm25Value(getPollutionValue(currentPollution, "PM25"))
                .pm10Value(getPollutionValue(currentPollution, "PM10"))
                .pm10Percentage(getPollutionInPercentage(currentPollution, "PM10"))
                .pm10Percentage(getPollutionInPercentage(currentPollution, "PM25"))
                .build();
    }

    private static Double getPollutionInPercentage(Current currentPollution, String type) {
        return currentPollution.getStandards()
                .stream()
                .filter(e -> e.getPollutant().equals(type))
                .findFirst()
                .orElse(new Standard()).getPercent();
    }

    private static Double getPollutionValue(Current currentPollution, String type) {
        return currentPollution.getValues()
                .stream()
                .filter(e -> e.getName().equals(type))
                .findFirst()
                .orElse(new Value()).getValue();
    }

    private static String getAirlyCaqiDescription(Current currentPollution) {
        return currentPollution.getIndexes()
                .stream()
                .filter(e->e.getName().equals("AIRLY_CAQI"))
                .findFirst()
                .orElse(new Index()).getDescription();
    }
}
