import java.util.Random;

public class Quicksort {
	
	public static final int ARR_LENGTH = 10000;
	public static final int ARR_RANGE = 1000;
	public static final int REPEATS = 50;
	
	public static final String LOMUTO = "Lomuto";
	public static final String MIDDLE = "Middle";
	public static final String MEAN = "Mean";
	
	private static int[] arr = new int[ARR_LENGTH];
	
    /**
     * prints array
     * @param arr
     */
    public void printArray()
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    /**
     * creates a random array of a specified length
     * @return random array
     */
    public void ranArr() {
    		Random rand = new Random(); 

    		for (int i = 0; i < ARR_LENGTH; i++)
    			arr[i] = rand.nextInt(ARR_RANGE);
    }
    
    /**
     * swaps value at index i with value at index j in an array
     * @param i
     * @param j
     * @param array
     */
    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * uses last element as pivot
     * all elements that are smaller are put to the left
     * all elements that are larger are put to the right
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int lomutoPartition(int low, int high) {
        int pivot = arr[high]; 
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        
        swap(i+1, high);
        
        return i+1;
    }
    
    /**
     * recursive sorting function
     * @param array to be sorted
     * @param low: starting index
     * @param high: ending index
     * @return sorted array
     */
    public void lomutoSort(int low, int high) {
    	
    		if (low < high) {
    			int pivot = lomutoPartition(low, high);
    			
    			//sorts elements before partition and after partition
    			lomutoSort(low, pivot-1);
    			lomutoSort(pivot+1, high);
    		}
    }
    
    /**
     * uses middle element as pivot
     * find an element from left side that is greater than the pivot
     * and swap with element from right side that is smaller than the pivot
     * @param low
     * @param high
     */
    public void middleSort(int low, int high) {
        
        int i = low;
        int j = high;
       
        int pivot = arr[(low + high)/ 2];
        
        //divide, search, and swap
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        
        if (low < j)
            middleSort(low, j);
        if (i < high)
            middleSort(i, high);
    }
    
    public int getMeanIndex(int low, int high) {
    	
		int sum = 0, i, j;
		for (i = low; i <= high; i++)
			sum += arr[i];
		
		int mean = sum / (high - low + 1);
		
		int indexOfMean = low; //index of highest element under mean	
		for (j = low; j <= high; j++) {
			if (arr[j] > arr[indexOfMean] && arr[j] <= mean) indexOfMean = j;
		}
		
		return indexOfMean;
	}
    
    /**
     * uses mean element as pivot
     * find an element from left side that is greater than the pivot
     * and swap with element from right side that is smaller than the pivot
     * @param low
     * @param high
     */
    public void meanSort(int low, int high) {
        
        int i = low;
        int j = high;
       
        int pivot = arr[getMeanIndex(low, high)];
        
        //divide, search, and swap
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        
        if (low < j)
            meanSort(low, j);
        if (i < high)
            meanSort(i, high);
    }
    
    public String getRunTimes() throws InterruptedException {
    		String times = ""; //type;
    		long startTime, endTime;
    		double durationMilli;
    		
    		for (int i = 0; i < REPEATS; i++) {
    			startTime = System.nanoTime();
	        lomutoSort(0, ARR_LENGTH - 1);
	        endTime = System.nanoTime();
	        
	        durationMilli = (endTime - startTime) / 1000000.0;
	        times += (i+1) + ", " + durationMilli + ", ";
	        
	        Thread.sleep(100);
	        
	        startTime = System.nanoTime();
	        middleSort(0, ARR_LENGTH - 1);
	        endTime = System.nanoTime();
	        
	        durationMilli = (endTime - startTime) / 1000000.0;
	        times += durationMilli + ", ";
	        
	        Thread.sleep(100);
	        
	        startTime = System.nanoTime();
	        meanSort(0, ARR_LENGTH - 1);
	        endTime = System.nanoTime();
	        
	        durationMilli = (endTime - startTime) / 1000000.0;
	        times += durationMilli + WriteCSV.NEW_LINE_SEPARATOR;
	        
	        Thread.sleep(100);
    		}
    		
    		return times;
    }
    
    public static void main (String args[]) throws InterruptedException {
    		
    		Quicksort QS = new Quicksort();
    		
    		System.out.println(QS.getRunTimes());
    }
    

}
