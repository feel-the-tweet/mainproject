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
		
		Text text1=new Text();
		text1.setTitle("Pet");
		text1.setContent("I would like to have a pet");
		addText(text1);
		
		Text text2=new Text();
		text2.setTitle("Machine Learning");
		text2.setContent("Machines are about to get a lot smarter and machine learning will transform our lives. "
				+ "So says a report by the Royal Society in the UK, a fellowship of many of the world's most eminent scientists."
				+ " Machine learning is a form of artificial intelligence that's already being used to tag people in photos, to interpret voice "
				+ "commands and to help "
				+ "internet retailers to make recommendations.Manuela Saragosa hears about "
				+ "a new technology that is set to revolutionise computing, developed by a "
				+ "UK company called Graphcore. Manuela talks to Graphcore's chief executive Nigel Toon, who is taking on the"
				+ " AI giants.And Manuela hears how we are 'bleeding data' all the time. Dr Joanna Bryson from the University of "
				+ "Bath and professor Amanda Chessell, an IBM distinguished engineer and master inventor, explain how our data is "
				+ "being used.");
		addText(text2);
		
		Text text3=new Text();
		text3.setTitle("Hotel");
		text3.setContent("I liked the hotel, the food was really good");
		addText(text3);
		
		Text text4=new Text();
		text4.setTitle("Marks");
		text4.setContent("I hope this API and its documentation help us improve our marks");
		addText(text4);
		
		Text text5=new Text();
		text5.setTitle("Group");
		text5.setContent("My group is the best");
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
		
	}

	@Override
	public void deleteText(String textId) {
		textMap.remove(textId);
		
	}
	
}
