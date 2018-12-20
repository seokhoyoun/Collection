package test.properties;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class TestProperties4 {

	public static void main(String[] args) {
		// Properties loop test
		
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader("setting.txt"));
			
			Set<String> keys = prop.stringPropertyNames();
			Iterator<String> iter = keys.iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				String value = prop.getProperty(key);
				
				System.out.println(key+"="+value);
			}
		} catch (Exception e) {
		}
	}

}
