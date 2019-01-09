package skillup.day03.run;

import java.util.HashSet;
import java.util.Iterator;

import skillup.day03.model.vo.Student;

public class HashSetTest {

	public static void main(String[] args) {
		
		//Set hs = new Set(); 
		//Set hs = new HashSet();
		
		HashSet hs = new HashSet(3);
		
		String str1 = "반갑습니다";
		String str2 = "안녕하세요";
		String str3 = "여러분";
		String str4 = "여러분";
		String str5 = "헬로우";
		
		hs.add(str1);
		hs.add(str2);
		hs.add(str3);
		hs.add(str4);
		hs.add(str5);
		
		System.out.println(hs);
		
		
		System.out.println(str3.equals(str4));
		
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		
		
		
		System.out.println("==================");
		
		
		HashSet<Student> hs2 = new HashSet<>();
		
		Student stu1 = new Student("공유", 38, 100);
		Student stu2 = new Student("홍길동", 19, 20);
		Student stu3 = new Student("김말똥", 26, 40);
		
		Student stu4 = new Student("공유", 38, 100);
		
		
		hs2.add(stu1);
		hs2.add(stu2);
		hs2.add(stu3);
		hs2.add(stu4);
		
		System.out.println(hs2);
		
		
		System.out.println(stu1.equals(stu4));
		
		System.out.println(stu1.hashCode());
		System.out.println(stu4.hashCode());
		
		
		System.out.println("=================");
		
		// 1. for each문 (향상된 포문)
		for(Student stu : hs2) {
			System.out.println(stu);
		}
		
		System.out.println("=================");
		
		// 2. Iterator(반복자) 사용
		Iterator<Student> it = hs2.iterator();
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
