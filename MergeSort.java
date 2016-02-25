
public class MergeSort 
{
	public static void main (String [] args)
	{
		//this will take the string of any ten digits. if we increase this value it will take that number of digits
		int A [] = new int [10];
		populateA(A);
		//this statement will print the random numbers
		System.out.println("Before Sort: ");
		printA(A);
		
		A = mergeSort(A);
		// this will print sorted list
		System.out.println("\nAfter Sort: ");
		printA(A);
		
	}
	
	public static int []mergeSort(int [] B)
	{
		//if there is only one cell this will close the program and print that single digit
		if (B.length <= 1)
		{
			return B;
		}
		//this is for dividing the string
		int midpoint = B.length / 2;
		int [] left = new int [midpoint];
		int [] right;
		if (B.length % 2 == 0)
		{
			right = new int [midpoint];
		}
		// if the string is odd this will divide the string and put extra cell towards right
		else
		{
			right = new int [midpoint + 1];
		}
		int [] result = new int [B.length];
		
		for (int i = 0; i < midpoint; i++)
		{
			left[i] = B[i];
		}
		int x = 0;
		for (int j = midpoint; j < B.length; j++)
		{
			if ( x < right.length)
			{
				right[x] = B[j];
				x++;
			}
		}
		left = mergeSort (left);
		right = mergeSort (right);
		
		result = merge (left, right);
		
		return result;
	}
	// now to merge the cells back together
	public static int [] merge (int [] left, int [] right)
	{
		int lengthResult = left.length + right.length;
		int [] result  = new int [lengthResult];
		int indexL = 0;
		int indexR = 0;
		int indexRes = 0;
		
		while (indexL < left.length || indexR < right.length)
		{
			if (indexL < left.length && indexR < right.length)
			{
				if (left[indexL] <= right [indexR])
				{
					result [indexRes] = left [indexL];
					indexL++;
					indexRes++;
				}
				else
				{
					result [indexRes] = right [indexR];
					indexR++;
					indexRes++;
				}
			}
			else if (indexL < left.length)
			{
				result [indexRes] = left[indexL];
				indexL++;
				indexRes++;
			}
			
			else if (indexR < right.length)
			{
				result [indexRes] = right[indexR];
				indexR++;
				indexRes++;
			}
		}
		return result; 
	}
	// functions
	public static void printA(int [] B)
	{
		for (int i = 0; i < B.length; i++)
		{
			System.out.print(B[i] + " ");
		}
	}
	public static int[] populateA (int [] B)
	{
		for (int i = 0; i < B.length; i++)
		{
			B[i] = (int) (Math.random()*100);
		}
		return B;
	}
}
