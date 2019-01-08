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
			System.out.println("== ���� �޴� ==");
			System.out.println("1. �� �߰�");
			System.out.println("2. �� ��ü ��ȸ");
			System.out.println("3. �� �˻�");
			System.out.println("4. �� ����");
			System.out.println("5. �� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("�޴� ���� : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :addMusic(); break; 
			case 2 :selectList(); break; 
			case 3 :search(); break; 
			case 4 :removeMusic(); break;
			case 5 :changeMusic();break;
			case 0 :System.out.println("���α׷��� �����մϴ�."); return;
			default:System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}

	public void changeMusic() {
		System.out.println("������ ��� : ");
		String title = sc.nextLine();
		mc.search(title);
		if(title != null) {
			System.out.println("���� �� ������ : ");
			String artist = sc.nextLine();
			System.out.println("���� �� ��� : ");
			String title2 = sc.nextLine();
			mc.changeMusic(artist, title2);
			System.out.println("���� �Ϸ�");
		}
	}

	public void removeMusic() {
		System.out.println("������ �� �� : ");
		String title = sc.nextLine();
		Music remove = mc.removeMusic(title);
		if(remove == null) {
			System.out.println("��������");
		}
		else {
			System.out.println("��������");
		}
	}

	public void search() {
		System.out.println("== �� �˻� ==");
		System.out.println("�˻��� �� �� :");
		String title = sc.nextLine();
		Music m = mc.search(title);
		if(m == null) 
			System.out.println("�˻������ �����ϴ�.");
		else
			System.out.println(m);
	}

	public void selectList() {
		System.out.println("--�� ��ü ��ȸ--");
		ArrayList<Music> list = mc.selectList();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void addMusic() {
		System.out.print("������ : ");
		String artist = sc.nextLine();
		System.out.print("����� : ");
		String title = sc.nextLine();
		Music m = new Music(artist,title);
		
		mc.addMusic(m);
		
	}

}
