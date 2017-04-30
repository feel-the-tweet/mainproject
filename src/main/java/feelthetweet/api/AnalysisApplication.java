package feelthetweet.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.aylien.textapi.TextAPIException;

import feelthetweet.api.resources.TextResource;


public class AnalysisApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	// Loads all resources that are implemented in the application
	// so that they can be found by RESTEasy.
	public AnalysisApplication() throws TextAPIException {

		singletons.add(TextResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
