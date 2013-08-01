package org.msc.cse.nasa.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class NasafeedTest {

	@Test
	public void testFeedQuery() throws Exception {

		URL endpointUrl = new URL(
				"http://data.nasa.gov/api/get_search_results/?search=saturn");
		HttpURLConnection request = (HttpURLConnection) endpointUrl
				.openConnection();
		request.setRequestMethod("GET");
		request.connect();
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		StringBuilder response = new StringBuilder();	
		String line = null;
		while ((line = rd.readLine()) != null) {
			response.append(line + '\n');
		}
		assertFalse(response.toString().equals(""));
		System.out.println("Test response for query search=saturn :\n" +response);
		request.disconnect();
		rd.close();

	}
}
