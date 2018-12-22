package rewind;

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
import java.util.GregorianCalendar;
import java.util.Scanner;


public class BoardManager {
	ArrayList<Board> list = new ArrayList<Board>();
	Scanner sc = new Scanner(System.in);
	private int count = 0;
	
	public BoardManager() {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("board_list2.dat")))){
			while(true) {
				list.add((Board)ois.readObject());
				count++;
			}
		}catch (EOFException e) {
		}catch (FileNotFoundException e) {
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeBoard() {
		GregorianCalendar now = new GregorianCalendar();
		StringBuilder sb = new StringBuilder();
		System.out.println("게시글 작성을 시작합니다.");
		System.out.print("글 제목 : ");
		String title = sc.nextLine();
		System.out.print("작성자 : ");
		String name = sc.next();
		System.out.println("내용을 입력해주세요");
		String line = null;
		while(!(line = sc.nextLine()).equals("exit")) {
			sb.append(line).append("\n");
		}
		list.add(new Board(count++,title,name,now.getTime(),sb.toString(),0));
		System.out.println("작성이 완료되었습니다.");
	}

	public void displayAll() {
		if(list.isEmpty()) {
			System.out.println("현재 저장된 게시글이 없습니다.");
		}
		else {
			for(int i = 0; i < list.size(); i++) {
				System.out.println("======================================");
				System.out.println(list.get(i).toString());
				System.out.println("======================================");
			}
		}
		
	}
	
	public void displayBoard() {
		System.out.print("조회할 글번호 : ");
		int snum = sc.nextInt();
		for(Board e : list) {
			if(e.getBoardNo() == snum)
				System.out.println(e.toString());
		}
	}
	
	public void modifyTitle() {
		System.out.println("수정할 글번호 : ");
		int snum = sc.nextInt();
		if(snum < 0 || snum > list.size()) {
			System.out.println("해당 번호의 글은 존재하지 않습니다."); return;
		}
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
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getBoardTitle().contains(Title)) {
				System.out.println(list.get(i));
			}
		}
	}
	
	public void saveListFile() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("board_list2.dat")))){
			for(int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sortList(int item, boolean isDesc) {
		if(isDesc) {
			switch(item) {
			case 1 : list.sort(new DescBoardNo());
			case 2 : list.sort(new DescBoardDate());
			case 3 : list.sort(new DescBoardTitle());
			}
		}
		else {
			switch(item) {
			case 1 : list.sort(new AscBoardNo());
			case 2 : list.sort(new AscBoardDate());
			case 3 : list.sort(new AscBoardTitle());
			}
		}
	}
}
