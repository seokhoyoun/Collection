package skillup.day03.model.vo;

public class Student implements Comparable<Student>{
	private String name;
	private int age;
	private int score;
	
	public Student() {
		
	}

	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		// this 왼쪽 o 오른쪽 (오름차순 기준) 
		return this.age - o.age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		if(this.name.equals(other.name) && this.age == other.age && this.score == other.score)
			return true;
		else
			return false;
	}

	
	
	
}
