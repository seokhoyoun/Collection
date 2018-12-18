package test.list;

import java.util.Comparator;

public class PointDescending implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getPoint() > o2.getPoint() ? -1 : o1.getPoint() < o2.getPoint()? 1 : 0;
	}

}
