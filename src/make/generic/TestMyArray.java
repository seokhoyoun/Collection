package make.generic;

public class TestMyArray {

	public static void main(String[] args) {
		// MyArray test
		
		MyArray<Integer> arr = new MyArray<>(new Integer[] {10,20,30,40,50});
		arr.displayAll();
		
		MyArray<String> arr2 = new MyArray<>(new String[] {"aaa","bbb","ccc","ddd","eeee"});
		arr2.displayAll();
		
		
	}

}
