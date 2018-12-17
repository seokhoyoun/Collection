package test.list;

import java.util.ArrayList;

public class TestPersonArrayList {

	public static void main(String[] args) {
		// Person 저장용 ArrayList 사용
		ArrayList list = new ArrayList();
		list.add(new Person("홍길동",25,1234.5));
		list.add(new Person("홍길순",27,134.5));
		list.add(new Person("홍길현",22,1954.5));
		
		System.out.println(list);
		
		for(Object e : list) {
			System.out.println(e);
		}
		
		// 각 객체가 가진 포인트 값의 합계를 구한다.
		double totalPoint = 0;
		for(int i = 0; i < list.size(); i++) {
			Person p =(Person)(list.get(i));
			totalPoint += p.getPoint();
		}
		
		System.out.println("포인트 종합 : "+totalPoint); 
	
	}

}
