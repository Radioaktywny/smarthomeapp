package witek.marcin.smarthome.pollution.client.api;

import witek.marcin.smarthome.pollution.client.rest.PollutionRestClient;

public class AirlyPollutionRetriever implements PollutionRetriever {

    private final PollutionRestClient pollutionRestClient;

    public AirlyPollutionRetriever(PollutionRestClient pollutionRestClient) {
        this.pollutionRestClient = pollutionRestClient;
    }

    @Override
    public Pollution getPollution(GPSLocation location) {
        return PollutionRestConverter.convertToPollutionObj(
                pollutionRestClient.getPollution(location.getLatitude(), location.getLongitude()));
    }
}
