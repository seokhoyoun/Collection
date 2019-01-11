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
		
		return bookList; 	
	}
	
	
	public ArrayList<Book> searchBook(String keyword){
		/*
		 * 1. 검색 결과 리스트를 담아줄 리스트(ArrayList<Book> searchList) 선언 및 생성
		 * 2. 반복문을 통해 bookList의 책들 중 책명에 전달받은 keyword가 "포함 되어있는 경우" --> HINT : 조건식 작성할 때 String 클래스의 contains 메소드 사용하면 되겠죠?
		 *    searchList에 해당 책 "추가"하기 
		 * 
		 * 3. searchList의 주소 값 반환
		 */
		
		// 1번 과정
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		// 2번 과정
		for(int i=0; i<bookList.size(); i++) {
			
			Book bk = bookList.get(i);
			
			if(bk.getTitle().contains(keyword)) {
				searchList.add(bk);
			}
		}
		
		// 3번 과정
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		/*
		 * 1. 삭제된 도서를 담을 Book객체(Book remove) 선언 및 null로 초기화
		 * 2. 반복문을 통해 bookList의 책들 중 책명이 전달받은 title과 동일하고, 저자명이 전달받은 author와 동일한 경우 
		 *    해당 인덱스의 도서 "삭제"하기 (이때 해당 인덱스 도서를 remove에 대입)
		 *    
		 * 3. remove의 주소 값 반환
		 */
		
		// 1번 과정
		Book remove = null;
		
		// 2번 과정_단순 for문 사용하기
		/* ---------------------------------------
		for(int i=0; i<bookList.size(); i++) {
			Book bk = bookList.get(i);
			
			if(bk.getTitle().equals(title) && bk.getAuthor().equals(author)) {
				bookList.remove(i);
				remove = bk;
			}
		}
		---------------------------------------- */
		
		// 2번 과정_for each문 사용하기 
		for(Book bk : bookList) {
			
			if(bk.getTitle().equals(title) && bk.getAuthor().equals(author)) {
				bookList.remove(bk);
				remove = bk;
				break; // 위의 단순 for문 방식과 비슷하게 생각하면 큰 오산 --> for each문 사용할때는 꼭 break를 통해 빠져나가줘야된다. 
					   // 마지막 값 삭제할때는 문제가 없어 보일 수 있지만 가운데 값을 삭제하려는 순간 ConcurrentModificationException 예외가 발생할 수 있다. 
					   // List를 순회하는 for each문을 통해 삭제할 때 종종 볼 수 있는 예외이다.
				
					   // 즉, 여러분들은 for each문은 단순히 전체 조회할 때만 쓰는 습관을 들이세요~! 
			}
			
		}
		
		// 3번 과정
		return remove; 
	}
	
	
	
	
}
