package rewind;

import java.util.Comparator;

import practice.Book;

public class AscBookName implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getTitle().compareTo(b2.getTitle());
	}

}
