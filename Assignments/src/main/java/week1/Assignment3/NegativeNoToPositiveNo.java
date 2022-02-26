package week1.Assignment3;

public class NegativeNoToPositiveNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input = 90;
		
		if (input < 0) {
			int posi = input *-1;
			System.out.println("The number "+input+" is convereted to "+posi);
		}
		else if (input >= 0) {
			System.out.println("Given number "+input+ " is not a negative number, Please input the negative number");
		}

	}

}
