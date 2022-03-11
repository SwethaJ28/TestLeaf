package week3.Day2.Assignment1;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("We");
		list.add("learn");
		list.add("java");
		list.add("basics");
		list.add("as");
		list.add("part");
		list.add("of");
		list.add("java");
		list.add("sessions");
		list.add("in");
		list.add("java");
		list.add("week1");
int i,j;
		for (i = 0; i < list.size(); i++) {
			int cnt = 1;
			for (j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					cnt++;
					list.set(j, "0");
				}
			}
			
			if (cnt > 1 && list.get(i) != "0") {
				list.remove(list.get(i));

			}

		}
		for (int j2 = 0; j2 < list.size(); j2++) {
			list.remove("0");
		}
		System.out.println(list);
	}

}
