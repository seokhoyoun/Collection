package practice;

public class AscCategory implements java.util.Comparator<Book>{
	
	@Override
	public int compare(Book a1, Book a2) {
		
		return (a1.getCategory() > a2.getCategory())? a2.getCategory() : a1.getCategory();
	}
	
}
