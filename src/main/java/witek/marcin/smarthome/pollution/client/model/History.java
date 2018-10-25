
package witek.marcin.smarthome.pollution.client.model;

import java.util.List;

public class History {

    private String fromDateTime;
    private String tillDateTime;
    private List<Value> values = null;
    private List<Index> indexes = null;
    private List<Standard> standards = null;

    public String getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(String fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public String getTillDateTime() {
        return tillDateTime;
    }

    public void setTillDateTime(String tillDateTime) {
        this.tillDateTime = tillDateTime;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public List<Index> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Index> indexes) {
        this.indexes = indexes;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public void setStandards(List<Standard> standards) {
        this.standards = standards;
    }

    @Override
    public String toString() {
        return "History{" +
                "fromDateTime='" + fromDateTime + '\'' +
                ", tillDateTime='" + tillDateTime + '\'' +
                ", values=" + values +
                ", indexes=" + indexes +
                ", standards=" + standards +
                '}';
    }
}
