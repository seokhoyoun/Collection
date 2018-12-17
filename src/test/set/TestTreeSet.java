package test.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// TreeSet test
		// 중복 허용 안 함
		// 객체를 자동 오름차순 정렬하면서 저장한다.
		TreeSet tset = new TreeSet();
		//Set tset = new TreeSet();
		
		tset.add("orange");
		tset.add("banana");
		tset.add("apple");
		tset.add("grape");
		
		System.out.println(tset);
		System.out.println(tset.descendingSet());
		
		//1. iterator()
		Iterator iter = tset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println("----------------------------------------------");
		//2. toArray()
		Object[] oar = tset.toArray();
		for(Object e : oar) {
			System.out.println(e);
		}
		System.out.println("----------------------------------------------");
		//3. 내림차순 정렬된 목록 만들기
		Iterator iter2 = tset.descendingIterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		System.out.println("----------------------------------------------");
		//4. 내림차순 descendingSet
		Object[] oar2 = tset.descendingSet().toArray();
		for(Object e : oar2) {
			System.out.println(e);
		}
	}
}
