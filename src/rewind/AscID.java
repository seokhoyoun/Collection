package rewind;

import java.util.Comparator;

import test.entity.Employee;

public class AscID implements Comparator<Employee>{

	@Override
	public int compare(Employee a, Employee a1) {
		return a.getEld() > a1.getEld() ? 1 : a.getEld() < a1.getEld()? -1 : 0;
	}

}
