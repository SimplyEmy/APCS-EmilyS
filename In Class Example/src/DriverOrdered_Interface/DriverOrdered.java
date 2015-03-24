package DriverOrdered_Interface;

//Seattle Prep CS class
//3/2/2015
//
import java.util.Arrays;

// driver
public class DriverOrdered {

	// main function
	public static void main(String[] args) {
		// create an array of dates, print
		Date[] arrDate = { new Date("3/1/2015"), new Date("7/11/1965"), new Date("7/25/1992") };
		System.out.println(Arrays.toString(arrDate));

		// find the smallest date and print it
		// ***** write code here
		// ***** use function findSmallest
		
		System.out.println();
		System.out.println(findSmallest((Ordered[]) arrDate));
	}

	// find the smallest element in array
	public static Ordered findSmallest(Ordered[] arr) {
		// assume first element is smallest
		Ordered smallest = arr[0];

		// go through each of the remaining elments
		for (int idx = 1; idx < arr.length; idx++) {
			// if element in array is smaller, update smallest
			if (arr[idx].isSmallerThan(smallest))
				smallest = arr[idx];
		}

		// return smallest element found
		return smallest;
	}

}
