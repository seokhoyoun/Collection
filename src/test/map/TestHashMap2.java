package test.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap2 {

	public static void main(String[] args) {
		// 맵에 저장된 객체정보 연속 처리
		
		HashMap hmap = new HashMap();
		hmap.put("one", new Integer(12345));
		hmap.put(2, "java"); // Auto Boxing
		hmap.put("two", "oracle");
		
		System.out.println(hmap);
		// Map 계열은 저장된 객체에 대한
		// 연속 처리 기능 없음
		// 연속처리하려면 Map을 Set이나 Collection으로 바꾸고나서 Iterator()로 목록 만들거나
		// Object[]로 바꾸어 사용해야 한다.
		
		// 1. key들을 set으로 바꾸고 key에 대한 목록을 만듦
		Set keys = hmap.keySet();
		System.out.println(keys);
		Iterator keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			Object key = keyIter.next();
			Object value = hmap.get(key);
			System.out.println(key+" "+ value);
		}
		System.out.println("-------------------------");
		
		// 2. values 메소드 사용
		// 값 객체들만 Collection 으로 바꾸고나서 목록이나 객체배열로 만듦
		Collection values = hmap.values();
		//2-1) 목록만들기
		Iterator valueIter = values.iterator();
		while(valueIter.hasNext()) {
			System.out.println(valueIter.next());
		}
		System.out.println("-------------------------");
		
		//2-2 객체배열 만들기
		Object[] valueArr = values.toArray();
		for(Object e : valueArr) {
			System.out.println(e);
		}
		System.out.println("-------------------------");
		//2-3 entrySet() 사용
		// Map.Entry 들을 Set으로 바꾸고 Entry에 대한 목록을 만듦
		// Entry : 키와 값 한쌍
		Set entries = hmap.entrySet();
		Iterator entryIter = entries.iterator();
		while(entryIter.hasNext()) {
			Object obj = entryIter.next();
			Map.Entry entry = (Map.Entry)obj;
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		
	}
}
