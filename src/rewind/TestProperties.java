package rewind;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.TreeMap;

import test.entity.Employee;

public class TestProperties {

	public static void main(String[] args) {
		TestProperties test = new TestProperties();
		Properties prop = new Properties();
		
		Employee[] emp = test.readFile(prop);
		test.printConsole(prop);
		test.addEmpData(prop);
		test.printConsole(prop);
		test.saveEmpXML(emp);
		
		TreeMap<Integer,Employee> hm = new TreeMap<>();
		hm.put(20090417, new Employee(20190417,"고길동","재정부",38000000,0.2));
		hm.put(20070212, new Employee(20370212,"오상현","기획부",32000000,0.2));
		hm.put(20160602, new Employee(20060602,"김말순","편집부",33000000,0.2));
		hm.put(20020428, new Employee(20120428,"홍현주","출판부",28000000,0.2));
		hm.put(20150212, new Employee(20150212,"박길림","기획부",48000000,0.2));
		
		Iterator<Entry<Integer,Employee>> iter = hm.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer,Employee> ent = iter.next();
			prop.setProperty(String.valueOf(ent.getKey()), String.valueOf(ent.getValue()));
		}
		try {
			prop.store(new FileWriter("empData2.txt"), "saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

	private void saveEmpXML(Employee[] emp) {
		ArrayList<Employee> list = new ArrayList<>();
		for(Employee e : emp) {
			list.add(e);
		}
		list.sort(new AscID());
		Employee[] emp2 = new Employee[list.size()];
		list.toArray(emp2);
		Properties p = new Properties();
		for(Employee e : emp2) {
			int bpSal = e.getSalary() + (int)(e.getSalary()*e.getBonusPoint());
			p.setProperty(String.valueOf(e.getEld()), String.valueOf(e)+" "+String.valueOf(bpSal));
		}
		try {
			p.storeToXML(new FileOutputStream("empResult2.xml") , "saved", "UTF-8");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	private void addEmpData(Properties prop) {
		TreeMap<Integer,Employee> hm = new TreeMap<>();
		hm.put(20110230, new Employee(21233794, "김길정", "인사부" ,344000000, 0.2));
		hm.put(20110430, new Employee(21133334, "김아정", "인사부" ,328000000, 0.2));
		Iterator<Entry<Integer,Employee>> iter = hm.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, Employee> ent = iter.next();
			
			prop.setProperty(String.valueOf(ent.getKey()), String.valueOf(ent.getValue()));
		}
	}

	private void printConsole(Properties prop) {
		prop.list(System.out);
	}

	private Employee[] readFile(Properties prop) {
		try {
			prop.load(new FileReader("empData2.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterator<String> iter = prop.stringPropertyNames().iterator();
		Employee[] emp = new Employee[prop.size()];
		int i = 0;
		while(iter.hasNext()) {
			String keys = iter.next();
			String[] values = prop.getProperty(keys).split(" ");
			int eId = Integer.parseInt(values[0]);
			String name = values[1];
			String dept = values[2];
			int sal = Integer.parseInt(values[3]);
			double bp = Double.parseDouble(values[4]);
			emp[i++] = new Employee(eId,name,dept,sal,bp);
		}
		return emp;
	}

}
