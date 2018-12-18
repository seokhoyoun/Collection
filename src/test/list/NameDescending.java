package test.list;

import java.util.Comparator;

public class NameDescending implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// 정렬 기준이 되는 필드에 대한 조건 처리
		int result = 0;
		if(o1 instanceof Person && o2 instanceof Person) {
			Person p1 = (Person)o1;
			Person p2 = (Person)o2;
			
			// Name 필드값을 비교해서 두 이름이 같으면, 0 리턴
			// 앞 객체의 이름이 크면 1
			// 작으면 -1 리턴
			if(p1.getName().compareTo(p2.getName()) > 0) {
				result = -1;
			}
			else if(p1.getName().compareTo(p2.getName()) < 0) {
				result = 1;
			}
		}
		
		return result;
	}
}
