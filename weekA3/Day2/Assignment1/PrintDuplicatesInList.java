package week3.Day2.Assignment1;

import java.util.ArrayList;
import java.util.List;

public class PrintDuplicatesInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(12);
		list.add(13);
		list.add(11);
		list.add(15);
		list.add(14);
		list.add(18);
		list.add(16);
		list.add(17);
		list.add(18);
		list.add(19);
		list.add(20);
		int i, j;
		for (i = 0; i < list.size(); i++) {
			int cnt = 1;
			for (j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					cnt++;
					list.set(j, 0);
				}
			}

			if (cnt > 1 && list.get(i) != 0) {
				System.out.println(list.get(i));

			}

		}

	}

}
