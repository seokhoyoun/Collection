package board.controller;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import board.model.vo.Board;

public class BoardManager {
	// Field
	ArrayList<Board> list = new ArrayList<Board>();
	Scanner sc = new Scanner(System.in);
	static int bCount = 0;
	
	// Constructor
	public BoardManager() {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream (new FileInputStream("board_list.dat")))){
			while(true) {
				list.add((Board) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println("저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println("생성된 파일이 없습니다.\n새 글을 작성해 주세요\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeBoard() {
		System.out.println("새 게시글 쓰기입니다.");
		System.out.print("글 제목 : ");
		String bName = sc.nextLine();
		System.out.print("작성자 : ");
		String author = sc.next();
		Calendar now = Calendar.getInstance();
		System.out.print("글 내용 : ");
		StringBuilder sb = new StringBuilder();
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line).append("\n");
		}
		Board b = new Board(bCount,bName,author,now.getTime(),sb.toString(),0);
		bCount++;
		list.add(b);
		System.out.println("게시글 작성이 완료되었습니다.\n");
	}
	public void displayAllList() {
		System.out.println(list.toString());
	}
	
	public void displayBoard() {
		System.out.print("조회할 글 번호 : ");
		int index = sc.nextInt();
		if(index > -1 && index < list.size()) {
			System.out.println(list.get(index));
			int views = (list.get(index).getReadCount())+1;
			list.get(index).setReadCount(views);
		}
		else 
			System.out.println("해당 글 번호는 존재하지 않습니다.");
		
		
	}
	
	public void modifyTitle() {
		System.out.print("수정 할 글 번호 : ");
		int index = sc.nextInt();
		if(index > -1 && index < list.size()) {
			System.out.println(list.get(index));
			System.out.print("\n변경할 제목 : ");
			sc.nextLine(); // 버퍼 제거용
			list.get(index).setBoardTitle(sc.nextLine());
			System.out.println("변경이 완료되었습니다.");
		}
		else 
			System.out.println("해당 글 번호는 존재하지 않습니다.");
		
	}
	
	public void modifyContent() {
		
	}
	public void deleteBoard() {
		
	}
	
	public void searchBoard() {
		
	}
	
	public void saveListFile() {
		
	}
	
	public void sortList(int item, boolean isDesc) {
		
	}
	
}
