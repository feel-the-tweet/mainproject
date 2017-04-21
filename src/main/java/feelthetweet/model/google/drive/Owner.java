
package feelthetweet.model.google.drive;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Owner implements Serializable
{

    private String kind;
    private String displayName;
    private Picture picture;
    private Boolean isAuthenticatedUser;
    private String permissionId;
    private String emailAddress;
    private final static long serialVersionUID = -2773173545042663275L;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Boolean getIsAuthenticatedUser() {
        return isAuthenticatedUser;
    }

    public void setIsAuthenticatedUser(Boolean isAuthenticatedUser) {
        this.isAuthenticatedUser = isAuthenticatedUser;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
