package test.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import board.model.vo.Board;

public class TestMapGeneric {
	
	public HashMap<Integer,Board> makeMap(){
		
		HashMap<Integer,Board> hm = new HashMap<>();
		hm.put(1, new Board());
		hm.put(2, new Board());
		hm.put(3, new Board());
		hm.put(4, new Board());
		return hm;
	}
	
	public static void main(String[] args) {
		TestMapGeneric test = new TestMapGeneric();
		HashMap<Integer,Board> hm = test.makeMap();
		test.printMap(hm);
	}

	public void printMap(HashMap<Integer, Board> hm) {
//		System.out.println(hm.values());
//		System.out.println(hm.keySet());
//		System.out.println(hm.entrySet());
		System.out.println(hm.get(0));
		Set<Integer> keys = hm.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()) {
			Integer y = iter.next();
			Board value = hm.get(y);
			
			System.out.println(value);
		}
	}
	
	public void printMap2(HashMap<Integer,Board> hm) {
		Set<Map.Entry<Integer,Board>> ent = hm.entrySet();
		hm.entrySet();
		Iterator<Map.Entry<Integer, Board>> iter  = ent.iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, Board> entry = iter.next();
			Integer key = entry.getKey();
			Board value = entry.getValue();
		}
		System.out.println(ent); 
		
		
		
		
	}

}
