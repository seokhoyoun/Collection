package skillup.day03.run;

import java.util.Iterator;
import java.util.TreeSet;

import skillup.day03.model.vo.Student;

public class TreeSetTest {
	
	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<>();
		
		Student stu1 = new Student("공유", 38, 100);
		Student stu2 = new Student("홍길동", 19, 20);
		Student stu3 = new Student("김말똥", 26, 40);
		Student stu4 = new Student("공유", 38, 100);
		Student stu5 = new Student("나나",19,40);
		
		ts.add(stu1);
		ts.add(stu2);
		ts.add(stu3);
		ts.add(stu4);
		ts.add(stu5);
		
		System.out.println(ts);
		// treeset을 사용하려면 comparable 인터페이스를 구현해야한다.
		
		Iterator<Student> it = ts.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		Iterator<Student> it2 = ts.descendingIterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		
		
	}

}