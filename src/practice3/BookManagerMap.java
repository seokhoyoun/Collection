package practice3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
	
	public String searchBook(String bTitle) {
		Set<Entry<String, Book>> mset = booksMap.entrySet();
		Iterator<Entry<String, Book>> iter = mset.iterator();	
		while(iter.hasNext()) {
			Map.Entry<String, Book> entry = iter.next();
			if(entry.getValue().getTitle().equals(bTitle)) {
				return entry.getValue().getTitle(); 
			}
		} return null;
	}
	
	public void displayAll() {
		Set<String> keys = booksMap.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(booksMap.get(key));
		}
	}
	
	public Book[] sortedBookMap() {
		ArrayList<Book> list = new ArrayList<>(booksMap.values());
		list.sort(new AscBookMap());
		Book[] bar = new Book[list.size()];
		list.toArray(bar);
		return bar;
		
	}
	
	public void printBookMap(Book[] br) {
		for(Book e : br) {
			System.out.println(e);
		}
	}
	
	public void printBook(String key) {
		System.out.println(booksMap.get(key)); 
		
	}
	
	
}
