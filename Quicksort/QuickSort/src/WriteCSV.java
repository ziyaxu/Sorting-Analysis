import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
	
	public static final String NEW_LINE_SEPARATOR = "\n";	
	
	public static String getFileHeader(int length) 
	{
		String fileHead = "Sort Type";
		for (int i = 1; i <= Quicksort.REPEATS; i++)
		{
			fileHead += ", " + i;
		}
		
		return fileHead;
	}
	
	public static void writeCSV() throws IOException {
		FileWriter fileWriter = null;
	    
	    try {
		    	fileWriter = new FileWriter("/Users/Ziya/Documents/2017-2018/Quicksort/QuicksortTimes.csv");
		    	
		    	//Write the CSV file header
		    	fileWriter.append(", Lomuto, Middle, Mean");
		   
		    	Quicksort QS = new Quicksort();
		   
		    	//Add a new line separator after the header
		    	fileWriter.append(NEW_LINE_SEPARATOR);
		    fileWriter.append(QS.getRunTimes());

		 	System.out.println("CSV file created");  
		 	
	    } catch (Exception e) {
		    	System.out.println("Error");   
		    	e.printStackTrace();	        
	    }
	    
	    fileWriter.close();
	}
	
	public static void main (String args[]) throws IOException {
		writeCSV();
	}
}