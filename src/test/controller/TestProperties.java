package test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

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
		
		/*HashMap<Integer,Employee> hm = new HashMap<>();
		hm.put(20190417, new Employee(20190417,"홍길동","재정부",38000000,0.2));
		hm.put(20170212, new Employee(20170212,"오길현","기획부",32000000,0.2));
		hm.put(20160602, new Employee(20160602,"김길순","편집부",33000000,0.2));
		hm.put(20120428, new Employee(20120428,"홍길주","출판부",28000000,0.2));
		hm.put(20150212, new Employee(20150212,"박길동","기획부",48000000,0.2));
		
		try {
//			Set<Integer> es = hm.keySet();
//			Iterator<Integer> iter = es.iterator();
			Iterator<Integer> iter = hm.keySet().iterator();
			while(iter.hasNext()) {
				int key = iter.next();
				prop.setProperty(String.valueOf(key), String.valueOf(hm.get(key)));
			}
			prop.store(new FileWriter("empData.txt"), "emp test");
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		
		
	}

	public void saveEmpXML(Employee[] emp) {
		int bpSal = 0;
		Properties p = new Properties();
		StringBuilder sb = new StringBuilder();
		for(Employee e : emp) {
			bpSal = e.getSalary() + ((int)(e.getSalary()*e.getBonusPoint()));
//			System.out.println(String.valueOf(bpSal));
			p.setProperty(String.valueOf(e.getEld()), String.valueOf(e)+" "+String.valueOf(bpSal));
		}
			try {
				p.storeToXML(new FileOutputStream("empResult.xml"), "Saved", "UTF-8");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}

	public void addEmpData(Properties p) {
		HashMap<Integer,Employee> hm = new HashMap<>();
		hm.put(20110230, new Employee(21233794, "김길정", "인사부" ,344000000, 0.2));
		hm.put(20110430, new Employee(21133334, "김아정", "인사부" ,328000000, 0.2));
		Iterator<Integer> iter = hm.keySet().iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			p.setProperty(String.valueOf(key), String.valueOf(hm.get(key)));
		}
	}

	public void printConsole(Properties p) {
		p.list(System.out);
		/*System.out.println("--------------------------------------");
		Iterator<String> iter = p.stringPropertyNames().iterator();
		while(iter.hasNext()) {
			System.out.println(p.getProperty(iter.next()));
		}*/
	}

	public Employee[] readFile(Properties p) {
		try {
			p.load(new FileReader("empData.txt"));
			p.list(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<String> keys = p.stringPropertyNames();
		Iterator<String> iter = keys.iterator();
		Employee[] emp = new Employee[keys.size()];
		int i = 0;
		while(iter.hasNext()) {
			String key = iter.next();
			String value = p.getProperty(key);
			String[] values = value.split(" ");
			int eNo = Integer.parseInt(values[0]);
			String eName = values[1];
			String dept = values[2];
			int sal = Integer.parseInt(values[3]);
			double bp = Double.parseDouble(values[4]);
			emp[i++] = new Employee(eNo,eName,dept,sal,bp);
		}
		return emp;
	}

}
