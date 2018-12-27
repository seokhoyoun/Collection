package ncs4.test1;

import java.util.ArrayList;
import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			list.add(r.nextInt(100)+1);
		}
		System.out.print("정렬 전 : ");
		display(list);
		list.sort(new Descending());
		System.out.print("정렬 후 : ");
		display(list);
	}

	public static void display(ArrayList<Integer> list) {
		for(Integer e : list) {
			System.out.print(e+" ");
		}System.out.println();
	}
}
