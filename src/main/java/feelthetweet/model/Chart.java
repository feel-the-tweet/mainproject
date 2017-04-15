
package feelthetweet.model;

import java.util.List;

public class Chart {

	private String id;
	private String name;
	private List<String> tags = null;
	private Config config;
	private Boolean isPublic;
	private Integer totalViews;
	private String createdAt;
	private String updatedAt;
	private String publicUrl;
	private String versionHash;
	private Images images;
	private Creator creator;
	private Boolean editable;
  
	public Chart(){
	}
	
	public Chart(String id,String name,List<String> tags,Config config,Boolean isPublic,Integer totalViews,String createdAt,String updatedAt,String publicUrl
			,String versionHash,Images images,Creator creator,Boolean editable){
		this.id = id;
		this.name = name;
		this.tags = tags;
		this.config = config;
		this.isPublic = isPublic;
		this.totalViews = totalViews;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.publicUrl = publicUrl;
		this.versionHash = versionHash;
		this.images = images;
		this.creator = creator;
		this.editable = editable;
	}
	
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(Integer totalViews) {
        this.totalViews = totalViews;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public String getVersionHash() {
        return versionHash;
    }

    public void setVersionHash(String versionHash) {
        this.versionHash = versionHash;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

}
