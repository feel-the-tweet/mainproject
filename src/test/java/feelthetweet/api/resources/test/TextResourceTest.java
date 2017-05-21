package feelthetweet.api.resources.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aylien.textapi.TextAPIException;

import feelthetweet.api.model.Text;
import feelthetweet.model.resource.TextResource;

/* Pruebas automatizadas de los recursos de la API*/

public class TextResourceTest {
	static Text text1,text2,text3;
	static TextResource tr = new TextResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		text1 = tr.addText(new Text("Hotel negative","I didn't liked the hotel, the food was really bad"));
		text2 = tr.addText(new Text("Staff good","My friend thinks that the staff oh the hotel was actually really good"));
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		tr.deleteText(text1.getId());
		tr.deleteText(text2.getId());
	}
	
	@Test
	public void testGetAllTexts() {
		Collection<Text> texts = tr.getAllTexts();
		
		assertNotNull("The collection of texts is null", texts);
		
		System.out.println("Listing all texts:");
		int i=0;
		for (Text t : texts) {
			System.out.println("Text " + i++ + " : " + t.getTitle() + " (ID=" + t.getId() + ")");
		}
	}
	
	@Test
	public void testGetText() throws TextAPIException {
		Text text  = tr.getText(text1.getId());
		
		assertEquals("The id of the text does not match", text1.getId(), text.getId());
		
		System.out.println("Text title: " +  text.getTitle());
		System.out.println("Text content album: " +  text.getContent());
		System.out.println("Text sentiment: " + text.getSentiment());
		System.out.println("Text createdAt: " + text.getCreatedAt());

	}
	
	@Test
	public void testAddText() throws TextAPIException {
		
		String textTitle = "Add text test title";
		String textContent = "Add text test content";
		
		text3 = tr.addText(new Text(textTitle,textContent));
		
		assertNotNull("Error when adding the text", text3);
		
		assertEquals("The text's title has not been setted correctly", textTitle, text3.getTitle());
		assertEquals("The text's content has not been setted correctly", textContent, text3.getContent());


	}
	
	@Test
	public void testUpdateSong() {
		
		String textTitle = "Update song test title";
		String textContent = "Update text test content";
		
		text1.setTitle(textTitle);
		text1.setContent(textContent);

		
		boolean success = tr.updateText(text1);
		
		assertTrue("Error when updating the text", success);
		
		Text text  = tr.getText(text1.getId());
		assertEquals("The text's title has not been updated correctly", textTitle, text.getTitle());
		assertEquals("The text's content has not been updated correctly", textContent, text.getContent());

	}
	
	@Test
	public void testDeleteText() {
		
		boolean success = tr.deleteText(text3.getId());
		
		assertTrue("Error when deleting the text", success);
		
		assertFalse("The text has not been deleted correctly", tr.getAllTexts().contains(text3));
	}
}
