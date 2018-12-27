package ncs4.test1;

import java.util.Comparator;

public class Descending implements Comparator<Integer>{

	@Override
	public int compare(Integer a1, Integer a2) {
		return (a1 > a2) ? -1 : (a1 < a2)? 1 : 0;
	}

}
