package ncs4.test3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Inventory> hm = new HashMap<>();
		
		hm.put("삼성 갤럭시S7", new Inventory("삼성 갤럭시 S7",new GregorianCalendar(2016,03,15).getTime(),30));
		hm.put("LG G5", new Inventory("LG G5",new GregorianCalendar(2016,02,25).getTime(),20));
		hm.put("애플 아이패드 Pro", new Inventory("애플 아이패드 Pro",new GregorianCalendar(2016,01,23).getTime(),15));
		
		Set<Entry<String,Inventory>> ent = hm.entrySet();
		Iterator<Entry<String, Inventory>> iter = ent.iterator();
		int i = 0;
		Inventory[] iv = new Inventory[3];
		while(iter.hasNext()) {
			Map.Entry<String, Inventory> kv = iter.next();
			System.out.println(kv.getValue());
			iv[i++] = kv.getValue(); 
		}
		
		System.out.println("\n출고 수량 10 적용시 ----------------------------------------------------\n");
		for(Inventory e : iv) {
			e.setGetDate(Calendar.getInstance().getTime());
			e.setGetAmount(10);
			if(e.getGetAmount() > e.getPutAmount()) {
				try {
					throw new AmountNotEnough("출고 수량이 재고 수량 보다 많습니다."); 
				} catch (AmountNotEnough e1) {
					e1.getMessage(); 
				}
			}
			System.out.println(e);
		}
		
		
		System.out.println("\n출고수량 부족시--------------------------------------------------------------\n");
		for(Inventory e : iv) {
			e.setGetDate(Calendar.getInstance().getTime());
			e.setGetAmount(50);
			if(e.getGetAmount() > e.getPutAmount()) {
				try {
					throw new AmountNotEnough("출고 수량이 재고 수량 보다 많습니다.");
				} catch (AmountNotEnough e1) {
					e1.getMessage(); return;
				}
			}
			System.out.println(e);
		}
	}

}
