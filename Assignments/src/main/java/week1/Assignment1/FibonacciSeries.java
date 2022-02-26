package week1.Assignment1;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int input=8;
		int a=0;
		int b=1;
		
		// below logic's output: 0 1 1 2 3 5 8 13 21 34
		  System.out.println(a+"\n"+b); 
		  for (int i = 1; i <= input; i++) { 
			  int sum =a+b;
			  System.out.println(sum); 
			  a=b; 
			  b=sum; 
			  
		  }
		 
		// below logic's output: 0 1 2 3 5 8 13 21 34
		/*
		 * System.out.println(a); for (int i = 1; i <= input; i++) { int sum = a+b; a=b;
		 * b=sum; System.out.println(sum);
		 * 
		 * }
		 */
	}

}
