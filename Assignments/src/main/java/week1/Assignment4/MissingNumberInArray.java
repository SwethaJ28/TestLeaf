package week1.Assignment4;

import java.util.Arrays;

public class MissingNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,5,6,7,4};
		int j = 1;
		Arrays.sort(arr);
		
		for (int i = arr[0]; i < arr.length; i++) {
			if (arr[i] != arr[j]) {
				System.out.println(arr[i]);
				break;
			}
			j++;
		}

	}

}
