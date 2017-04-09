
package aiss.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Url_ {

    private Object expandedUrl;
    private String url;
    private List<Integer> indices = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Object getExpandedUrl() {
        return expandedUrl;
    }

    public void setExpandedUrl(Object expandedUrl) {
        this.expandedUrl = expandedUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
