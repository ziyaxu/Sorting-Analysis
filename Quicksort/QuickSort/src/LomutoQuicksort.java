public class LomutoQuicksort 
{
	
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int lomutoPartition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
    }
    
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    int[] sort(int arr[], int low, int high)
    {
    		if (low < high)
        {
			// pi is partitioning index, arr[pi] is now at right place
			int pi = lomutoPartition(arr, low, high);
			
			// Recursively sort elements before partition and after partition
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
        }
    		
    		return arr;
    }

    
    public static String runLoops(int repeats) 
    {
    		String times = "Lomuto";
		
	 	int[] arr = Quicksort.ranArr();
    		
	    	LomutoQuicksort lqs = new LomutoQuicksort();
	    	
    		for (int i = 0; i < repeats; i++)
    		{
    			arr = Quicksort.ranArr();

    	        long startTime = System.nanoTime();
    	        lqs.sort(arr, 0, Quicksort.ARR_LENGTH-1);
    	        long endTime = System.nanoTime();

    	        double durationMilli = (endTime - startTime) / 1000000.0;  //divide by 1000000 to get milliseconds.
    	        
    	        System.out.println("Milliseconds: " + durationMilli + " Type: Lomuto");
    	        times += ", " + durationMilli;
    	 
    	        System.out.println("Sorted Array");
    	        Quicksort.printArray(arr);
    		}
    		
    		return times;

    }
    
    public static void main (String args[]) {
		System.out.println(runLoops(Quicksort.REPEATS));
    }
}
