package test.list;

import java.util.Comparator;

public class PointAscending implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// Person의 point 필드 기준 오름차순 정렬
		return o1.getPoint() > o2.getPoint() ? 1 : o1.getPoint() < o2.getPoint()? -1 : 0;
	}
	
}
