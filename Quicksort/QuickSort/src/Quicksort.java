import java.util.Random;

public class Quicksort {
	
	public static final int ARR_LENGTH = 10;
	public static final int ARR_RANGE = 1000;
	public static final int REPEATS = 100;
	
    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        for (int i = 0; i < ARR_LENGTH; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    
    public static int[] ranArr() 
    {
    		int[] array = new int[ARR_LENGTH];
    		Random rand = new Random(); 

    		for (int i = 0; i < ARR_LENGTH; i++)
    		{
    			array[i] = rand.nextInt(1000);
    		}
    		
    		return array;
    }

}
