package list.view;

import java.util.ArrayList;
import java.util.Scanner;

import list.controller.BookController;
import list.model.vo.Book;

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
			case 2: selectList(); break;
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
		 * 3. 장르번호 입력받기 (int cNo) --> 숫자로 입력받기 (1.인문 / 2.자연과학 / 3.의료 / 4.기타)
		 * 4. 가격 입력받기 (int price)
		 * 5. 매개변수 생성자를 이용하여 Book 객체 생성 (단, 객체 생성 시 장르 번호별로 조건식 이용해서 장르번호가 아닌 장르명으로 값 넘겨야되요!)
		 * 
		 * 6. bc(BookController)의 insertBook으로 위의 Book 객체 전달
		 * 
		 */
		
		// 1번 ~ 4번 과정
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		System.out.print("저자명 : ");
		String author = sc.nextLine();
		System.out.print("장르번호(1.인문 / 2.자연과학 / 3.의료 / 4.기타) : ");
		int cNo = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		
		// 5번 과정
		String category = "";
		
		if(cNo == 1)
			category = "인문";
		else if(cNo == 2)
			category = "자연과학";
		else if(cNo ==3)
			category = "의료";
		else
			category = "기타";
		
		Book bk = new Book(title, author, category, price);
		
		// 6번 과정
		bc.insertBook(bk);
		
	}
	
	
	// 2. 도서 전체용 view 메소드
	public void selectList() {
		/*
		 * 1. bc(BookController)의 selectList() 메소드를 호출 후
		 *    --> 결과 값을 임의의 리스트(ArrayList<Book> bookList)에 대입
		 * 
		 * 2. 조건식 이용해서 
		 * 2_1. bookList가 "비어있는 경우"    -->   "존재하는 도서가 없습니다." 라는 알람 문구 출력
		 * 2_2. bookList가 "비어있지 않은 경우" -->   반복문을 통해 bookList 안의 Book 객체들 출력
		 * 
		 */
		
		// 1번 과정
		ArrayList<Book> bookList = bc.selectList();
		
		// 2번 과정
		if(bookList.isEmpty()) {
			System.out.println("존재하는 도서가 없습니다.");
		}else {
			for(int i=0; i<bookList.size(); i++) {
				System.out.println(bookList.get(i));				
			}
		}
	}
	
	
	// 3. 도서 검색용 view 메소드
	public void searchBook() {
		/*
		 * 1. 검색할 도서명 키워드로 입력받기 (String keyword) 
		 * 2. bc(BookController)의 searchBook() 메소드로 위의 keyword 값 전달 후  
		 *    --> 결과 값을 임의의 리스트(ArrayList<Book> searchList)에 대입
		 *    
		 *    ** 왜 결과 값이 한 도서의 Book 객체가 아니라 리스트 인가요??
		 *    	  사실.. 보통의 프로그램들이 검색을 할 때 풀 네임을 쳐서 검색하지 않는다. 보통 키워드로 검색한다
		 *       즉, 그 키워드를 포함한 결과가 하나가 아니라 여러개일 수 있기 때문에 리스트로 받아보자~!
		 * 
		 * 3. 조건식 이용해서
		 * 3_1. searchList가 "비어있는 경우"    -->  "검색 결과가 없습니다." 라는 알람 문구 출력
		 * 3_2. searchList가 "비어있지 않은 경우" -->  반복문을 통해 searchList 안의 Book 객체들 출력
		 * 
		 */
		
		// 1번 과정
		System.out.print("검색할 도서명 키워드 : ");
		String keyword = sc.nextLine();
		
		// 2번 과정
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		// 3번 과정
		if(searchList.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
	}
	
	
	// 4. 도서 삭제용 view 메소드
	public void deleteBook() {
		/*
		 * 1. 삭제할 도서명 입력받기 (String title)
		 * 2. 삭제할 저자명 입력받기 (String author)
		 * 
		 * ** 왜 도서명만 입력받는게 아니라  저자명도 입력받나요??
		 *    같은 도서명이라고 해도 저자명이 다른 도서가 있을 수 있자나요~~ㅎㅎ
		 *    그래서 조금 더 확실히 하려고 도서명 저자명 둘 다 입렵받은 거에요~!!
		 *    
		 * 3. bc(BookConroller)의 deleteBook() 메소드로 위의 title, autor 값 전달 후
		 * 	  --> 결과 값을 임의의 Book(Book remove)에 대입
		 * 
		 * 4. 조건식 이용해서
		 * 4_1. remove가 존재하는 경우        -->  "성공적으로 삭제되었습니다." 라는 알람 문구 출력
		 * 4_2. remove가 존재하지 않은 경우 -->  "삭제할 도서를 찾지 못했습니다." 라는 알람 문구 출력
		 *  
		 */
		
		// 1번 ~ 2번 과정
		System.out.print("삭제할 도서명 : ");
		String title = sc.nextLine();
		System.out.print("삭제할 저자명 : ");
		String author = sc.nextLine();
		
		// 3번 과정
		Book remove = bc.deleteBook(title, author);
		
		// 4번 과정
		if(remove != null) {
			System.out.println("성공적으로 삭제되었습니다.");
		}else {
			System.out.println("삭제할 도서를 찾지 못했습니다.");
		}
		
	}
	

}
