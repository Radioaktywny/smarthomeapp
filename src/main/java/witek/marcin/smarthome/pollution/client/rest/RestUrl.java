package witek.marcin.smarthome.pollution.client.rest;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Data
public class RestUrl {

    private static final String PATH_PARAMETERS_DELIMITER = "?";
    private static final String PARAMETERS_DELIMITER = "&";

    private String path;
    private Map<String, String> parameters = new HashMap<>();

    static RestUrl builder() {
        return new RestUrl();
    }

    RestUrl withPath(String path) {
        this.path = path;
        return this;
    }

    RestUrl addParameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    String build() {
        return this.toString();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(path).append(PATH_PARAMETERS_DELIMITER);
        parameters.entrySet().stream()
                .map(mapEntryForParameter())
                .forEach(builder::append);
        builder.deleteCharAt(builder.length() - 1 );
        return builder.toString();
    }

    private Function<Map.Entry<String, String>, String> mapEntryForParameter() {
        return e -> e.getKey() + "=" + e.getValue() + PARAMETERS_DELIMITER;
    }
}
