package test.map;
import java.util.*;
import java.util.Map.Entry;
public class TestHashMap3 {

	public static void main(String[] args) {
		// HashMap 실습
		HashMap hmap = new HashMap();
		
		for(int k = 0; k < 5; k++) {
			//1-100 사이의 임의의 정수가 key로 사용
			// 임의의 0.0부터 1.0 미만의 임의의 실수값을
			hmap.put(new Random().nextInt(100)+1, Math.random()); // Auto Boxing
		}
		
		System.out.println(hmap);
		// 맵에 기록된 객체 정보 연속처리
		// 1. key -> set
		// set을 목록으로 바꾸어 처리
		Iterator hIter = hmap.keySet().iterator();
		while(hIter.hasNext()) {
			System.out.println(hIter.next());
		}
		System.out.println("---------------------------");
		// 2. 값들을 Collection으로. 목록으로 처리
		Collection values = hmap.values();
		Iterator vIter = values.iterator();
		while(vIter.hasNext()) {
			System.out.println(vIter.next());
		}
		System.out.println("---------------------------");
		// 3. Collection을 객체 배열로
		Collection values2 = hmap.values();
		Object[] oar = values2.toArray();
		for(Object e : oar) {
			System.out.println(e);
		}
		System.out.println("---------------------------");
		
		// 4. Map.Entry 들을 Set으로 목록으로 바꾸어 처리
		Set ent = hmap.entrySet();
		Object[] oar2 = ent.toArray();
		for(Object e : oar2) {
			System.out.println(e);
		}
	}

}
