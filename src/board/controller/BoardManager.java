package board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import board.model.vo.*;

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
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
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
		System.out.print("수정 할 글 번호 : ");
		int index = sc.nextInt();
		if(index > -1 && index < list.size()) {
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(index)); // 기존 내용 저장
			System.out.println(list.get(index));
			System.out.print("\n변경할 내용 (종료 exit): ");
			sc.nextLine(); // 버퍼 제거용
			String line = null;
			while(!(line = sc.nextLine()).equals("exit")) {
				sb.append(line).append("\n"); // 기존 내용에 추가
			}
			list.get(index).setBoardContent(sb.toString());
			System.out.println("변경이 완료되었습니다.");
		}
		else 
			System.out.println("해당 글 번호는 존재하지 않습니다.");
	}
	public void deleteBoard() {
		System.out.print("삭제할 글 번호 : ");
		int index = sc.nextInt();
		if(index > -1 && index < list.size()) {
			System.out.println(list.get(index));
			System.out.print("\n정말로 삭제하시겠습니까? (y/n) : ");
			sc.nextLine(); // 버퍼 제거용
			if(sc.nextLine().toUpperCase().charAt(0) == 'Y') {
				list.remove(index);
				System.out.println(index+"번 글의 삭제가 완료되었습니다.");
			}
		}
		else 
			System.out.println("해당 글 번호는 존재하지 않습니다.");
	}
	
	public void searchBoard() {
		System.out.print("검색할 제목 : ");
		String key = sc.nextLine();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getBoardTitle().contains(key)) {
				System.out.println(list.get(i));
			}
		}
	}
	
	public void saveListFile() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("board_list.dat",true)))){
			for(int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
			System.out.println("저장이 완료 되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("새 파일을 저장합니다.");
		} catch (IOException e) {
			System.out.println("시스템 오류 발생. 다시 시작해주세요");
		}
	}
	
	public void sortList(int item, boolean isDesc) {
		if(isDesc) {
			switch(item) {
			case 1 : list.sort(new DescBoardNo()); break;
			case 2 : list.sort(new DescBoardDate());  break;
			case 3 : list.sort(new DescBoardTitle());  break;
			}
		}
		else {
			switch(item) {
			case 1 : list.sort(new AscBoardNo());  break;
			case 2 : list.sort(new AscBoardDate()); break;
			case 3 : list.sort(new AscBoardTitle());break;
			}
		}
		 System.out.println("정렬 완료!");
		 
	}
	
}
