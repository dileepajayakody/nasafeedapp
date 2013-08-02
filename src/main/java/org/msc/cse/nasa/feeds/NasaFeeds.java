package org.msc.cse.nasa.feeds;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.msc.cse.nasa.feed.result.NasaFeedResult;

public class NasaFeeds {
	
	private static final String DIGG_SEARCH_ENDPOINT =
            "http://data.nasa.gov/api/get_search_results/";
	
	public static NasaFeedResult getFeeds(String query) {
		ClientRequest req = new ClientRequest(DIGG_SEARCH_ENDPOINT);
        req
            .queryParameter("search", query);
        ClientResponse<NasaFeedResult> res = null;
		try {
			res = req.get(NasaFeedResult.class);
		} catch (Exception e) {
			
		}
		if (res != null) {
			NasaFeedResult result = res.getEntity();
			return result;
		}
		
		return null;
	
	}

}
