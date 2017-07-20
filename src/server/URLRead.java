package server;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

public class URLRead {	
	
	public static String getMoreHTML(String url) throws IOException{
		URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		StringBuilder sb = new StringBuilder();       
		String inputLine;
        
		while ((inputLine = in.readLine()) != null)
        	sb.append(inputLine);
        
		in.close();        
        return sb.toString();
	}
	
	public static int findPosition(String url, String productName) throws IOException{
		int position=0;
		Document doc = Jsoup.connect(url).get(); 
		Elements myin = doc.getElementsByClass("modelName");
				
		for(int i=0; i<myin.size(); i++){
			if(myin.get(i).text().equals(productName)){
				position=i+1;
				return position;
			}
		}
		return position;
	}
	
	public static int getPosition(String[] urls, String productName) throws IOException{
		int position = 0;		
		for(String url:urls){
			Integer check = findPosition(url, productName);
			if (!check.equals(0)){
				position += check;
				return position;
			}
			position += 100;					
		}
		return 0;
	}

	private static List<String> getTagValues(String str, String regx) {
		final Pattern TAG_REGEX = Pattern.compile(regx);
	    final List<String> tagValues = new ArrayList<String>();
	    final Matcher matcher = TAG_REGEX.matcher(str);
		try{			
		    while (matcher.find()) {
		        tagValues.add(matcher.group(1));
		    }
		    return tagValues;
		} catch (Exception e){
			System.out.println("NO product info found");
		}
		return tagValues;
	}
	
	public static String getRating(String url) throws IOException{        
		String str = getMoreHTML(url);
		String result;
		List<String> deviceRating = new ArrayList<String>();
		try{
			deviceRating = getTagValues(str, "<div class=\"rank\">(.+?)<\\/div>");
			result = ("Category ranking: " + deviceRating.get(0) + ", Website ranking: " + deviceRating.get(1));
		} catch(Exception e){
			result = "NO product info found";
		}
		return result;
	}

	
}