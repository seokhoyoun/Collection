package make.generic;

public class DBox<L,R> {
	private L left;
	private R right;
	
	public void set(L l, R r) {
		left = l;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + "&"+right+"\n";
	}
	
	public static void main(String[] args) {
		DBox<DBox<String,Integer>,DBox<String,Integer>> dbox = new DBox<>();
		DBox<String,Integer> box1 = new DBox<>();
		box1.set("apple", 25);
		DBox<String,Integer> box2 = new DBox<>();
		box2.set("orange", 44);
		dbox.set(box1, box2);
		System.out.println(dbox);
		
	}
}
