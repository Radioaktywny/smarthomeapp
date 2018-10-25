
package witek.marcin.smarthome.pollution.client.model;

public class Index {

    private String name;
    private Double value;
    private String level;
    private String description;
    private String advice;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Index{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", advice='" + advice + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
