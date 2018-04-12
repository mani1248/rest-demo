package rest_demo.consuming_app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class StatePOJO 
{

	@JsonProperty("id") private int ID;
	@JsonProperty("country") private String country;
	@JsonProperty("name") private String stateName;
	@JsonProperty("abbr") private String stateAbbr;
	@JsonProperty("area") private String stateArea;
	@JsonProperty("capital") private String capitalCity;
	@JsonProperty("largest_city") private String largestCity;
	
	@JsonIgnore private boolean legendary = true;
	
    public String getCapital(){
        return capitalCity;
    }
    
    public void setCapitalCity(String city) {
		this.capitalCity = city;
	}
    
    public String getLargestCity() {
    	return largestCity;
    }

	public void setLargestCity(String city) {
		this.largestCity = city;
	}
}
