
package aiss.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Url {

    private List<Url_> urls = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Url_> getUrls() {
        return urls;
    }

    public void setUrls(List<Url_> urls) {
        this.urls = urls;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
