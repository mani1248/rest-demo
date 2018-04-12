package rest_demo.execute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rest_demo.consuming_app.StatePOJO;
import rest_demo.consuming_app.StateResource;

public class Execute {

	public static void main(String args[]) throws IOException {
		
		String st, input;
		Boolean run = true;
		StatePOJO spojo = new StatePOJO();
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		while(run == true){
			System.out.print("Please enter State name or abbreviation. To quit, enter 'Quit': ");
			input = reader.readLine();
			/*
			 * Following code check the user input to proceed further
			 */
			if(input.matches("Quit")||input.matches("QUIT")||input.matches("quit")) {
				run = false;
			}else {
					if(isAlpha(input)) {
						if(input.length()>2||input.length()<2)
						st = convertToAbbr(input);
						else st = input.toUpperCase();
						spojo = StateResource.getCities(st);
						if(spojo.getCapital() == null) {
							System.out.println("No results found.");
						}else {
							System.out.println("The capital city is: " + spojo.getCapital());
							System.out.println("The largest city is: " + spojo.getLargestCity());
						}
					}else {
						System.out.println("Invalid input");
					}
				}
		}
		
	}
	
	/*
	 * This method checks if the input is all alphabets
	 */
	private static boolean isAlpha(String input) {
		if(input.matches("u.s. virgin islands")||input.matches("U.S. Virgin Islands")||input.matches("U.S. VIRGIN ISLANDS")) {
			return true;
		}else {
			Pattern p = Pattern.compile("^[ A-Za-z]+$");
			Matcher m = p.matcher(input);
			boolean b = m.matches();
			return b;
		}	
	}

	/*
	 * This function converts valid user input to 2 letter state abbreviation
	 */
	public static String convertToAbbr(String state) {
		String abbr;
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("alabama","AL");
		hm.put("alaska","AK");
		hm.put("arizona","AZ");
		hm.put("arkansas","AR");
		hm.put("california","CA");
		hm.put("colorado","CO");
		hm.put("connecticut","CT");
		hm.put("delaware","DE");
		hm.put("florida","FL");
		hm.put("georgia","GA");
		hm.put("hawaii","HI");
		hm.put("idaho","ID");
		hm.put("illinois","IL");
		hm.put("indiana","IN");
		hm.put("iowa","IA");
		hm.put("kansas","KS");
		hm.put("kentucky","KY");
		hm.put("louisiana","LA");
		hm.put("maine","ME");
		hm.put("maryland","MD");
		hm.put("massachusetts","MA");
		hm.put("michigan","MI");
		hm.put("minnesota","MN");
		hm.put("mississippi","MS");
		hm.put("missouri","MO");
		hm.put("montana","MT");
		hm.put("nebraska","NE");
		hm.put("nevada","NV");
		hm.put("new hampshire","NH");
		hm.put("new jersey","NJ");
		hm.put("new mexico","NM");
		hm.put("new york","NY");
		hm.put("north carolina","NC");
		hm.put("north dakota","ND");
		hm.put("ohio","OH");
		hm.put("oklahoma","OK");
		hm.put("oregon","OR");
		hm.put("pennsylvania","PA");
		hm.put("rhode island","RI");
		hm.put("south carolina","SC");
		hm.put("south dakota","SD");
		hm.put("tennessee","TN");
		hm.put("texas","TX");
		hm.put("utah","UT");
		hm.put("vermont","VT");
		hm.put("u.s. virgin islands","VI");
		hm.put("virginia","VA");
		hm.put("washington","WA");
		hm.put("west virginia","WV");
		hm.put("wisconsin","WI");
		hm.put("wyoming","WY");
		hm.put("american samoa","AS");
		hm.put("guam","GU");
		hm.put("northern mariana islands","MP");
		hm.put("puerto rico","PR");
		
		if(state == "u.s. virgin islands"||state == "U.S. Virgin Islands"||state == "U.S. VIRGIN ISLANDS") {
			return "VI";
		}else {
			state = state.toLowerCase();
			abbr = hm.get(state);
			return abbr;
		}	
	}
}
