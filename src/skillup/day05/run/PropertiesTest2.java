package skillup.day05.run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest2 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		try {
//			prop.load(new FileInputStream("test2.properties"));
			prop.loadFromXML(new FileInputStream("test3.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop);
		
		// xml은 프로그램 호환이쉽다
		// 개발자가 아닌 일반인 수정 편리
	}

}
