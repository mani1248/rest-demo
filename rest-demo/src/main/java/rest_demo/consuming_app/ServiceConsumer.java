package rest_demo.consuming_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceConsumer {
	/*
	 * This methods call the web service, reads the response and copies data to StatePOJO	
	 */
	public static StatePOJO consumerService(String targetURL) {
		
		StatePOJO spojo = new StatePOJO();
		try {
			URL url = new URL(targetURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader buff = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String response;
			StringBuilder sb = new StringBuilder();
			while((response = buff.readLine()) != null) {
				sb.append(response);
			}
			buff.close();
			JSONObject json = new JSONObject(sb.toString());
			JSONObject restresponse = json.getJSONObject("RestResponse");			
			JSONObject result = restresponse.getJSONObject("result");
			
			spojo.setCapitalCity(result.getString("capital"));
			spojo.setLargestCity(result.getString("largest_city"));	
		} catch (IOException |JSONException j) {
			if(j.getMessage().contains("JSONObject[\"result\"] not found.")) {
				return spojo;
			}
//			j.printStackTrace();
		}
		return spojo;
	}
}
