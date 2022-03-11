package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class PrintDuplicateName {

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
		
		//Duplicate Names
		int i,j;
		
		for (i = 0; i < list.size(); i++) {
			int cnt=1;
			for (j = i+1; j < list.size(); j++) {
				if(list.get(i)==list.get(j)) {
					cnt++;
					list.set(j, "0");
				}
			}
			if (cnt>1 && list.get(i)!="0") {
				System.out.println(list.get(i));
			}
		}
	}

}
