package practice;

import java.util.TreeSet;

public class Lotto {
	public static void main(String[] args) {
		lottoDisplay();
	}
	
	public static void lottoDisplay() {
		TreeSet ts = new TreeSet();
		for(int i = 0; ts.size() < 6; i++) {
			ts.add(((int)(Math.random()*45))+1);
		}
		System.out.println(ts);
		Object[] oar  = ts.toArray();
		int[] lotto = new int[6];
		for(int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) oar[i];
			System.out.print(lotto[i]+" ");
		}
		
	}
}
