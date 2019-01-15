package hashcode;

import java.util.HashSet;
import java.util.Iterator;

public class PersonORDemo {
	public static void main(String[] args) {
        HashSet<Person> hSet = new HashSet<Person>();
        hSet.add(new Person("LEE", 10));
        hSet.add(new Person("LEO", 10));
       	hSet.add(new Person("PARK", 35));
        hSet.add(new Person("OH", 35));

        System.out.println("저장된 데이터 수: " + hSet.size());
        System.out.println(hSet);
        Iterator<Person> it = hSet.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next().hashCode());
        }
    }
}
