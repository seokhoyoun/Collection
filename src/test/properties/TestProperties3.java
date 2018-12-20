package test.properties;

import java.io.FileReader;
import java.util.Properties;

public class TestProperties3 {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("sample.txt"));
			prop.list(System.out);
			String name  = prop.getProperty("name");
			int age = Integer.parseInt(prop.getProperty("age"));
			char gender = prop.getProperty("gender").charAt(0);
			double height = Double.parseDouble(prop.getProperty("height"));
			
			System.out.println(name+" "+age+" "+gender+" "+height);
			
		} catch (Exception e) {
		}
			
		
		
	}

}
