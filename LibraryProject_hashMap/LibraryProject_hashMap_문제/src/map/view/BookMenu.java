package map.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import map.controller.BookController;
import map.model.vo.Book;

public class BookMenu {

	private BookController bc = new BookController(); // BookController의 메소드들을 사용하기 위한 레퍼런스
	Scanner sc = new Scanner(System.in); // 사용자에게 키보드로 값을 입력 받기 위한 Scanner 객체
	
	public void mainMenu() {
		
		System.out.println("== Welcome KH Library ==");
		
		while(true) {
			System.out.println("===== 메인 메뉴 ====");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색 조회");
			System.out.println("4. 도서 삭제하기");
			
			System.out.println("0. 프로그램 종료하기");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: insertBook(); break;
			case 2: selectMap(); break;
			case 3: searchBook(); break;
			case 4: deleteBook(); break;
			case 0: System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못입력하였습니다. 다시 입력해주세요"); break;
			}
		}
		
	}
	
	
	// 1. 새 도서 추가용 view 메소드
	public void insertBook() {
		/*
		 * 1. 도서명 입력받기 (String title)
		 * 2. 저자명 입력받기 (String author)
		 * 3. 장르 입력받기 (int category) --> 숫자로 입력받기 (1.인문 / 2.자연과학 / 3.의료 / 4.기타)
		 * 4. 가격 입력받기 (int price)
		 * 5. 매개변수 생성자를 이용하여 Book 객체 생성 (단, 객체 생성 시 장르 번호별로 조건식 이용해서 장르번호가 아닌 장르명으로 값 넘겨야되요!)
		 * 
		 * 6. bc(BookController)의 insertBook으로 위의 Book 객체 전달
		 * 
		 */
		System.out.println("도서명 입력 : ");
		String title = sc.nextLine();
		System.out.println("저자명 입력 : ");
		String author = sc.nextLine();
		System.out.println("장르명 입력 : ");
		int category = sc.nextInt();
		String scg = null;
		switch(category) {
		case 1 : scg = "인문"; break;
		case 2 : scg = "자연과학"; break;
		case 3 : scg = "의료"; break;
		case 4 : scg = "기타"; break;
		default: System.out.println("1~4번만 입력 가능합니다.");
		}
		System.out.println("가격 입력 : ");
		int price = sc.nextInt();
		bc.insertBook(new Book(title,author,scg,price));
		
		// 위의 순서대로 작성해보세용 ~ 찡긋^^
		
	}
		
		
	// 2. 도서 전체용 view 메소드
	public void selectMap() {
		/*
		 * 1. bc(BookController)의 selectMap() 메소드를 호출 후
		 *    --> 결과 값을 임의의 맵(HashMap<Integer, Book> bookMap)에 대입
		 * 
		 * 2. 조건식 이용해서 
		 * 2_1. bookMap가 "비어있는 경우"    -->   "존재하는 도서가 없습니다." 라는 알람 문구 출력
		 * 2_2. bookMap가 "비어있지 않은 경우" -->   keySet() 또는 entrySet()을 통해 bookMap 안의 Book 객체들 출력
		 * 
		 */
		
		HashMap<Integer, Book> hm = bc.selectMap();
		if(hm.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
		}
		else {
			Iterator<Integer> it = hm.keySet().iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
		
		// 위의 순서대로 작성해보세요 ~ 화이팅^^
	}
	
	
	// 3. 도서 검색용 view 메소드
	public void searchBook() {
		/*
		 * 1. 검색할 도서명 키워드로 입력받기 (String keyword) 
		 * 2. bc(BookController)의 searchBook() 메소드로 위의 keyword 값 전달 후  
		 *    --> 결과 값을 임의의 리스트(HashMap<Integer, Book> searchMap)에 대입
		 *    
		 *    ** 왜 결과 값이 한 도서의 Book 객체가 아니라 맵인가요??
		 *    	  사실.. 보통의 프로그램들이 검색을 할 때 풀 네임을 쳐서 검색하지 않는다. 보통 키워드로 검색한다
		 *       즉, 그 키워드를 포함한 결과가 하나가 아니라 여러개일 수 있기 때문에 리스트로 받아보자~!
		 * 
		 * 3. 조건식 이용해서
		 * 3_1. searchMap가 "비어있는 경우"    -->  "검색 결과가 없습니다." 라는 알람 문구 출력
		 * 3_2. searchMap가 "비어있지 않은 경우" -->  반복자을 통해 searchMap 안의 Book 객체들 출력
		 * 
		 */
		System.out.println("검색할 도서명 : " );
		String key = sc.nextLine();
		HashMap<Integer, Book> hm = bc.searchBook(key);
		if(hm.isEmpty()) {
			System.out.println("검색결과가 없습니다.");
		}
		else {
			Iterator<Entry<Integer,Book>> it = hm.entrySet().iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getValue());
			}
		}
		
		// 위의 순서대로 작성해보세요 ~ 얼마 안남았어요~!!
		
	}
	
	
	// 4. 도서 삭제용 view 메소드
	public void deleteBook() {
		/*
		 * 1. 삭제할 도서번호 입력받기 (int bNo)
		 *    
		 * 2. bc(BookConroller)의 deleteBook() 메소드로 위의 bNo 값 전달 후
		 * 	  --> 결과 값을 임의의 Book(Book remove)에 대입
		 * 
		 * 3. 조건식 이용해서
		 * 3_1. remove가 존재하는 경우        -->  "성공적으로 성공적으로 삭제되었습니다." 라는 알람 문구 출력
		 * 3_2. remove가 존재하지 않은 경우 -->  "삭제할 도서를 찾지 못했습니다." 라는 알람 문구 출력
		 *  
		 */

		// 위의 순서대로 작성해보세요 ~ 이제 거의 끝났어요~!!
		
	}
}
