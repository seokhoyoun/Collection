package practice4;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public class TestProperties {
	
	public void saveXMLFile(Student[] sr) {
		Properties prop = new Properties();
		for(int i = 0; i < sr.length; i++) {
			prop.setProperty(String.valueOf(sr[i].getSno()), sr[i].toString());
		}
		
		try {
			prop.storeToXML(new FileOutputStream("student.xml"), "학생성적결과");
		} catch (Exception e) {
		}
	}
	
	public void printConsole(Student[] sr) {
		int totKor=0, totEng=0, totMath=0;
		for(Student e : sr) {
			totKor += e.getKor();
			totEng += e.getEng();
			totMath += e.getMat();
		}
		System.out.println();
		System.out.println("국어 총점 : "+ totKor);
		System.out.println("영어 총점 : "+ totEng);
		System.out.println("수학 총점 : "+ totMath);
		System.out.println();
		System.out.println("국어 평균 : "+ totKor/4);
		System.out.println("영어 평균 : "+ totEng/4);
		System.out.println("수학 평균 : "+ totMath/4);
	}
	public static void main(String[] args) {
		TestProperties tp = new TestProperties();
		Student[] sr = tp.readFile();
		tp.printConsole(sr);
		tp.saveXMLFile(sr);
	}
	
	public Student[] readFile() {
		Properties prop = new Properties();
		int i = 0;
		Student[] sar = new Student[4];
		try {
			prop.load(new FileReader("score.txt"));
			Set<String> keys = prop.stringPropertyNames();
			Iterator<String> iter = keys.iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				String value = prop.getProperty(key);
				System.out.println(key+" = "+value);
				String[] str = value.split(",");
				int sno = Integer.parseInt(str[0]);
				String sname = str[1];
				int kor = Integer.parseInt(str[2]);
				int eng = Integer.parseInt(str[3]);
				int math = Integer.parseInt(str[4]);
				int tot = kor+eng+math;
				int avg = tot/3;
				sar[i++] = new Student(sno,sname,kor,eng,math,tot,avg);
			}
			
		} catch (Exception e) {
		}
		return sar;	
		
		
	}

}
