package list.controller;

import java.util.ArrayList;

import list.model.vo.Book;

public class BookController {
	
	// 도서들을  담고 있는 bookList
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	{
		// 초기값 4개정도 추가
		bookList.add(new Book("자바의 정석", "홍길동", "기타", 20000));
		bookList.add(new Book("C언어", "김말똥", "기타", 15000));
		bookList.add(new Book("기술향상 도움이 되었나요", "강보람", "인문", 17500));
		bookList.add(new Book("수고많았어요 여러분", "KH", "의료", 10000));
	}
	
	
	public void insertBook(Book bk) {
		/*
		 * 1. 전달받은 bk를 bookList에 "추가 "
		 */
		bookList.add(bk);
		
	}
	
	
	public ArrayList<Book> selectList(){
		/*
		 * 1. 해당 bookList의 주소 값 반환
		 */
		
		return bookList; 	// 이 부분 수정해야되요~! 우선은 null로 해놨어요
	}
	
	
	public ArrayList<Book> searchBook(String keyword){
		/*
		 * 1. 검색 결과 리스트를 담아줄 리스트(ArrayList<Book> searchList) 선언 및 생성
		 * 2. 반복문을 통해 bookList의 책들 중 책명에 전달받은 keyword가 "포함 되어있는 경우" --> HINT : 조건식 작성할 때 String 클래스의 contains 메소드 사용하면 되겠죠?
		 *    searchList에 해당 책 "추가"하기 
		 * 3. searchList의 주소 값 반환
		 */
		ArrayList<Book> searchList = new ArrayList<>();
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getTitle().contains(keyword)) {
				searchList.add(bookList.get(i));
			}
		}
		
		return searchList;   // 이 부분 수정해야되요~! 우선은 null로 해놨어요
	}
	
	public Book deleteBook(String title, String author) {
		/*
		 * 1. 삭제된 도서를 담을 Book객체(Book remove) 선언 및 null로 초기화
		 * 2. 반복문을 통해 bookList의 책들 중 책명이 전달받은 title과 동일하고, 저자명이 전달받은 author와 동일한 경우 
		 *    해당 인덱스의 도서 "삭제"하고 빠져나가기 (이때 해당 인덱스 도서를 remove에 대입)
		 * 
		 * 3. remove의 주소 값 반환 
		 */
		
		Book remove = null;
		for(int i = 0; i < bookList.size(); i++) {
			if(title.equals(bookList.get(i).getTitle()) && author.equals(bookList.get(i).getAuthor())) {
				remove = bookList.get(i);
				bookList.remove(i);
			}
		}
		
		return remove;   // 이 부분 수정해야되요~! 우선은 null로 해놨어요
	}
	
	
	
	
}
