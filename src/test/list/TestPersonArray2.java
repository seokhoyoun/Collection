package test.list;
import java.util.*;

public class TestPersonArray2 {

	public static void main(String[] args) {
		// Generic 사용 테스트
		ArrayList<Person> list; 
		
		
		list = addMethod();
		printList(list);
		System.out.println("---------------------------------------");
		list.sort(new PointAscending());
		printList(list);
		System.out.println("---------------------------------------");
		list.sort(new PointDescending());
		printList(list);
	}
	
	public static void printList(ArrayList<Person> list) {
		double totalPoint = 0;
		for(Person e : list) {
			System.out.println(e);
			totalPoint += e.getPoint();
		}
		System.out.println("포인트 합계 : "+totalPoint);
	}

	public static ArrayList<Person> addMethod() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("홍길현",22,1954.5));
		list.add(new Person("김길동",25,1234.5));
		list.add(new Person("박길순",27,134.5));
		return list;
	}

}
