
package witek.marcin.smarthome.pollution.client.model;

public class Standard {

    private String name;
    private String pollutant;
    private Double limit;
    private Double percent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "name='" + name + '\'' +
                ", pollutant='" + pollutant + '\'' +
                ", limit=" + limit +
                ", percent=" + percent +
                '}';
    }
}
