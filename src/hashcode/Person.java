package hashcode;

import java.util.Objects;

public class Person {
	
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + ", " + age+"세";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age);
	}
	
	@Override
	public boolean equals(Object obj) {
		int oAge = ((Person)obj).age;
		String oName = ((Person)obj).name;
		
		if(this.age == oAge && this.name.equals(oName)) {
			return true;
		}
		else {
			return false;
		}
	}
}
