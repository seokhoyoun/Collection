package skillup.day04.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import skillup.day04.model.vo.Snack;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, Snack> hm = new HashMap<>();

		// List, Set 값 추가 add
		// Map은 put

		hm.put("다이제", new Snack("초코맛", 1500));
		hm.put("칸초", new Snack("단맛", 600));
		hm.put("새우깡", new Snack("짠맛", 650));
		hm.put("초코칩", new Snack("초코맛", 1500));

		System.out.println(hm);
		// 들어간 순서 유지
		// value값이 같아도 key가 다르면 중복 허용

		hm.put("새우깡", new Snack("짠맛", 750));

		System.out.println(hm);
		// key 값이 같기 때문에 저장x

		// get(K key)
		Snack s = hm.get("다이제");
		System.out.println(s);

		hm.remove("초코칩");
		System.out.println(hm);

		System.out.println("======== key set 이용==============");
		Set<String> keys = hm.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("======== entry set 이용==============");
		Set<Entry<String, Snack>> ent = hm.entrySet();
		Iterator<Entry<String, Snack>> eit = ent.iterator();
		while (eit.hasNext()) {
			Entry<String, Snack> entry = eit.next();
			System.out.println(entry.getKey() + " !! " + entry.getValue());
		}

	}
}
