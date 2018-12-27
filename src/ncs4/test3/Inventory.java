package ncs4.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Inventory {
	private String productName; //상품명
	private Date putDate; //입고일
	private Date getDate;//출고일
	private int putAmount; //입고수량
	private int getAmount; //출고수량
	private int inventoryAmount;//재고수량
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy'년 'MM'월 'dd'일'");
	
	public Inventory() {
		
	}

	public Inventory(String productName, Date putDate, int putAmount) {
		super();
		this.productName = productName;
		this.putDate = putDate;
		this.putAmount = putAmount;
		this.inventoryAmount = putAmount;
	}
	
	@Override
	public String toString() {
		if(this.getGetDate() == null) 
			return this.productName+" : "+sdf.format(putDate)+" 입고 "+this.getGetDate()+" "+this.putAmount+"개 "+this.getAmount+"개 재고 "+this.inventoryAmount+"개";
		else 
			return this.productName+" : "+sdf.format(putDate)+" 입고 "+sdf.format(getDate)+" 출고 "+this.putAmount+"개 "+this.getAmount+"개 재고 "+this.inventoryAmount+"개";
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getPutDate() {
		return putDate;
	}

	public void setPutDate(Date putDate) {
		this.putDate = putDate;
	}

	public Date getGetDate() {
		return getDate;
	}

	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}

	public int getPutAmount() {
		return putAmount;
	}

	public void setPutAmount(int putAmount) {
		this.putAmount = putAmount;
	}

	public int getGetAmount() {
		return getAmount;
	}

	public void setGetAmount(int getAmount) {
		this.getAmount = getAmount;
		this.inventoryAmount = this.inventoryAmount - getAmount;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}
	
	
}
