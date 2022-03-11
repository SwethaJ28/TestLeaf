package week3.Day1.Assignment5;

public class CharOccurance {
public int cntfunction(char c,String s) {
	int cnt=0;
	int length = s.length();
	
	for (int i = 0; i < length; i++) {
		if (s.charAt(i)=='e') {
			cnt++;
		}
	}
	return cnt;
	// TODO Auto-generated method stub
	

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "welcome to chennai";
		CharOccurance co = new CharOccurance();
		int cnt=co.cntfunction('e', str);
		System.out.println("The count of given letter 'e' is "+cnt );
	}
	

}
