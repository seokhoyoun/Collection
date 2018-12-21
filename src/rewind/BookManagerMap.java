package rewind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import practice.Book;

public class BookManagerMap {

	private HashMap<String,Book> booksMap;
	
	public BookManagerMap() {
		booksMap = new HashMap<String,Book>();
	}

	public BookManagerMap(HashMap<String, Book> booksMap) {
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
		Iterator<Entry<String, Book>> iter = booksMap.entrySet().iterator();
		String bt = null;
//		while(iter.hasNext()) {
//			key = iter.next().getKey();
//			if(booksMap.get(key).getTitle().equals(bTitle)) break;
//		}
		while(iter.hasNext()) {
			Map.Entry<String, Book> ent = iter.next();
			bt = ent.getValue().getTitle();
			if(bt.equals(bTitle)) break;
		}
		return bt;
	}
	
	public void displayAll() {
		Iterator<String> iter =  booksMap.keySet().iterator();
		while(iter.hasNext()) {
			System.out.println(booksMap.get(iter.next()));
		}
	}
	
	public Book[] sortedBookMap() {
		ArrayList<Book> list = new ArrayList<>(booksMap.values());
		list.sort(new AscBookName());
		Book[] b = new Book[list.size()];
		list.toArray(b);
		return b;
	}
	
	public void printBookMap(Book[] br) {
		for(Book e : br) {
			System.out.println(e);
		}
	}
	
	public void printBook(String key) {
		Iterator<String> iter = booksMap.keySet().iterator();
		while(iter.hasNext()) {
			Book keys = booksMap.get(iter.next());
			if(keys.getTitle().equals(key)) {
				System.out.println("조회 성공");
				System.out.println("책 정보 : "+keys);
			}
		}
	}
	
}
