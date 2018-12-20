package test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Properties;

import test.entity.Employee;

public class TestProperties {

	public static void main(String[] args) {
		TestProperties test = new TestProperties();
		Properties prop = new Properties();
		
		test.readFile(prop);
		printConsole(prop);
		addEmpData(prop);
		printConsole(prop);
//		saveEmpXML(Employee[] ear);
		
		HashMap<Integer,Employee> hm = new HashMap<>();
		hm.put(20190417, new Employee("홍길동","재정부",38000000,0.2));
		hm.put(20170212, new Employee("오길현","기획부",32000000,0.2));
		hm.put(20160602, new Employee("김길순","편집부",33000000,0.2));
		hm.put(20120428, new Employee("홍길주","출판부",28000000,0.2));
		hm.put(20150212, new Employee("박길동","기획부",48000000,0.2));
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("EmpData.txt")))){
			oos.writeObject(hm);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void saveEmpXML(Object object) {
		
	}

	public static void addEmpData(Properties p) {
		
	}

	public static void printConsole(Properties p) {
		
	}

	public Employee[] readFile(Properties p) {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("EmpData.txt")))){
			System.out.println(ois.readObject());
			p.put(null, ois.readObject());
		} catch (EOFException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
