package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile {
	public static ArrayList<Product> read(String filename) throws IOException{
		System.out.printf("..reading from \"%s\"", filename);
		ArrayList<Product> plist = new ArrayList<Product>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		try {			
		    String line = br.readLine();
		    while (line != null) {
		    	String[] sline = line.split(";");
		        Product product = new Product(sline[0],sline[1], sline[2]);
		        plist.add(product);
		        line = br.readLine();
		    }
		    
		} finally {
		    br.close();
		}
		System.out.println();
		System.out.printf("Reading complete. A total of %s products should be checked", plist.size());
		return plist;
	}
	
}
