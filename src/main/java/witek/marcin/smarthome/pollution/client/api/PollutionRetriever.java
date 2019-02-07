package witek.marcin.smarthome.pollution.client.api;

public interface PollutionRetriever {
    
    Pollution getPollution(GPSLocation location);
    
}
