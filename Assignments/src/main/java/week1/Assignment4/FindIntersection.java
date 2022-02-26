package week1.Assignment4;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] fir = {3,2,11,4,6,7};
		int[] sec = {1,2,8,4,9,7};
		
		for (int i = 0; i < fir.length; i++) {
			
			for (int j = 0; j < sec.length; j++) {
				
				if (fir[i] == sec[j]) {
					System.out.println(fir[i]);
				}
			}
		}
	}

}
