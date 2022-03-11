package week3.Day2.Assignment1;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(3);
		l1.add(2);
		l1.add(11);
		l1.add(4);
		l1.add(6);
		l1.add(7);
		
		List<Integer> l2=new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(8);
		l2.add(4);
		l2.add(9);
		l2.add(7);
		
		if (l1.size() == l2.size()) {
			for (int i = 0; i < l1.size(); i++) {
				if (l1.get(i)==l2.get(i)) {
					System.out.println(l1.get(i));
				}
			}
		}
	}

}
