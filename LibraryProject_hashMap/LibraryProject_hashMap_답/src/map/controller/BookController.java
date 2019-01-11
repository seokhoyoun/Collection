package map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import map.model.vo.Book;

public class BookController {
	
	// 도서들을  담고 있는 bookMap
	private HashMap<Integer, Book> bookMap = new HashMap<>();
	int count = 0;	// 키값으로 사용될 변수
	
	{
		// 초기값 4개정도 추가
		bookMap.put(1, new Book("자바의 정석", "홍길동", "기타", 20000));
		bookMap.put(2, new Book("C언어", "김말똥", "기타", 15000));
		bookMap.put(3, new Book("기술향상 도움이 되었나요", "강보람", "인문", 17500));
		bookMap.put(4, new Book("수고많았어요 여러분", "KH", "의료", 10000));
		
		count = 5;
	}
	
	
	
	public void insertBook(Book bk) {
		/*
		 * 1. 전달받은 bk를 bookMap에 키값(count)과 함께 "추가 "하기
		 * 2. count 증가시켜주기
		 */
		
		// 1번 과정
		bookMap.put(count, bk);
		// 2번 과정
		count++;
	}
	
	
	public HashMap<Integer, Book> selectMap(){
		/*
		 * 1. 해당 bookMap의 주소 값 반환
		 */
		
		return bookMap; 	
	}
	
	
	public HashMap<Integer, Book> searchBook(String keyword){
		/*
		 * 1. 검색 결과를 담아줄 임의의 맵(HashMap<Integer, Book> searchMap) 선언 및 생성
		 *    
		 * 2. 반복자을 통해 bookMap의 책들 중 책명에 전달받은 keyword가 "포함 되어있는 경우" --> HINT : 조건식 작성할 때 String 클래스의 contains 메소드 사용하면 되겠죠?
		 *    searchMap에 해당 책 "추가"하기 
		 *    
		 *    ** keySet방법도 해보시고 entrySet방법도 해보세요~!!
		 * 
		 * 3. searchMap의 주소 값 반환
		 */
		
		// 1번 과정
		HashMap<Integer, Book> searchMap = new HashMap<Integer, Book>();
		
		// 2번 과정_keySet버전
		/* ---------------------------------------
		Set<Integer> keySet = bookMap.keySet();
		Iterator<Integer> itKey = keySet.iterator();
		
		while(itKey.hasNext()) {
			Integer key = itKey.next(); // 키값
			Book bk = bookMap.get(key); // 밸류값
			
			if(bk.getTitle().contains(keyword)){
				searchMap.put(key, bk);
			}
		}
		--------------------------------------- */
		
		// 2번 과정_entrySet버전
		Set<Entry<Integer, Book>> entrySet = bookMap.entrySet();
		Iterator<Entry<Integer, Book>> itEntry = entrySet.iterator();
		
		while(itEntry.hasNext()) {
			Entry<Integer, Book> en = itEntry.next();
			
			Integer key = en.getKey();
			Book bk = en.getValue();
			
			if(bk.getTitle().contains(keyword)) {
				searchMap.put(key, bk);
			}
		}
		
		// 3번 과정
		return searchMap;  
	}
	
	public Book deleteBook(int bNo) {
		/*
		 * 1. 삭제된 도서를 담을 Book객체(Book remove) 선언 및 null로 초기화
		 * 2. bookMap에 전달받은 bNo(키 값)을 이용하여 삭제  (이때 해당 키 값의 도서를 remove에 대입)
		 * 
		 * 3. remove의 주소 값 반환 
		 */
		
		// 1번 과정
		Book remove = null;
		
		// 2번 과정
		remove = bookMap.remove(bNo);
		
		// 3번 과정
		return remove;  
	}
	
	
		

}
