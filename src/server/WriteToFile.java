package server;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.GregorianCalendar;

public class WriteToFile {
	
	public static String write(String filepath, String textToAdd, int position, String price) throws IOException{
		File f = new File(filepath);
		if(!f.exists()) { 
			f.createNewFile(); // if file already exists will do nothing 
			
		}
		
		Date time=new GregorianCalendar().getTime();
		Writer output;
		output = new BufferedWriter(new FileWriter(filepath, true));  //clears file every time
		String result = time + "// " + textToAdd + "; Category position = "+ position + "; Price(EUR) = " + price + "\r\n";
		output.append(result);
		output.close();
		return result;
	}
	
	public static void mkDirForReports(){
		File theDir = new File(Credentials.reportsCategory);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("creating directory: " + theDir.getName());
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        //handle it
		    }        
		    if(result) {    
		        System.out.println("DIR created");  
		    }
		}
	}
	
}
