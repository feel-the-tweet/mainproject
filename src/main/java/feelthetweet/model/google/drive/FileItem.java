
package feelthetweet.model.google.drive;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class FileItem implements Serializable
{

    private String kind;
    private String id;
    private String etag;
    private String selfLink;
    private String webContentLink;
    private String alternateLink;
    private String embedLink;
    private String iconLink;
    private String thumbnailLink;
    private String title;
    private String mimeType;
    private Labels labels;
    private String createdDate;
    private String modifiedDate;
    private String markedViewedByMeDate;
    private String version;
    private List<Parent> parents = null;
    private String downloadUrl;
    private UserPermission userPermission;
    private String originalFilename;
    private String fileExtension;
    private String md5Checksum;
    private String fileSize;
    private String quotaBytesUsed;
    private List<String> ownerNames = null;
    private List<Owner> owners = null;
    private String lastModifyingUserName;
    private LastModifyingUser lastModifyingUser;
    private Capabilities capabilities;
    private Boolean editable;
    private Boolean copyable;
    private Boolean writersCanShare;
    private Boolean shared;
    private Boolean explicitlyTrashed;
    private Boolean appDataContents;
    private String headRevisionId;
    private List<String> spaces = null;
    private final static long serialVersionUID = -8601006027688796541L;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getWebContentLink() {
        return webContentLink;
    }

    public void setWebContentLink(String webContentLink) {
        this.webContentLink = webContentLink;
    }

    public String getAlternateLink() {
        return alternateLink;
    }

    public void setAlternateLink(String alternateLink) {
        this.alternateLink = alternateLink;
    }

    public String getEmbedLink() {
        return embedLink;
    }

    public void setEmbedLink(String embedLink) {
        this.embedLink = embedLink;
    }

    public String getIconLink() {
        return iconLink;
    }

    public void setIconLink(String iconLink) {
        this.iconLink = iconLink;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Labels getLabels() {
        return labels;
    }

    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getMarkedViewedByMeDate() {
        return markedViewedByMeDate;
    }

    public void setMarkedViewedByMeDate(String markedViewedByMeDate) {
        this.markedViewedByMeDate = markedViewedByMeDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public UserPermission getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(UserPermission userPermission) {
        this.userPermission = userPermission;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getQuotaBytesUsed() {
        return quotaBytesUsed;
    }

    public void setQuotaBytesUsed(String quotaBytesUsed) {
        this.quotaBytesUsed = quotaBytesUsed;
    }

    public List<String> getOwnerNames() {
        return ownerNames;
    }

    public void setOwnerNames(List<String> ownerNames) {
        this.ownerNames = ownerNames;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public String getLastModifyingUserName() {
        return lastModifyingUserName;
    }

    public void setLastModifyingUserName(String lastModifyingUserName) {
        this.lastModifyingUserName = lastModifyingUserName;
    }

    public LastModifyingUser getLastModifyingUser() {
        return lastModifyingUser;
    }

    public void setLastModifyingUser(LastModifyingUser lastModifyingUser) {
        this.lastModifyingUser = lastModifyingUser;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getCopyable() {
        return copyable;
    }

    public void setCopyable(Boolean copyable) {
        this.copyable = copyable;
    }

    public Boolean getWritersCanShare() {
        return writersCanShare;
    }

    public void setWritersCanShare(Boolean writersCanShare) {
        this.writersCanShare = writersCanShare;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Boolean getExplicitlyTrashed() {
        return explicitlyTrashed;
    }

    public void setExplicitlyTrashed(Boolean explicitlyTrashed) {
        this.explicitlyTrashed = explicitlyTrashed;
    }

    public Boolean getAppDataContents() {
        return appDataContents;
    }

    public void setAppDataContents(Boolean appDataContents) {
        this.appDataContents = appDataContents;
    }

    public String getHeadRevisionId() {
        return headRevisionId;
    }

    public void setHeadRevisionId(String headRevisionId) {
        this.headRevisionId = headRevisionId;
    }

    public List<String> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<String> spaces) {
        this.spaces = spaces;
    }

}
