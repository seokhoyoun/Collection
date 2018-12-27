package ncs4.test2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

public class PropTest {
	
	

	public static void main(String[] args) {
		Properties p = new Properties();
		PropTest pt = new PropTest();
		p.setProperty("1","apple,1200,3");
		p.setProperty("2","banana,2500,2");
		p.setProperty("3","grape,4500,5");
		p.setProperty("4","orange,800,10");
		p.setProperty("5","melon,5000,2");
		pt.fileSave(p);
		pt.fileOpen(p);
	}
	
	public void fileSave(Properties p) {
		try{
			p.storeToXML(new FileOutputStream("data.xml"), "saved", "UTF-8");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileOpen(Properties p) {
		TreeMap<Integer,Fruit> tm = new TreeMap<>();
		Fruit[] f = new Fruit[p.size()];
		int i = 0;
		try {
			p.loadFromXML(new FileInputStream("data.xml"));
			Set<String> keys = p.stringPropertyNames();
			Iterator<String> iter = keys.iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				String values = p.getProperty(key);
				String[] value = values.split(",");
				// name value[0]
				int price = Integer.parseInt(value[1]);
				int quantity = Integer.parseInt(value[2]);
				f[i] = new Fruit(value[0],price,quantity);
				tm.put(Integer.parseInt(key), f[i]);
			}
			int k = 0;
			Iterator<Integer> iter2 = tm.keySet().iterator();
			Fruit[] ff = new Fruit[p.size()]; 
			while(iter2.hasNext()) {
				int key = iter2.next();
				f[k] = tm.get(key);
				System.out.println(key+" = "+f[k++]); 
			}
			/*for(int k = key; k <= tm.size(); k++) {
				System.out.print(k+" = ");
				System.out.print(tm.get(k)+"\n");
			}*/
			/*System.out.println("!!");
			for(int z = 0; z < f.length; z++) {
				System.out.println(f[z]);
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
