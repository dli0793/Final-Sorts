import java.util.Arrays;

public class ArrayMethods3 
{

	public static void main(String[] args) 
	{
		//Testing Arrays
		String[] list1 = {"microsoft", "apple", "cucumber", "zorro", "tangerine"};
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
		quickSort(list3, 0, 7);
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
		String[] half2 = Arrays.copyOfRange(list1, center+1, list1.length-1);
		
		return merge(mergeSort(half1), mergeSort(half2));
	}

	public static String[] merge(String[] list1, String[] list2)
	{
		String[] x;
		String[] z;
		
		if(list1.length<list2.length)
		{
			x = list1;
			z = list2;
		}
		else
		{
			x = list2;
			z = list1;
		}
		
		String[] y = new String[z.length+x.length];
		int r = 0;
		for(int i = 0;i<x.length;i++)
		{
			if(list1[i].compareTo(list2[i])<0)
			{
				y[r] = list1[i];
				y[r+1] = list2[i];
				r+=2;
			}
			
			else
			{
				y[r] = list2[i];
				y[r+1] = list1[i];
				r+=2;
			}
		}
		
		for(int i = 0;i<z.length;i++)
		{
			y[r] = z[i];
		}
		
		String tempStr;
		int counter = 1;
		while(counter>0)
		{
			counter = 0;
			for(int i=0;i<y.length-1;i++)
			{	
				if(y[i].compareTo(y[i+1])>0)
				{
					tempStr = y[i];
					y[i] = y[i+1];
					y[i+1] = tempStr;
					counter = 1;
				}
			}
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
		if(back>front)
		{
			int pivotPos = partition(list1, front, back);
			quickSort(list1, front, pivotPos-1);
			quickSort(list1, pivotPos+1, back);
		}
	}

}
