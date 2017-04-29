package feelthetweet.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;
import org.jboss.resteasy.spi.WriterException;

import com.aylien.textapi.TextAPIException;

import feelthetweet.api.model.Text;
import feelthetweet.api.model.repository.AnalysisRepository;
import feelthetweet.api.model.repository.MapAnalysisRepository;

import java.net.URI;
import java.util.Collection;


@Path("/texts")
public class TextResource {

	public static TextResource _instance=null;
	AnalysisRepository repository;
	
	private TextResource() throws TextAPIException{
		repository=MapAnalysisRepository.getInstance();
	}
	
	public static TextResource getInstance() throws TextAPIException{
		if(_instance==null)
			_instance=new TextResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Text> getAllTexts()
	{
		return repository.getAllTexts();
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Text get(@PathParam("id") String textId)
	{
		Text text = repository.getText(textId);
		
		if (text == null) {
			throw new NotFoundException("The text with id="+ textId +" was not found");			
		}
		
		return text;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addText(@Context UriInfo uriInfo, Text text) {
		if (text.getTitle() == null || "".equals(text.getTitle()))
			throw new BadRequestException("The name of the text must not be null");
		if(getAllTexts().contains(text)){
			throw new WriterException("The text already exists");
		}
		
		repository.addText(text);

		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(text.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(text);			
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateText(Text text) {
		Text oldText = repository.getText(text.getId());
		if (oldText == null) {
			throw new NotFoundException("The text with id="+ text.getId() +" was not found");			
		}
		
		// Update title
		if (text.getTitle()!=null)
			oldText.setTitle(text.getTitle());
		
		// Update Content
		if (text.getContent()!=null)
			oldText.setContent(text.getContent());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteText(@PathParam("id") String textId) {
		Text toberemoved=repository.getText(textId);
		if (toberemoved == null){
			throw new NotFoundException("The text with id="+ textId +" was not found");
		}else {
			repository.deleteText(textId);
		}
		
		return Response.noContent().build();
	}
	
}
