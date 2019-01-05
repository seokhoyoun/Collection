package make.generic;

public class BoundWildcardGeneric {

	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		box1.set(24);
		Box<String> box2 = new Box<>();
		box2.set("Poly");
		
		if(compBox(box1, 24))
			System.out.println("상자 안에 24 저장");
		if(compBox(box2, "Poly"))
			System.out.println("상자 안에 Poly 저장");
		
		System.out.println(box1.get());
		System.out.println(box2.get());
	}

	public static <T> boolean compBox(Box<? extends T> box, T con) {
		T bc = box.get();
		return bc.equals(con);
	}

}
