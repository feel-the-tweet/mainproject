package feelthetweet.model.resource;

import java.util.Map;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;

import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import feelthetweet.model.google.drive.FileItem;
import feelthetweet.model.google.drive.Files;

public class GoogleDriveResource {
	private static final Logger log=Logger.getLogger(GoogleDriveResource.class.getName());
	
	private String uri = "https://www.googleapis.com/drive/v2/files";
	private String access_token;
	private String uri_upload = "https://www.googleapis.com/upload/drive/v2/files";

	public GoogleDriveResource(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * 
	 * @return Files
	 */
	public Files getFiles() {
		ClientResource cr = null;
		Files files = null;
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			files = cr.get(Files.class);

		} catch (ResourceException re) {
			log.warning("Error when retrieving all files: " + cr.getResponse().getStatus());
		}

		return files;

	}

	public FileItem getFile(String id) {

		ClientResource cr = null;
		FileItem file = null;
		try {
			cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
			file = cr.get(FileItem.class);

		} catch (ResourceException re) {
			log.warning("Error when retrieving file: " + cr.getResponse().getStatus());
		}

		return file;

	}

	public String insertFile(FileItem file, String content) {

		ClientResource cr = null;
		String newId = null;
		try {
			cr = new ClientResource(uri + "?access_token=" + access_token);
			FileItem newFile = cr.post(file, FileItem.class);
			newId = newFile.getId();
			cr = new ClientResource(uri_upload + "/" + newId + "?uploadType=media&access_token=" + access_token);
			Map<String, Object> headers = cr.getRequestAttributes();
			headers.put("Content-Type", "text/plain");
			cr.put(content);
		} catch (ResourceException re) {
			log.warning("Error when inserting file: " + cr.getResponse().getStatus());
		}
		return newId;
	}

	public boolean updateFile(FileItem file) {

		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri + "/" + file.getId() + "?access_token=" + access_token);
			cr.put(file);
		} catch (ResourceException re) {
			log.warning("Error when updating file: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;
	}

	public boolean deleteFile(String id) {

		ClientResource cr = null;
		boolean result = true;
		try {
			cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
			cr.delete();
		} catch (ResourceException re) {
			log.warning("Error when deleting file: " + cr.getResponse().getStatus());
			result = false;
		}
		return result;

	}

	public String getFileContent(FileItem item){
		String result=null;
		String contentURL=item.getDownloadUrl();
		try{
			ClientResource cr = new ClientResource(contentURL);			
			ChallengeResponse chr = new ChallengeResponse(
					ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
			cr.setChallengeResponse(chr);
			
			result=cr.get(String.class);
		} catch (ResourceException re) {
			log.warning("Error when obtaining content of file: " + item.getId());			
		}
		return result;
	}
	
	public boolean updateFileContent(String id,String content){
		ClientResource cr=new ClientResource(uri_upload+"/"+id+ "?uploadType=media");
		try{
			ChallengeResponse chr = new ChallengeResponse(
					ChallengeScheme.HTTP_OAUTH_BEARER);
			chr.setRawValue(access_token);
			cr.setChallengeResponse(chr);
			StringRepresentation rep=new StringRepresentation(content,MediaType.TEXT_PLAIN);
			cr.put(rep);
		} catch (ResourceException re) {
			log.warning("Error when updating the content of file: " + id);
			log.warning(re.getMessage());
			return false;
		}
		return true;
	}

}
