package make.generic;

public class MyArray<T> {
	// type(자료형)
	
	private T[] arr;
	
	public MyArray(T[] arr) {
		this.arr = arr;
	}
	
	public void setArr(T[] arr) {
		this.arr = arr;
	}
	
	public T[] getArr() {
		return arr;
	}
	
	public void displayAll() {
		for(T obj : arr) {
			System.out.println(obj);
			// T 타입은 toString 오버라이딩 해야함
		}
	}
}
