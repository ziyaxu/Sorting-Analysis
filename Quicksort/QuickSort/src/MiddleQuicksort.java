public class MiddleQuicksort {
     
	private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
        this.array = inputArr;
        length = inputArr.length;
        middleQuicksort(0, length - 1);
    }
 
    private void middleQuicksort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            middleQuicksort(lowerIndex, j);
        if (i < higherIndex)
            middleQuicksort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static String runLoops(int repeats) 
    {
    		String times = "Middle";
		
	 	int[] arr = Quicksort.ranArr();
    		
	    	MiddleQuicksort mqs = new MiddleQuicksort();
	    	
    		for (int i = 0; i < repeats; i++)
    		{
    
    	        long startTime = System.nanoTime();
    	        mqs.sort(arr);
    	        long endTime = System.nanoTime();

    	        double durationMilli = (endTime - startTime) / 1000000.0;  //divide by 1000000 to get milliseconds.
    	        
    	        System.out.println("Milliseconds: " + durationMilli + " Type: Middle");
    	        times += ", " + durationMilli;
    	 
    	        System.out.println("sorted array");
    	        Quicksort.printArray(arr);
    		}
    		
    		return times;
    }
    
    public static void main (String args[]) {
		System.out.println(runLoops(Quicksort.REPEATS));
    }
}