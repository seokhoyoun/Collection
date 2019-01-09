package skillup.day03.model.sort;

import java.util.Comparator;

import skillup.day03.model.vo.Student;

public class AscScore implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getScore() - o2.getScore();
	}
	
	
/*	@Override
	public int compare(Object o1, Object o2) {
		int score1 = ((Student)o1).getScore();
		int score2 = ((Student)o2).getScore();
		
		return score1 - score2;
	}*/
}
