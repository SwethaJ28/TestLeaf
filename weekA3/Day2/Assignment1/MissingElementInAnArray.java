package week3.Day2.Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(7);
		l1.add(6);
		l1.add(8);
		Collections.sort(l1);
		int j=1;
		for (int i = l1.get(0); i < l1.size(); i++) {
			if (l1.get(i)!=i+1) {
				System.out.println(i+1);
				break;
			}
		}

	}

}
