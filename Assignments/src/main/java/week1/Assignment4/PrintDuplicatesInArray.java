package week1.Assignment4;

public class PrintDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		int cnt;
		
		for (int i = 0; i <= arr.length-1; i++) {
			
			cnt = 0;
			
			for (int j = i+1; j < arr.length; j++) {
				
				if (arr[i] == arr[j]) {
					cnt++;
				}
				
			}
			
			if (cnt > 0) {
				System.out.println("The count of "+arr[i]+" is "+cnt);
			}
		}
		
		}
		

	}


