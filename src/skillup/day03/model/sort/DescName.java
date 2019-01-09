package skillup.day03.model.sort;

import java.util.Comparator;

import skillup.day03.model.vo.Student;

public class DescName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getName().compareTo(o1.getName());
	}

}
