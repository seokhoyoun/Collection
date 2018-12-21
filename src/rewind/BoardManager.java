package rewind;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import board.model.vo.Board;

public class BoardManager {
	// Field
	ArrayList<Board> list = new ArrayList<Board>();
	Scanner sc = new Scanner(System.in);
	
	public BoardManager() {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("board_list.dat")))){
			while(true) {
				list.add((Board) ois.readObject());
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeBoard() {
		GregorianCalendar now = new GregorianCalendar();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		System.out.println("새 게시글을 작성합니다.");
		System.out.println("글 제목 : ");
		String title = sc.nextLine();
		System.out.println("작성자 : ");
		String name = sc.next();
		System.out.println("글 내용 : ");
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line).append("\n");
		}
		list.add(new Board(count++,title,name,now.getTime(),sb.toString(),0));
	}

	public void displayAll() {
		System.out.println(list);
	}
	
	public void displayBoard() {
		System.out.print("조회할 글번호 : ");
		int snum = sc.nextInt();
		System.out.println(list.get(snum));
		list.get(snum).setReadCount(list.get(snum).getReadCount()+1);
	}
	
	public void modifyTitle() {
		System.out.println("수정할 글번호 : ");
		int snum = sc.nextInt();
		System.out.println(list.get(snum));
		System.out.print("\n변경할 제목 : ");
		list.get(snum).setBoardTitle(sc.nextLine());
		System.out.println("수정되었습니다.");
	}

	public void modifyContent() {
		System.out.println("수정할 글번호 : ");
		int snum = sc.nextInt();
		System.out.println(list.get(snum));
		StringBuilder sb = new StringBuilder(list.get(snum).getBoardContent());
		System.out.print("\n변경할 내용 : ");
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line).append("\n");
		}
		list.get(snum).setBoardContent(sb.toString());
	}

	public void deleteBoard() {
		System.out.println("삭제할 글 번호 : ");
		int snum = sc.nextInt();
		System.out.println(list.get(snum));
		System.out.println("정말로 삭제하시겠습니까? (y/n) : ");
		if(sc.nextLine().toUpperCase().charAt(0) == 'Y') {
			list.remove(snum);
		}
		System.out.println(snum+"번 글이 삭제되었습니다.");
	}

	public void searchBoard() {
		System.out.print("검색 할 제목");
		String Title = sc.nextLine();
	}
}
