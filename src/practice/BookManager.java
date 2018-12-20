package practice;

import java.util.ArrayList;
import java.util.Collections;

public class BookManager {
	// Field
	private ArrayList<Book> bookList;
	
	// Constructor
	public BookManager() {
		//기본생성자 : bookList 객체 생성함
		bookList = new ArrayList<Book>();
	}

	public BookManager(ArrayList<Book> bookList) {
		//매개변수있는 생성자 : 다른 리스트를 전달받아. 
		//bookList 객체의 초기값으로 사용함
		super();
		this.bookList = bookList;
	}
	
	public void addBook(Book book) {
		//리스트에 객체 추가
		bookList.add(book);
		
	}
	
	public void deleteBook(int index) {
		//리스트에서 객체 제거
		if(index > -1) {
			bookList.remove(index);
			System.out.println("삭제가 완료되었습니다.\n");
		}
	}
	
	public int searchBook(String bTitle) {
		//도서명이 일치하는 객체를 찾아 해당 인덱스를 리턴
		//도서명이 일치하는 객체가 리스트에 없으면, -1 리턴함
		Book[] br = new Book[bookList.size()];
		bookList.toArray(br);
		for(int i = 0; i < br.length; i++) {
			if(br[i].getTitle().equals(bTitle)) {
				return i;
			}
		}
		System.out.println("해당하는 도서가 없습니다.\n");
		return -1;
		
		
		
	}
	
	public void printBook(int index) {
		//인덱스 위치의 객체의 정보를 출력함
		if(index > -1)
		System.out.println(bookList.get(index));
	}
	
	public void displayAll() {
		//목록정보 모두 출력
		System.out.println(bookList);
	}
	
	public Book[] sortedBookList() {
		// 해당 카테고리순 오름차순정렬해서 객체배열 리턴함
		bookList.sort(new AscCategory());				
		Book[] br = new Book[bookList.size()];
		bookList.toArray(br);
		/*for(int i = 0; i < br.length; i++) {
			br[i] = (Book) oar[i];
		}*/
		return br;
	}
	
	public void printBookList(Book[] br) {
		//객체 배열 출력, for each 문 사용
		for(Book e : br) {
			System.out.println(e);
		}
		
	}
	
}
