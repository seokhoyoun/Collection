package make.generic;

public class BoxSwapDemo {

	public static void main(String[] args) {
		
		Box<String> box1 = new Box<>();
		box1.set("aaa");
		Box<String> box2 = new Box<>();
		box2.set("vvv");
		System.out.println(box1.get()+"&"+box2.get());
		swapBox(box1,box2);
		System.out.println(box1.get()+"&"+box2.get());
	}

	public static <T> void swapBox(Box<T> box1, Box<T> box2) {
		T tmp = box1.get();
		box1.set(box2.get());
		box2.set(tmp);
	}

}
