
package feelthetweet.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Description {

    private List<Object> urls = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
