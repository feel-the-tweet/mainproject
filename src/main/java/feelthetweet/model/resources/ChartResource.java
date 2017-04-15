package feelthetweet.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import feelthetweet.model.Chart;

public class ChartResource {

	private String uri = "https://api.chartblocks.com/v1/chart";
	
	public Collection<Chart> getAll() {
		
		ClientResource cr = null;
		Chart [] charts = null;
		try {
			cr = new ClientResource(uri);
			charts = cr.get(Chart[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the list of charts: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(charts);
	}
	
	public Chart getChart(String chartId) {
		ClientResource cr = null;
		Chart chart = null;
		try {
			cr = new ClientResource(uri + "/" + chartId);
			chart = cr.get(Chart.class);
		
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the chart with ID: "+ chartId +"--"+cr.getResponse().getStatus());
		}
	
		return chart;
	}

	public Chart addChart(Chart chart) {
		ClientResource cr = null;
		Chart resultChart = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			resultChart = cr.post(resultChart,Chart.class);
		
		} catch (ResourceException re) {
			System.err.println("Error when adding the Chart"+cr.getResponse().getStatus());
		}
	
		return resultChart;
	}
	
	public Chart updateChart(Chart chart) {
		ClientResource cr = null;
		Chart updatedChart = null;
		try {
			cr = new ClientResource(uri + "/" + chart.getId());
			cr.setEntityBuffering(true);
			cr.put(chart);
			updatedChart = getChart(chart.getId());
		
		} catch (ResourceException re) {
			System.err.println("Error when updating the Chart"+cr.getResponse().getStatus());
		}
	
		return updatedChart;
	}
	
	public boolean deleteChart(String chartId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + chartId);
			cr.setEntityBuffering(true);
			cr.delete();
		
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Chart"+cr.getResponse().getStatus());
			success=false;
			throw re;
		}
	
		return success;
	}
	
	

}
