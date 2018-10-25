
package witek.marcin.smarthome.pollution.client.model;

import java.util.List;

public class PollutionData {

    private Current current;
    private List<History> history = null;
    private List<Forecast> forecast = null;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "PollutionData{" +
                "current=" + current +
                ", history=" + history +
                ", forecast=" + forecast +
                '}';
    }
}
