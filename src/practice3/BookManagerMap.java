package practice3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import practice.Book;
import practice.DesBookName;

public class BookManagerMap {

	private HashMap<String,Book> booksMap;
	
	public BookManagerMap() {
		booksMap = new HashMap<String,Book>();
	}

	public BookManagerMap(HashMap<String,Book> booksMap) {
		super();
		this.booksMap = booksMap;
	}
	
	public void putBook(Book b) {
		booksMap.put(b.getbNo(), b);
	}
	
	public void removeBook(String key) {
		booksMap.remove(key);
	}
	
	public void searchBook(String bTitle) {
		 ent = booksMap.entrySet(); 
	}
	
	public void displayAll() {
		
	}
	
	public Book[] sortedBookMap() {
		Collection<Book> values = booksMap.values();
		Iterator<Book> iter = values.iterator();
		ArrayList<Book> list = new ArrayList<>();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		list.sort(new DesBookName());
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getTitle());
		}
		Book[] b = new Book[values.size()];
		
		return null;
	}
	
	public void printBookMap(Book[] br) {
		
	}
	
	public void printBook(String key) {
		
	}
	
	
}
