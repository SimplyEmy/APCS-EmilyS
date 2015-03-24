package Search_ArraySearch;

// Seattle Prep CS class
// 3/12/2015
//
import java.util.Arrays;
import java.util.Scanner;

public class Search {

	// size of array and range of values to use
	//final static int arraySize = 100;
	//final static int largestNum = 1000;
	
	final static int arraySize = 100;
	final static int largestNum = 100000000;

	// main function
	public static void main(String[] args) {
		// create array
		int[] array = createRandomArray(arraySize);
		Arrays.sort(array);
		printArray(array);

		// set up scanner
		Scanner input = new Scanner(System.in);

		// main loop
		System.out.print("number to search (negative to finish)? ");
		int v = input.nextInt();
		while (v >= 0) {
			//int pos = sequentialSearch(array, v);
			int pos = binarySearch(array, v);
			System.out.println("position: " + pos);

			System.out.print("number to search (negative to finish)? ");
			v = input.nextInt();
		}
		System.out.println("Bye");
		input.close();
	}

	// create random array of a given size
	public static int[] createRandomArray(int size) {
		int[] array = new int[size];
		for (int idx = 0; idx < array.length; idx++) {
			int value = (int) (largestNum * Math.random());
			array[idx] = value;
		}

		return array;
	}

	// print array elements
	public static void printArray(int[] array) {
		for (int idx = 0; idx < array.length; idx++) {
			System.out.println(idx + ": " + array[idx]);
		}
	}

	// sequential search
	static int sequentialSearch(int[] array, int value) {

		// check each element in the array to find the value
		for (int idx = 0; idx < array.length; idx++) {
			if (array[idx] == value)
				return idx;
		}

		// if we are at this point, the element is not in the array
		return -1;
	}

	// binary search
	static int binarySearch(int[] array, int value) {
		int startIdx = 0;
		int endIdx = array.length;

		// check mid point, then left or right on each iteration
		while (startIdx <= endIdx) {
			int midpointIndex = (endIdx+1)/2;
			int midpoint = array[midpointIndex];
			
			if (midpoint > value){
				for (int idx = midpointIndex; idx == 0; idx--) {
					if (array[idx] == value)
						return idx;
				}
			}else if (midpoint < value){
				for (int idx = midpointIndex; idx < array.length; idx++) {
					if (array[idx] == value)
						return idx;
				}
				
			}else{
				return midpointIndex;
			}
		}

		// if we are at this point, the element is not in the array
		return -1;
	}
}
