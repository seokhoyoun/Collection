package practice;

public class AscCategory implements java.util.Comparator<Book>{
	
	@Override
	public int compare(Book a1, Book a2) {
		int a = a1.getCategory();
		int b = a2.getCategory();
		System.out.println("1111");
		return (a > b)? b : a;  
	}
	
}
