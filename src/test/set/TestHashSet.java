package test.set;
import java.util.*;
public class TestHashSet {

	public static void main(String[] args) {
		// HashSet test
		HashSet hset = new HashSet();
		System.out.println(hset.isEmpty());
		System.out.println(hset.size());
		
		// 객체만 저장가능하다.
		hset.add(new String("apple"));
		hset.add("banana");
		hset.add(new Integer(123));
		// data(값) --> instance(객체) : boxing 박싱
		// Wrapper 클래스사용
		hset.add(456); // 오토 박싱 AutoBoxing 처리됨
		hset.add(new Double(54.7)); // 박싱처리
		hset.add(3.15); // 오토박싱
		// 기본자료형 값에 대해서는 컬렉션에 자동 boxing 처리된다.
		
		// 부모 클래스에 toString() 오버라이딩 되어있음
		System.out.println(hset.toString());
		// 저장순서가 유지 안 됨.
		// 중복허용 안 됨.
		hset.add("apple");
		System.out.println(hset);
		System.out.println(hset.size());
		if(hset.contains("apple")) {
			hset.remove("apple");
		}
		System.out.println(hset);
		System.out.println(hset.size());
		System.out.println("-------------------------");
		
//		hset.clear();
//		System.out.println(hset.isEmpty());
		
		// 저장된 객체 정보를 하나씩 꺼내서 사용하는 방법
		// 1. 저장된 객체 목록 만들기
		// 목록 : iterator라고 함
		Iterator iter = hset.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
		}
		System.out.println("----------------------------------");
		// 2. Object[]로 바꾸어 꺼내쓰기
		Object[] oar = hset.toArray();
		for(int i = 0; i < oar.length; i++) {
			System.out.println(oar[i]);
		}
		System.out.println("---------------------------");
		// 3. toArray(T[] a) 사용하는 방법
		Object[] oar2 = new Object[hset.size()];
		hset.toArray(oar2);
		for(Object e : oar2) {
			System.out.println(e);
		}
		
		
		
	}
}
