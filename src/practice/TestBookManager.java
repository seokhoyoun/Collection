package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import practice.Book;
import practice.BookManager;

public class TestBookManager {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
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
			case 1 : Book book = inputBook(); bm.addBook(book); break;
			case 2 : bm.sortedBookList(); break;
			case 3 : String bName = inputBookTitle(); int index = bm.searchBook(bName); bm.deleteBook(index); break;
			case 4 : bName = inputBookTitle(); bm.searchBook(bName); break;
			case 5 : bm.displayAll(); break;
			case 6 : return;
			}
		}while(true);
	}
	
	public static Book inputBook() {
		//Book 객체의 필드값을 키보드로 입력받아 초기화하고 객체 리턴
		Book b = new Book();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
		System.out.print("도서번호 : ");
		b.setbNo(br.readLine());
		System.out.print("도서분류코드(1.인문/2.자연과학/3.의료/4.기타) : ");
		b.setCategory(Integer.parseInt(br.readLine()));
		System.out.print("책제목 : ");
		b.setTitle(br.readLine());
		System.out.print("저자 : ");
		b.setAuthor(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static String inputBookTitle() {
		//삭제 또는 검색을 위한 도서 타이틀을 키보드로 입력받아 리턴
		System.out.print("삭제할 도서명 : ");
		return sc.nextLine();
	}
}
