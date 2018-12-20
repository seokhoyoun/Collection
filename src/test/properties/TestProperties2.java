package test.properties;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperties2 {

	public static void main(String[] args) {
		// Properties file load test
		
		Properties prop1 = new Properties();
		Properties prop2 = new Properties();
		
		try {
			prop1.load(new FileReader("setting.txt"));
			prop2.load(new FileInputStream("setting.xml"));
			
			prop1.list(System.out);
			System.out.println("===============================");
			prop2.list(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
