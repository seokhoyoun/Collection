package test.map;

import java.util.HashMap;
import java.util.Map;

import practice.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		// HashMap test
		HashMap hmap = new HashMap();
//		Map hm = new HashMap();
		
		// 키 객체와 값 객체 쌍으로 저장함.
		hmap.put(new String("one"), new Person("홍길동",27,1520.4));
		hmap.put("23", new Book("23",1,"해리포터5","조엘롤"));
		// key는 set 방식으로 저장 (중복 불가능)
		// value는 List 방식으로 저장됨
		
		System.out.println("저장된 객체 수 : "+hmap.size());
		System.out.println(hmap);
		
		hmap.put("one", "java programming");
		System.out.println(hmap);
		
		hmap.put("two", new Book("27",4,"해리포터2","조엘롤링"));
		System.out.println(hmap);
		
		// Map에 저장된 값 객체 조회시
		Object value = hmap.get("23");
		System.out.println(value);
		if(value instanceof Book) {
			Book b = (Book)value;
			System.out.println(b.getTitle());
			System.out.println(((Book)value).getTitle());
		}
	}

}
