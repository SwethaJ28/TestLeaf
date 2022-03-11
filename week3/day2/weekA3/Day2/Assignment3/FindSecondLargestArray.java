package week3.Day2.Assignment3;

import java.util.Arrays;

public class FindSecondLargestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {3,2,11,4,6,20};
		Arrays.sort(data);
		System.out.println("The second largest element in the array: "+data[data.length-2]);

	}

}
