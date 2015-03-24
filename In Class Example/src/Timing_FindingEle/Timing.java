package Timing_FindingEle;

import java.util.Arrays;
import java.util.Scanner;

// time runtime of algorithms
public class Timing {

	// range of values to use
	final static int largestNum = 1000;

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
			printArray(array1);

			int[] array2 = createRandomArray(size);
			Arrays.sort(array2);
			printArray(array2);

			// time finding common elements
			long start = System.currentTimeMillis();
			int count = findCommonElements(array1, array2);
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
	public static int findCommonElements(int[] array1, int[] array2) {
		int count = 0;
		for (int idx1 = 0; idx1 < array1.length; idx1++) {
			for (int idx2 = 0; idx2 < array2.length; idx2++) {
				if (array1[idx1] == array2[idx2]) {
					count++;
					System.out.println(array1[idx1]);
				}
			}
		}
		return count;
	}

}