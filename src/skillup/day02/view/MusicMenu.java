package skillup.day02.view;

import java.util.ArrayList;
import java.util.Scanner;

import skillup.day02.controller.MusicController;
import skillup.day02.model.vo.Music;

public class MusicMenu {
	
	private MusicController mc = new MusicController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		System.out.println("==Welcome KH music bar==");
		while(true) {
			System.out.println("== 메인 메뉴 ==");
			System.out.println("1. 곡 추가");
			System.out.println("2. 곡 전체 조회");
			System.out.println("3. 곡 검색");
			System.out.println("4. 곡 삭제");
			System.out.println("5. 곡 수정");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :addMusic(); break; 
			case 2 :selectList(); break; 
			case 3 :search(); break; 
			case 4 :removeMusic(); break;
			case 5 :changeMusic();break;
			case 0 :System.out.println("프로그램을 종료합니다."); return;
			default:System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void changeMusic() {
		System.out.println("수정할 곡명 : ");
		String title = sc.nextLine();
		mc.search(title);
		if(title != null) {
			System.out.println("수정 할 가수명 : ");
			String artist = sc.nextLine();
			System.out.println("수정 할 곡명 : ");
			String title2 = sc.nextLine();
			mc.changeMusic(artist, title2);
			System.out.println("수정 완료");
		}
	}

	public void removeMusic() {
		System.out.println("삭제할 곡 명 : ");
		String title = sc.nextLine();
		Music remove = mc.removeMusic(title);
		if(remove == null) {
			System.out.println("삭제실패");
		}
		else {
			System.out.println("삭제성공");
		}
	}

	public void search() {
		System.out.println("== 곡 검색 ==");
		System.out.println("검색할 곡 명 :");
		String title = sc.nextLine();
		Music m = mc.search(title);
		if(m == null) 
			System.out.println("검색결과가 없습니다.");
		else
			System.out.println(m);
	}

	public void selectList() {
		System.out.println("--곡 전체 조회--");
		ArrayList<Music> list = mc.selectList();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void addMusic() {
		System.out.print("가수명 : ");
		String artist = sc.nextLine();
		System.out.print("제목명 : ");
		String title = sc.nextLine();
		Music m = new Music(artist,title);
		
		mc.addMusic(m);
		
	}

}
