package org.msc.cse.nasa.feeds;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import com.google.gson.Gson;
import org.msc.cse.nasa.feed.result.NasaFeedResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class NasaFeeds {
	
	private static final String DIGG_SEARCH_ENDPOINT =
            "http://data.nasa.gov/api/get_search_results/";
	
	public static NasaFeedResult getFeeds(String query) {
		ClientRequest req = new ClientRequest(DIGG_SEARCH_ENDPOINT);
        req.queryParameter("search", query);
        ClientResponse<NasaFeedResult> res = null;
		try {
			res = req.get(NasaFeedResult.class);
		} catch (Exception e) {
			
		}
		if (res != null) {
			NasaFeedResult result = res.getEntity();
			
			Gson gson = new Gson();
			String gsonQuery = gson.toJson(result);
			try{
				updateDB(query, gsonQuery);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			return result;
		}
		
		return null;
	
	}
	
	public static void updateDB(String query, String response) throws SQLException, URISyntaxException{
		
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		
		String appendedQuery = "INSERT INTO QueryHistory(Query_String,Query_Result) VALUES('" + query + "','" + response + "')";
		
		int ret_val = stmt.executeUpdate(appendedQuery);
		
		//appendedQuery = "DELETE FROM QueryHistory WHERE Query_Id NOT IN (SELECT Query_Id FROM (SELECT Query_Id FROM QueryHistory ORDER BY Query_Id DESC LIMIT 10) temp)";
	}
	
	public static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

}
