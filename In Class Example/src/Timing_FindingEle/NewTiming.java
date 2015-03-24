package Timing_FindingEle;

import java.util.Arrays;
import java.util.Scanner;

// time runtime of algorithms
public class NewTiming {

	// range of values to use
	final static int largestNum = 1000000000;

	public static void main(String[] args) {
		// set up scanner
		Scanner input = new Scanner(System.in);

		// main loop
		System.out.print("Array size (zero or negative to finish)? ");
		int size = input.nextInt();
		while (size > 0) {
			// create arrays
			int[] array1 = createRandomArray(size);
			Arrays.sort(array1);
			// printArray(array1);

			int[] array2 = createRandomArray(size);
			Arrays.sort(array2);
			// printArray(array2);

			// time finding common elements
			long start = System.currentTimeMillis();
			int count = findCommonElementsQuadratic(array1, array2); //26789 = 506, 41000 = 1214
			//int count = findCommonElementsLogLinear(array1, array2); //3mil = 531, 2700000 = 466, 4mil = 1009
			//int count = findCommonElementsLinear(array1, array2); 
			long end = System.currentTimeMillis();

			System.out.println(count + " common elements");
			System.out.println("Time: " + (end - start));

			System.out.print("Array size (zero or negative to finish)? ");
			size = input.nextInt();
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

	// find common elements
	public static int findCommonElementsQuadratic(int[] array1, int[] array2) {
		int count = 0;
		for (int idx1 = 0; idx1 < array1.length; idx1++) {
			for (int idx2 = 0; idx2 < array2.length; idx2++) {
				if (array1[idx1] == array2[idx2]) {
					count++;
					// System.out.println(array1[idx1]);
				}
			}
		}
		return count;
	}

	// find common elements
	public static int findCommonElementsLogLinear(int[] array1, int[] array2) {
		int count = 0;
		for (int idx1 = 0; idx1 < array1.length; idx1++) {
			if (binarySearch(array2, array1[idx1]) != -1) {
				count++;
				// System.out.println(array1[idx1]);
			}
		}
		return count;
	}
	
	// find common elements
	public static int findCommonElementsLinear(int[] array1, int[] array2) {
		int count = 0;
		int idx1 = 0;
		int idx2 = 0;
		
		while (idx1< array1.length && idx2 < array2.length){
			
		}
		return count;
	}

	// binary search
	static int binarySearch(int[] array, int value) {
		int startIdx = 0;
		int endIdx = array.length - 1;

		// check mid point, then left or right on each iteration
		while (startIdx <= endIdx) {
			// get mid point
			int midIdx = (startIdx + endIdx) / 2;

			if (array[midIdx] == value) {
				// found, return index
				return midIdx;
			} else if (array[midIdx] < value) {
				startIdx = midIdx + 1;
			} else {
				endIdx = midIdx - 1;
			}
		}

		// if we are at this point, the element is not in the array
		return -1;
	}

}
