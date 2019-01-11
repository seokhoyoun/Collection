package skillup.day05.run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest1 {

	public static void main(String[] args) {
		
		
		
		// Properties --> Map계열
		/*prop.put("새우깡", new Snack("짠맛", 500));
		
		System.out.println(prop);
		System.out.println(prop.get("새우깡"));
		
		
		try {
			prop.store(new FileOutputStream("test.properties"), "test중");
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Properties prop = new Properties();
		
		// 1. setProperty(String key, String value) : 값 저장
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		
		prop.setProperty("Map", "Properies");
		
		System.out.println(prop); // 순서유지 X, 키값 중복 X
		
		
		// 2. getProperty(String key) : 밸류값 알아내기
		System.out.println(prop.getProperty("List"));
		
		
		// 3. 반복자를 통해 하나씩 출력
		
		// 3_1. prop --> keySet
		Set<Object> keySet = prop.keySet();
		
		// 3_2. keySet --> iterator(정렬)
		Iterator<Object> itKey = keySet.iterator();
		
		// 3_3. 반복문을 통해 출력
		while(itKey.hasNext()) {
			String key = (String)itKey.next();
			
			System.out.println(prop.getProperty(key));
		}
		
				
		System.out.println("===== Enumeration(Key) ====");
		Enumeration<Object> enu1 = prop.keys();
		while(enu1.hasMoreElements()) {
			System.out.println(enu1.nextElement());
		}
		
		
		System.out.println("==== Enumeration(Value) ====");
		Enumeration<Object> enu2 = prop.elements();
		while(enu2.hasMoreElements()) {
			System.out.println(enu2.nextElement());
		}
		
		// 4. store(OuputStream os, String comments) : 파일로 저장
		try {
			//prop.store(new FileOutputStream("test2.properties"), "properties test");
			
			prop.storeToXML(new FileOutputStream("test3.xml"), "sss");
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
