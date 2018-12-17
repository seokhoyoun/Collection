package test.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
	
	public static void main(String[] args) {
		// LinkedHashSet test
		// 저장 순서가 유지되는 Set
		// 중복 허용 안 함.
		
		LinkedHashSet lset = new LinkedHashSet();
		
		lset.add("apple");
		lset.add("banana");
		lset.add(123); // auto boxing
		lset.add(123); // 중복 값 저장하는지 체크
		lset.add(54.7);
		
		System.out.println(lset);
		
		System.out.println("------------------");
		//1. 저장된 객체 목록만들어 하나씩 꺼내기
		Iterator iter = lset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("----------------------------");
		//2. Object[]로 만들어 꺼내기
		Object[] oar = lset.toArray();
		for(Object e : oar) {
			System.out.println(e);
		}
		
		System.out.println("----------------------------");
		//3. toArray(T[] a) 사용하기
		Object[] oar2 = new Object[lset.size()];
		oar2 = lset.toArray(oar2);
		for(Object e : oar2) {
			System.out.println(e);
		}
 	}
}
