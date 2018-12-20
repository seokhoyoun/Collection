package practice3;

import java.util.InputMismatchException;
import java.util.Scanner;

import practice.Book;

public class TestBookManagerMap {

	public static void main(String[] args) {
		BookManagerMap bm = new BookManagerMap();
		Scanner sc = new Scanner(System.in);
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
				"	6. 끝내기\n"
				+ "	번호 입력 : ");
			mnum = sc.nextInt();
		switch(mnum) {	
		case 1 : bm.putBook(inputBook()); break;
		case 2 : bm.sortedBookMap(); break;
		case 3 : //bm.removeBook(key); break;
		case 4 : //bm.searchBook(); break;
		case 5 : bm.displayAll(); break;
		case 6 : return;
		}
		}while(true);
		
	}
	
	public static Book inputBook() {
		Scanner sc = new Scanner(System.in);
		Book b = new Book();
		System.out.print("도서번호 : ");
		b.setbNo(sc.next());
		while(true) {
			try {		
				System.out.print("도서분류코드(1.인문/2.자연과학/3.의료/4.기타) : ");
				int cnum = sc.nextInt();	
				if (cnum > 0 && cnum < 5) {
					b.setCategory(cnum);
					break;
				}	
			} catch (InputMismatchException e) {
				System.out.println("정수만 입력 가능합니다.");
				sc = new Scanner(System.in);
			}
		}
		System.out.print("책제목 : ");
		sc.nextLine();
		b.setTitle(sc.nextLine());
		System.out.print("저자 : ");
		b.setAuthor(sc.nextLine());
		System.out.println("새로운 도서 저장이 완료되었습니다.");
		return b;
		
	}

}
