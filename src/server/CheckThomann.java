package server;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CheckThomann {	
	
	public static String[] checkProduct(String productName, String url, String path, String ranking, String price, String[] categoryURL) throws IOException {
		
		String ranking1 = URLRead.getRating(url);
		int position1 = URLRead.getPosition(categoryURL, productName);
		String price1 = URLRead.priceParser(url);
		if (!ranking1.equals(ranking) ){
			String[] result = {ranking1, price1, "Ranking CHANGE// " + WriteToFile.write(path, ranking1, position1, price1)};
			return result;
		} else if(!price1.equals(price)){
			String[] result = {ranking1, price1, "Pricing CHANGE// " + WriteToFile.write(path, ranking1, position1, price1)};
			return result;
		}
		
		String[] empty = {"",""};
		return empty;
	}
		
	public static void main(String[] args) throws IOException, InterruptedException {
		WriteToFile.mkDirForReports();
		ArrayList<Product> productList = new ArrayList<Product>();	
		
		for (Product product:ReadFromFile.read(Credentials.productsToCheck)){
			productList.add(product);
		}		
		
		int counter = 0;				
		while(true){				
			boolean trigger = false;
			ArrayList<String> report = new ArrayList<String>();
			for(Product product:productList){				
				String productName = product.getName();
				System.out.printf("..reading %s at Thomann.de.", productName);
				System.out.println();
				String url=product.getUrl();
			    String ranking=product.getRanking();
			    String path=product.getFileName();
			    String price = product.getPrice();
			    String[] categoryURL = product.getCategoryURL();
			    String[] result = checkProduct(productName, url, path, ranking, price, categoryURL);
				if (!result[0].equals("")){
					trigger = true;
					report.add(product.getName()+": "+result[2]);
					product.setRanking(result[0]);
					product.setPrice(result[1]);
					System.out.printf("..writing changes for %s.", productName);
					System.out.println();					
				}								
			}
			
			if(trigger&&counter>=1){
				StringBuilder sb = new StringBuilder();
				for(String s:report){
					sb.append(s);
				}				
				String body =  sb.toString();
				String subject = "AA products rating change at Thomann.de";
				SendMail.sendFromGMail(subject, body);
				System.out.println("Sending email report");
			}
			counter++;
			TimeUnit.SECONDS.sleep(300);
		}
	}
	
}
