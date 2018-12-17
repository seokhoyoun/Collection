import java.util.Scanner;

import practice.Book;
import practice.BookManager;

public class TestBookManager {
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		int mnum;
		do {
			System.out.print("	*** 도서 관리 프로그램 ***\r\n" + 
					"\r\n" + 
					"	1. 새 도서 추가	//addBook(inputBook() 이 리턴한 객체) 실행\r\n" + 
					"	2. 도서정보 정렬후 출력 //sortedBookList() 실행 \r\n" + 
					"			=> Book[] 리턴받아 printBookList(Book[]) 실행\r\n" + 
					"	3. 도서 삭제	//deleteBook(삭제할 인덱스) 실행\r\n" + 
					"	4. 도서 검색출력	//searchBook(검색할 도서명) 실행 \r\n" + 
					"			=> index 리턴받아 printBook(index) 실행\r\n" + 
					"	5. 전체 출력	//displayAll() 실행\r\n" + 
					"	6. 끝내기 \n"
					+ "메뉴 번호 입력 : ");
				mnum = sc.nextInt();
			switch(mnum) {
			case 1 : bm.addBook(book); break;
			case 2 : bm.sortedBookList(); break;
			case 3 : bm.deleteBook(index); break;
			case 4 : bm.searchBook(bTitle); break;
			case 5 : bm.displayAll(); break;
			case 6 : return;
			}
		}while(true);
	}
	
	public static Book inputBook() {
		//Book 객체의 필드값을 키보드로 입력받아 초기화하고 객체 리턴
		return null;
	}
	
	public static String inputBookTitle() {
		//삭제 또는 검색을 위한 도서 타이틀을 키보드로 입력받아 리턴
		return null;
	}
}
