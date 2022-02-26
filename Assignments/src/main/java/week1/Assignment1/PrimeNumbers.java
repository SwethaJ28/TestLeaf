package week1.Assignment1;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 179;
		boolean flag = false;
		for (int i = 2; i <= input/2;) {
			int rem = input % i;
			//System.out.println(rem);
			if (rem == 0)
				flag = true;
			break;			
		}
		
		if(flag == true)
			System.out.println("Given number is not a prime number");
		else
			System.out.println("Given number is prime number");

	}

}
