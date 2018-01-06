import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";	
	
	public static String getFileHeader(int length) 
	{
		String fileHead = "Sort Type";
		for (int i = 1; i <= Quicksort.REPEATS; i++)
		{
			fileHead += ", " + i;
		}
		
		return fileHead;
	}
	
	public static void writeCSV() {
		FileWriter fileWriter = null;
	    
	    try {
		    	fileWriter = new FileWriter("/Users/Ziya/Documents/2017-2018/Quicksort/QuicksortTimes.csv");
		    	
		    	//Write the CSV file header
		    	fileWriter.append("Lomuto, Middle, Mean"); //getFileHeader(Quicksort.ARR_LENGTH));
		   
		    	Quicksort QS = new Quicksort();
		   
		    	Thread.sleep(1000);
		   
		    	//Add a new line separator after the header
		    	fileWriter.append(NEW_LINE_SEPARATOR);
		    fileWriter.append(QS.getRunTimes(Quicksort.LOMUTO));
		    
//		    Thread.sleep(1000);
//		    
//		    fileWriter.append(NEW_LINE_SEPARATOR);
//		    fileWriter.append(QS.getRunTimes(Quicksort.MIDDLE));
//		    
//		    Thread.sleep(1000);
//		    
//		    fileWriter.append(NEW_LINE_SEPARATOR);
//		    fileWriter.append(QS.getRunTimes(Quicksort.MEAN));
		    
		 	System.out.println("CSV file was created successfully");    
	    } catch (Exception e) {
	    	            
		    	System.out.println("Error in CsvFileWriter");   
		    	e.printStackTrace();
		    	        
	    } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
	}
	
	public static void main (String args[]) {
		writeCSV();
	}
}