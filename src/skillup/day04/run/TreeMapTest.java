package skillup.day04.run;

import java.util.TreeMap;

import skillup.day04.model.vo.Snack;

public class TreeMapTest {
	public static void main(String[] args) {
		
		TreeMap<String, Snack> tm = new TreeMap<>();
		
		tm.put("다이제", new Snack("초코맛", 1500));
		tm.put("칸초", new Snack("단맛", 600));
		tm.put("새우깡", new Snack("짠맛", 650));
		tm.put("초코칩", new Snack("초코맛", 1500));
		
		System.out.println(tm);
		
		
	}
}
