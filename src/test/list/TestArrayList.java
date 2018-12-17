package test.list;

import java.util.ArrayList;

public class TestArrayList {

	public static void main(String[] args) {
		// ArrayList test
		ArrayList list = new ArrayList();
		
		// 저장 순서가 index로 매겨짐
		// 객체 중복 저장 가능함.
		list.add("java");
		list.add("oracle");
		list.add("jdbc");
		list.add("java");
		
		System.out.println(list);
		
		for(int i= 0; i < list.size(); i++) {
			System.out.println(i+") "+ list.get(i));
		}
		
		// 저장 순번이 있는 배열이나 리스트는 for each문 사용 가능함.
		for(Object e : list) {
			System.out.println(e);
		}
		
		// add(순번, 객체)
		list.add(1, "html5");
		System.out.println(list);
		// set(index, 변경할 객체)
		list.set(3, "css3");
		System.out.println(list);
		// remove(삭제할 객체) : set 계열 메소드와 동일함
		list.remove("java");
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		
	}
}
