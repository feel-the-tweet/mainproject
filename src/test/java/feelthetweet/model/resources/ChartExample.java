package feelthetweet.model.resources;

import feelthetweet.model.Chart;
import feelthetweet.model.resources.ChartResource;

public class ChartExample {

	public static void main(String[] args) {
		
		ChartResource cr = new ChartResource();
		Chart chart = cr.getChart("58f2584c9973d2701b7c2a9c");
		
		System.out.println(chart.getName());

	}

}
