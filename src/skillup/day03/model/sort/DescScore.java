package skillup.day03.model.sort;

import java.util.Comparator;

import skillup.day03.model.vo.Student;

public class DescScore implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getScore() - o1.getScore();
	}

}
