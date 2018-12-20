package test.map;

import java.util.*;

public class TestTreeMap {

	public static void main(String[] args) {
		// TreeMap test
		// 자동 정렬기능이 내장된 Map 클래스
		HashMap hm = new HashMap();
		
		for(int i = 0; i < 5; i++) {
			hm.put((int)(Math.random()*100)+1, Math.random());
		}
		System.out.println(hm);
		
		// key에 대한 자동 오름차순 정렬 사용하려면 TreeMap을 사용
		
		TreeMap tm = new TreeMap(hm);
		System.out.println(tm);
		
		// key에 대한 내림차순 정렬 처리
		
		Map dMap = tm.descendingMap();
		System.out.println(dMap);
	}

}
