package ncs4.test4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoodsTest {

	public static void main(String[] args) {
		Goods goods = new Goods();
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			System.out.print("상품명 : ");
			String pn = br.readLine();
			System.out.print("가격 : ");
			int price = Integer.parseInt(br.readLine());
			System.out.print("수량 : ");
			int q = Integer.parseInt(br.readLine());
			goods.setName(pn);
			goods.setPrice(price);
			goods.setQuantity(q);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(goods);
		System.out.println("총 구매 가격 : "+goods.getPrice()*goods.getQuantity()+" 원");
		
	}

}
