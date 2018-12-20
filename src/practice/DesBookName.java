package practice;

public class DesBookName implements java.util.Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		
		return b1.getTitle().compareTo(b2.getTitle());
	}

	

}
