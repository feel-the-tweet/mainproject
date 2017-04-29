package feelthetweet.api.model.repository;

import java.util.Collection;

import feelthetweet.api.model.Text;

public interface AnalysisRepository {
	
	// Texts
	public void addText(Text t);
	public Collection<Text> getAllTexts();
	public Text getText(String textId);
	public void updateText(Text t);
	public void deleteText(String textId);

}
