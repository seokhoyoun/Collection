package make.generic;

public class DDBox <U,D>{
	
	private DBox l;
	private DBox r;
	
	public static void main(String[] args) {
		DBox<String, Integer> box1 = new DBox<>();
		box1.set("apple", 25);
		DBox<String, Integer> box2 = new DBox<>();
		box2.set("orange", 33);
		DDBox<DBox<String,Integer>,DBox<String,Integer>> ddbox = new DDBox<>();
		ddbox.set(box1,box2);
		System.out.println(ddbox);
	}

	public void set(DBox<String, Integer> box1, DBox<String, Integer> box2) {
		l = box1;
		r = box2;
	}
	
	@Override
	public String toString() {
		return l.toString()+"\n"+r.toString();
	}
}
