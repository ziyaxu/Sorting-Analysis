import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";	
	
	public static String getFileHeader(int length) 
	{
		String fileHead = "Sort Type";
		for (int i = 1; i <= 100; i++)
		{
			fileHead += ", " + i;
		}
		
		return fileHead;
	}
	
	public static void writeCSV(String[] times) {
		FileWriter fileWriter = null;
	    
	    try {
		    	fileWriter = new FileWriter("/Users/Ziya/Documents/2017-2018/Quicksort/QuicksortTimes.csv");
		    	
		    	//Write the CSV file header
		   fileWriter.append(getFileHeader(Quicksort.ARR_LENGTH));
		   
		    	//Add a new line separator after the header
		    	fileWriter.append(NEW_LINE_SEPARATOR);
		    fileWriter.append(LomutoQuicksort.runLoops(Quicksort.REPEATS));
		    
		    fileWriter.append(NEW_LINE_SEPARATOR);
		    fileWriter.append(MiddleQuicksort.runLoops(Quicksort.REPEATS));
		    
		    fileWriter.append(NEW_LINE_SEPARATOR);
		    fileWriter.append(MeanQuicksort.runLoops(Quicksort.REPEATS));
		    
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
}