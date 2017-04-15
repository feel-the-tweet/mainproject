
package feelthetweet.model;

import java.util.HashMap;
import java.util.Map;

public class Images {

    private Png png;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Png getPng() {
        return png;
    }

    public void setPng(Png png) {
        this.png = png;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
