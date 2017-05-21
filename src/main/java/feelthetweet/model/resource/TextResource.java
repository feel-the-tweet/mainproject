package feelthetweet.model.resource;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import feelthetweet.api.model.Text;

public class TextResource {

	private String uri = "http://feelthetweet.appspot.com/api/texts";
	//private String uri = "http://localhost:8090/api/texts";

	
	public Collection<Text> getAllTexts() {
		ClientResource cr = null;
		Text [] texts = null;
		try {
			cr = new ClientResource(uri);
			texts = cr.get(Text[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all texts: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(texts);
	}
	

	public Text getText(String textId) {
		ClientResource cr = null;
		Text text = null;
		try {
			cr = new ClientResource(uri + "/" + textId);
			text = cr.get(Text.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the Text: " + cr.getResponse().getStatus());
		}
		
		return text;
	}
	

	public Text addText(Text text) {
		ClientResource cr = null;
		Text resultText = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			resultText = cr.post(text,Text.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the Text: " + cr.getResponse().getStatus());
		}
		
		return resultText;

	}
	
	public boolean updateText(Text text) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(text);
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the Text: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	

	public boolean deleteText(String textId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + textId);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the text: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
}
