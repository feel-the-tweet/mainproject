
package aiss.model;

import java.util.HashMap;
import java.util.Map;

public class Entities_ {

    private Url url;
    private Description description;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
