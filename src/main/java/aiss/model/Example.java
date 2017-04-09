
package aiss.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

    private List<Status> statuses = null;
    private SearchMetadata searchMetadata;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public SearchMetadata getSearchMetadata() {
        return searchMetadata;
    }

    public void setSearchMetadata(SearchMetadata searchMetadata) {
        this.searchMetadata = searchMetadata;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
