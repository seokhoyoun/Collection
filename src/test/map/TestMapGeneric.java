package test.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import practice.Book;

public class TestMapGeneric {

	public static void main(String[] args) {
		// Map 계열의 제네릭 기능 사용
		HashMap<String, Book> hmap;
		
		hmap = getInstance();
		//printMap(hmap);
//		printMap2(hmap);
		printMap3(hmap);
	}

	public static void printMap3(HashMap<String, Book> hmap) {
		// 키와 값을 쌍으로 묶은 Entries 들을 Set으로 바꿈
		Set<Map.Entry<String,Book>> entries = hmap.entrySet();	// 내부클래스
		//목록 만들기
		Iterator<Map.Entry<String, Book>> entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Map.Entry<String, Book> entry = entryIter.next();
			String key = entry.getKey();
			Book b = entry.getValue();
			System.out.println(key+" = "+ b);
		}
	}

	public static void printMap2(HashMap<String, Book> hmap) {
		// 2. 값 객체들을 Collection으로 바꾸기
		Collection<Book> values = hmap.values();
		// 목록 만들기
		Iterator<Book> vIter = values.iterator();
		while(vIter.hasNext()) {
			Book b = vIter.next();
			System.out.println(b);
		}
		System.out.println("------------------------------");
		// 배열로 바꾸기
		Book[] br = new Book[values.size()];
		values.toArray(br);
		for(Book e : br) {
			System.out.println(e);
		}
	}

	public static HashMap<String, Book> getInstance() {
		HashMap<String,Book> hmap = new HashMap<>();
		hmap.put("12", new Book("12",1,"java1","홍길동"));
		hmap.put("22", new Book("21",2,"java2","김길림"));
		hmap.put("32", new Book("33",3,"java3","박길준"));
		return hmap;
	}
	
	public static void printMap(HashMap<String, Book> hmap) {
		// 1. key를 set으로 바꿈
		Set<String> keys = hmap.keySet();
		// 목록 만들기
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Book b = hmap.get(key);
			System.out.println(key +"="+b);
		}
	}

}
