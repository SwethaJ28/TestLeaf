package week3.day1;

public class StartswithT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "Testleaf is located in Teynampet and above taccobell";
		String[] splitText = input.split(" ");
		
		for (int i = 0; i < splitText.length; i++) {
			if (splitText[i].startsWith("T") || splitText[i].startsWith("t")) {
				System.out.println(splitText[i]);
			}
		}
		

	}

}
