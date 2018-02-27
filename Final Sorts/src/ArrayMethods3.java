//There is a stack overflow error. Not sure why.
//Daniel Li
//Final Sorts

import java.util.Arrays;

public class ArrayMethods3 
{

	public static void main(String[] args) 
	{
		//Testing Arrays
		String[] list1 = {"microsoft", "apple", "cucumber", "zorro", "tangerine", "avocado"};
		String[] list2 = {"banana", "cherry", "mahogany", "oreos", "pinata"};
		int[] list3 = {3, 4, 2, 7, 12, 22, 0, 1};
				
		//Merge Test
		long start = System.nanoTime();
		mergeSort(list1);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("MergeSort test took: " + time + "nanoseconds.");
		System.out.println(java.util.Arrays.toString(mergeSort(list1)));
				
		//Partition Test
		start = System.nanoTime();
		int pivotFinal = partition(list3, 0, 7);
		end = System.nanoTime();
		time = end-start;
		System.out.println("Partition test took: " + time + "nanoseconds.");
		System.out.println("Final pivot position: " + pivotFinal);
		System.out.println(java.util.Arrays.toString(list3));
		
		//QuickSort Test
		start = System.nanoTime();
		ArrayMethods3.quickSort(list3, 0, 7); 
		end = System.nanoTime();
		time = end-start;
		System.out.println("QuickSort test took: " + time + "nanoseconds.");
		System.out.println(java.util.Arrays.toString(list3));

	}
	
	public static String[] mergeSort(String[] list1)
	{
		if(list1.length==1)
		{
			return list1;
		}
		
		int center = list1.length/2;
		String[] half1 = Arrays.copyOfRange(list1, 0, center);
		String[] half2 = Arrays.copyOfRange(list1, center, list1.length);
		
		return merge(mergeSort(half1), mergeSort(half2));
	}

	public static String[] merge(String[] list1, String[] list2)
	{
		int list1Index = 0;
		int list2Index = 0;
		int sortedIndex = 0;
		String[] y = new String[list1.length+list2.length];
		
	    while(list1Index<list1.length&&list2Index<list2.length)
	    {
	        if(list1[list1Index].compareTo(list2[list2Index])<0)
	        {
	            y[sortedIndex] = list1[list1Index];
	            list1Index++;
	        }
	        else
	        {
	            y[sortedIndex] = list2[list2Index];
	            list2Index++;
	        }
	        sortedIndex++;
	    }
	    while(list1Index<list1.length)
	    {
	        y[sortedIndex] = list1[list1Index];
	        list1Index++;
	        sortedIndex++;
	    }
	    while(list2Index<list2.length)
	    {
	        y[sortedIndex] = list2[list2Index];
	        list2Index++;
	        sortedIndex++;
	    }

	    return y;
	}
	
	public static int partition(int[] list1, int front, int back)
	{
		int pivot = list1[front];    
	    int right = back;
	    int index = 0;

	    for(int i = 1;i<back;i++)
	    	{
		        if(list1[i]<pivot)
		        {
		            int temp = list1[i];
		            list1[i] = list1[i-1];
		            list1[i-1] = temp;             
		            index = i;
		        } 
		        else if(list1[i]>pivot&&right>i)
		        {
		            int temp = list1[i];
		            list1[i] = list1[right];
		            list1[right] = temp;
		            right -= 1;
		            i--;
		        }
	    	}
	    return index;
	
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		if(front<back)
		{
			int pivotPos = partition(list1, front, back);
			quickSort(list1, front, pivotPos-1);
			quickSort(list1, pivotPos+1, back);
		}
	}

}
