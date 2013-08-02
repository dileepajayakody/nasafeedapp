package org.msc.cse.nasa.feeds;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.msc.cse.nasa.feed.result.NasaFeedResult;


public class NasaFeedClient {

	private static final String DIGG_SEARCH_ENDPOINT =
            "http://data.nasa.gov/api/get_search_results/";
 
    public static void main(String[] args) throws Exception {
    	//ClientInvoker invoker = new ClientInvoker(DIGG_SEARCH_ENDPOINT, getClass(), "GET", null);
        ClientRequest req = new ClientRequest(DIGG_SEARCH_ENDPOINT);
        req
            .queryParameter("search", "saturn");
        System.out.println(req.getUri());
        ClientResponse<NasaFeedResult> res = req.get(NasaFeedResult.class);
        NasaFeedResult result = res.getEntity();
        System.out.println(result.getCount());
    }
}
