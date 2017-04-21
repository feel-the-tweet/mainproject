
package feelthetweet.model.google.drive;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Files implements Serializable
{

    private String kind;
    private String etag;
    private String selfLink;
    private String nextPageToken;
    private String nextLink;
    private Boolean incompleteSearch;
    private List<FileItem> items = null;
    private final static long serialVersionUID = -82441093946662476L;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }

    public Boolean getIncompleteSearch() {
        return incompleteSearch;
    }

    public void setIncompleteSearch(Boolean incompleteSearch) {
        this.incompleteSearch = incompleteSearch;
    }

    public List<FileItem> getItems() {
        return items;
    }

    public void setItems(List<FileItem> items) {
        this.items = items;
    }

}
