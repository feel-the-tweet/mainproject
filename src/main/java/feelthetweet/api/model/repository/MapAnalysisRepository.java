package feelthetweet.api.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import org.w3c.dom.ls.LSOutput;

import com.aylien.textapi.TextAPIException;

import feelthetweet.api.model.Text;



public class MapAnalysisRepository implements AnalysisRepository{

	Map<String, Text> textMap;
	private static MapAnalysisRepository instance=null;
	private int index=0;			// Index to create texts' ids
	
	public static MapAnalysisRepository getInstance() throws TextAPIException {
		
		if (instance==null) {
			instance = new MapAnalysisRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() throws TextAPIException {
		
		textMap = new HashMap<String,Text>();
		
		// Create songs
		Text text1=new Text();
		text1.setTitle("Rolling in the Deep");
		text1.setContent("Adele");
		//text1.setSentiment();
		addText(text1);
		
		Text text2=new Text();
		text2.setTitle("One");
		text2.setContent("U2");
		//text2.setSentiment();
		addText(text2);
		
		Text text3=new Text();
		text3.setTitle("Hotel");
		text3.setContent("I liked the hotel, the food was really good");
		//text3.setSentiment();
		addText(text3);
		
		Text text4=new Text();
		text4.setTitle("Smell Like Teen Spirit");
		text4.setContent("Nirvana");
		//text4.setSentiment();
		addText(text4);
		
		Text text5=new Text();
		text5.setTitle("Someone that I used to know");
		text5.setContent("Gotye");
		//text5.setSentiment();
		addText(text5);
	}

	@Override
	public void addText(Text t) {
		String id = String.valueOf(index++);
		t.setId(id);
		textMap.put(id, t);
		
	}

	@Override
	public Collection<Text> getAllTexts() {
		return textMap.values();
	}

	@Override
	public Text getText(String textId) {
		return textMap.get(textId);
	}

	@Override
	public void updateText(Text t) {
		
		Text text = textMap.get(t.getId());
		text.setTitle(t.getTitle());
		text.setContent(t.getContent());
		/*try {
			text.setTitle(t.getTitle());
			text.setContent(t.getContent());
			//text.setSentiment();
			
		} catch (TextAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
	}

	@Override
	public void deleteText(String textId) {
		textMap.remove(textId);
		
	}
	
}
