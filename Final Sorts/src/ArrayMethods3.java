import java.util.Arrays;

public class ArrayMethods3 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	public static String[] mergeSort(String[] list1)
	{
		if(list1.length==1)
		{
			return list1;
		}
		
		int center = list1.length/2;
		String[] half1 = Arrays.copyOfRange(list1, 0, center);
		String[] half2 = Arrays.copyOfRange(list1, center+1, list1.length);
		
		return merge(mergeSort(half1), mergeSort(half2));
	}

	private static String[] merge(String[] mergeSort, String[] mergeSort2) {
		
		// TODO Auto-generated method stub
		return null;
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

}
