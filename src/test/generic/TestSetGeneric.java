package test.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class TestSetGeneric {
	
	public HashSet<String> makeSet(){
		HashSet<String> hs = new HashSet<>();
		
		hs.add("java5");
		hs.add("java3");
		hs.add("java2");
		hs.add("java4");
		hs.add("java7");
		
		return hs;
		
	}
	
	public static void main(String[] args) {
		
		TestSetGeneric test = new TestSetGeneric();
		HashSet<String> hs = test.makeSet();
		test.printHS(hs);
	}

	public void printHS(HashSet<String> hs) {
		TreeSet<String> ts = new TreeSet<>(hs);
		for(String e : hs) {
			System.out.println(e);
		}
		System.out.println("----------------------------------");
		System.out.println(ts);
		System.out.println("----------------------------------");
		Iterator<String> iter = hs.iterator();
		Iterator<String> tter = ts.iterator(); 
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		System.out.println("----------------------------------");
		while(tter.hasNext()) {
			String a = tter.next();
			System.out.println(a);
		}
	}

}
