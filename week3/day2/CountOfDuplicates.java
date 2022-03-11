package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class CountOfDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("Adam");
		list.add("Ben");
		list.add("Zara");
		list.add("Adam");
		list.add("Charlie");
		list.add("James");
		list.add("Ben");
		list.add("Adam");
		list.add("George");
		list.add("Adam");
		
		
		//logic
		int cnt=0;
		//count of duplicates
		for (int i2 = 0; i2 < list.size(); i2++) {
			if (list.get(i2).equals("Adam")) {
				cnt++;
			}
		}
		System.out.println("Count of Adam is "+cnt);

	}

}
