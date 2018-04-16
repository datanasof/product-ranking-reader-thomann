package server;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class URLRead {	
	
	public static int findPosition(String url, String productName) throws IOException{
		int position=0;
		Document doc = Jsoup.connect(url).get(); 
		Elements myin = doc.getElementsByClass("model");
				
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
	
	public static String getRating(String url){        
		String result;
		List<String> values = new ArrayList<String>();
		try{
			Document doc = Jsoup.connect(url).get(); 
			Elements myin = doc.select("div.ranking");
			Pattern p = Pattern.compile("-?\\d+");
			Matcher m = p.matcher(myin.text());
			while (m.find()) {
				values.add(m.group());
			}
			result = ("Category ranking: " + values.get(0) + ", Website ranking: " + values.get(1));
		} catch(Exception e){
			result = "NO product info found";
		}		
		return result;
	}
	
	public static String priceParser(String url) throws IOException{	
		String price;
		Document doc = Jsoup.connect(url).get();
		Element span = doc.select(Credentials.priceParserTag).first();
		if(span != null) {
			price = span.text();
		} else price = "";
		return price;		
	}
	
	public static double priceEditor(String price){
		String parsed = price.replaceAll("[^\\d.]+", "");
		double newPrice = Double.parseDouble(parsed);
		return newPrice;
	}
		
}