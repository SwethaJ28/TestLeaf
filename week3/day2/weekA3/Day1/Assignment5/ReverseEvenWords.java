package week3.Day1.Assignment5;

public class ReverseEvenWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
		String[] split1 = test.split(" ");
		for (int i = 0; i < split1.length; i++) {
			if (i % 2 == 0) {
				System.out.print(split1[i]+" ");
			} else {
				String rev ="";
				String input=split1[i].toString();
				for (int j = input.length()-1; j >=0; j--) {
					rev=rev+input.charAt(j);
				}
				System.out.print(rev+" ");
			}
		}

	}

}
