package week1.Assignment2;

public class CalculatorApp {
	
	public int additionOperation(int a, int b, int c) {
		return a+b+c;
	}
	
	public int subtractionOperation(int a, int b) {
		return a-b;
	}
	
	public double multiplicationOperation(double a, double b) {
		return a*b;
	}
	
	public float divisonOperation(float a, float b) {
		return a/b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CalculatorApp CA = new CalculatorApp();
		
		System.out.println(CA.additionOperation(7, 8, 9));
		System.out.println(CA.subtractionOperation(20, 5));
		System.out.println(CA.multiplicationOperation(24, 8));
		System.out.println(CA.divisonOperation(31, 6));

	}

}
