package test.generic;

import java.util.*;

public class TestListGeneric {
	public ArrayList<String> makeList(){
		ArrayList<String> list;
		list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("orange");
		list.add("melon");
		list.add("grape");
		return list;
	}
	public static void main(String[] args) {
		// List generic test
		TestListGeneric test = new TestListGeneric();
		ArrayList<String> list = test.makeList();
		
		test.printList(list);
	}
	public void printList(ArrayList<String> list) {
		/*for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}*/
		for(String e : list) {
			System.out.println(e);
		}
		
	}

}
