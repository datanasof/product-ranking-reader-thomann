package server;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CheckThomann {	
	
	public static String rankProduct(String productName, String url, String path, String ranking, String[] categoryURL) throws IOException {
		String ranking1 = URLRead.getRating(url);
		int position1 = URLRead.getPosition(categoryURL, productName);
		if (!ranking1.equals(ranking)){
			WriteToFile.write(path, ranking1, position1);
			return ranking1;
		}	
		return "";
	}
		
	public static void main(String[] args) throws IOException, InterruptedException {
		WriteToFile.mkDirForReports();
		ArrayList<Product> productList = new ArrayList<Product>();	
		
		for (Product product:ReadFromFile.read(Credentials.productsToCheck)){
			productList.add(product);
		}		
					
		while(true){			
			for(Product product:productList)
			{
				//System.out.println(entry.getKey()+ entry.getValue());
				String productName = product.getName();
				System.out.printf("..reading %s at Thomann.de.", productName);
				System.out.println();
				String url=product.getUrl();
			    String ranking=product.getRanking();
			    String path=product.getFileName();
			    String[] categoryURL = product.getCategoryURL();
			    String result = rankProduct(productName, url, path, ranking, categoryURL);
				if (!result.equals("")){
					product.setRanking(result);
					System.out.printf("..writing changes for %s.", productName);
					System.out.println();
				}								
			}
			TimeUnit.SECONDS.sleep(300);
		}
	}
	
}
