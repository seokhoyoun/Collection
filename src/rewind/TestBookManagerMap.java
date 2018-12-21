package rewind;

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
				"	1. 새 도서 추가	\r\n" + 
				"	2. 도서 정보 정렬 후 출력 \r\n" + 
				"	3. 도서 삭제	\r\n" + 
				"	4. 도서 검색 \r\n" + 
				"	5. 전체 출력\r\n" + 
				"	6. 끝내기\n"
				+ "	번호 입력 : ");
			mnum = sc.nextInt();
		switch(mnum) {	
		case 1 : bm.putBook(inputBook()); break;
		case 2 : bm.printBookMap(bm.sortedBookMap()); break;
		case 3 : bm.removeBook(bm.searchBook(inputBookTitle())); break;
		case 4 : bm.printBook(bm.searchBook(inputBookTitle())); break;
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
	
	private static String inputBookTitle() {
		// 삭제 또는 검색을 위한 도서 타이틀을 키보드로 입력받아 리턴
		System.out.print("도서 제목 : ");
		return new Scanner(System.in).nextLine();
	}

}
