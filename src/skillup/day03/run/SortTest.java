package skillup.day03.run;

import java.util.ArrayList;
import java.util.Collections;

import skillup.day03.model.sort.AscName;
import skillup.day03.model.sort.AscScore;
import skillup.day03.model.sort.DescName;
import skillup.day03.model.sort.DescScore;
import skillup.day03.model.vo.Student;

public class SortTest {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		
		list.add(new Student("이길동",24,80));
		list.add(new Student("홍길순",34,70));
		list.add(new Student("김길동",14,60));
		list.add(new Student("오길현",47,50));
		list.add(new Student("지길오",17,90));
		
		for(Student e : list) {
			System.out.println(e);
		}
		
		System.out.println("========== 점수 ASC");
		Collections.sort(list, new AscScore());
		for(Student e : list) {
			System.out.println(e);
		}
		System.out.println("========== 점수 DSC");
		Collections.sort(list, new DescScore());
		for(Student e : list) {
			System.out.println(e);
		}
		
		System.out.println("========== 이름 ASC");
		Collections.sort(list, new AscName());
		for(Student e : list) {
			System.out.println(e);
		}
		
		System.out.println("========== 이름 DSC");
		Collections.sort(list, new DescName());
		for(Student e : list) {
			System.out.println(e);
		}
	}

}
