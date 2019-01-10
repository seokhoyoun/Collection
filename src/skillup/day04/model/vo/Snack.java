package skillup.day04.model.vo;

public class Snack {
	
//	private String name;
	private String flavor;
	private int cal;
	
	public Snack() {
		
	}

	public Snack(String flavor, int cal) {
		super();
		this.flavor = flavor;
		this.cal = cal;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", cal=" + cal + "]";
	}
	
	
}
