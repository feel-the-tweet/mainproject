
package feelthetweet.model.google.drive;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Picture implements Serializable
{

    private String url;
    private final static long serialVersionUID = 3341173399787116007L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
