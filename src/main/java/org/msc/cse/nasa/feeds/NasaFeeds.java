package org.msc.cse.nasa.feeds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NasaFeeds {
	
	public static String getFeeds(String query) {
		String endpoint = "http://data.nasa.gov/api/get_search_results/?search=" + query;
		
		HttpURLConnection request = null;
		BufferedReader rd = null;
		StringBuilder response = null;
	
		try{
			URL endpointUrl = new URL(endpoint);
			request = (HttpURLConnection)endpointUrl.openConnection();
			request.setRequestMethod("GET");
			request.connect();
	
			rd  = new BufferedReader(new InputStreamReader(request.getInputStream()));
			response = new StringBuilder();
			String line = null;
			while ((line = rd.readLine()) != null){
				response.append(line + '\n');
			}
		} catch (MalformedURLException e) {
			System.out.println("Exception: " + e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			//e.printStackTrace();
		} finally {
			try{
				request.disconnect();
			} catch(Exception e){
				}
	
			if(rd != null){
				try{
					rd.close();
				} catch(IOException ex){
					}
				rd = null;
			}
		}
		
		return response.toString();
	
	}

}
