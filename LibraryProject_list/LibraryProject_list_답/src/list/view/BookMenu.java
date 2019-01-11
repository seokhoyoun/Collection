package list.view;

import java.util.ArrayList;
import java.util.Scanner;

import list.controller.BookController;
import list.model.vo.Book;

public class BookMenu {
	
	private BookController bc = new BookController(); // BookController�� �޼ҵ���� ����ϱ� ���� ���۷���
	Scanner sc = new Scanner(System.in); // ����ڿ��� Ű����� ���� �Է� �ޱ� ���� Scanner ��ü
	
	public void mainMenu() {
		
		System.out.println("== Welcome KH Library ==");
		
		while(true) {
			System.out.println("===== ���� �޴� ====");
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. ���� ��ü ��ȸ");
			System.out.println("3. ���� �˻� ��ȸ");
			System.out.println("4. ���� �����ϱ�");
			
			System.out.println("0. ���α׷� �����ϱ�");
			
			System.out.print("�޴� ���� : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: insertBook(); break;
			case 2: selectList(); break;
			case 3: searchBook(); break;
			case 4: deleteBook(); break;
			case 0: System.out.println("���α׷��� �����մϴ�."); return;
			default: System.out.println("�߸��Է��Ͽ����ϴ�. �ٽ� �Է����ּ���"); break;
			}
		}
		
	}
	
	// 1. �� ���� �߰��� view �޼ҵ�
	public void insertBook() {
		/*
		 * 1. ������ �Է¹ޱ� (String title)
		 * 2. ���ڸ� �Է¹ޱ� (String author)
		 * 3. �帣��ȣ �Է¹ޱ� (int cNo) --> ���ڷ� �Է¹ޱ� (1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ)
		 * 4. ���� �Է¹ޱ� (int price)
		 * 5. �Ű����� �����ڸ� �̿��Ͽ� Book ��ü ���� (��, ��ü ���� �� �帣 ��ȣ���� ���ǽ� �̿��ؼ� �帣��ȣ�� �ƴ� �帣������ �� �Ѱܾߵǿ�!)
		 * 
		 * 6. bc(BookController)�� insertBook���� ���� Book ��ü ����
		 * 
		 */
		
		// 1�� ~ 4�� ����
		System.out.print("������ : ");
		String title = sc.nextLine();
		System.out.print("���ڸ� : ");
		String author = sc.nextLine();
		System.out.print("�帣��ȣ(1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ) : ");
		int cNo = sc.nextInt();
		System.out.print("���� : ");
		int price = sc.nextInt();
		
		// 5�� ����
		String category = "";
		
		if(cNo == 1)
			category = "�ι�";
		else if(cNo == 2)
			category = "�ڿ�����";
		else if(cNo ==3)
			category = "�Ƿ�";
		else
			category = "��Ÿ";
		
		Book bk = new Book(title, author, category, price);
		
		// 6�� ����
		bc.insertBook(bk);
		
	}
	
	
	// 2. ���� ��ü�� view �޼ҵ�
	public void selectList() {
		/*
		 * 1. bc(BookController)�� selectList() �޼ҵ带 ȣ�� ��
		 *    --> ��� ���� ������ ����Ʈ(ArrayList<Book> bookList)�� ����
		 * 
		 * 2. ���ǽ� �̿��ؼ� 
		 * 2_1. bookList�� "����ִ� ���"    -->   "�����ϴ� ������ �����ϴ�." ��� �˶� ���� ���
		 * 2_2. bookList�� "������� ���� ���" -->   �ݺ����� ���� bookList ���� Book ��ü�� ���
		 * 
		 */
		
		// 1�� ����
		ArrayList<Book> bookList = bc.selectList();
		
		// 2�� ����
		if(bookList.isEmpty()) {
			System.out.println("�����ϴ� ������ �����ϴ�.");
		}else {
			for(int i=0; i<bookList.size(); i++) {
				System.out.println(bookList.get(i));				
			}
		}
	}
	
	
	// 3. ���� �˻��� view �޼ҵ�
	public void searchBook() {
		/*
		 * 1. �˻��� ������ Ű����� �Է¹ޱ� (String keyword) 
		 * 2. bc(BookController)�� searchBook() �޼ҵ�� ���� keyword �� ���� ��  
		 *    --> ��� ���� ������ ����Ʈ(ArrayList<Book> searchList)�� ����
		 *    
		 *    ** �� ��� ���� �� ������ Book ��ü�� �ƴ϶� ����Ʈ �ΰ���??
		 *    	  ���.. ������ ���α׷����� �˻��� �� �� Ǯ ������ �ļ� �˻����� �ʴ´�. ���� Ű����� �˻��Ѵ�
		 *       ��, �� Ű���带 ������ ����� �ϳ��� �ƴ϶� �������� �� �ֱ� ������ ����Ʈ�� �޾ƺ���~!
		 * 
		 * 3. ���ǽ� �̿��ؼ�
		 * 3_1. searchList�� "����ִ� ���"    -->  "�˻� ����� �����ϴ�." ��� �˶� ���� ���
		 * 3_2. searchList�� "������� ���� ���" -->  �ݺ����� ���� searchList ���� Book ��ü�� ���
		 * 
		 */
		
		// 1�� ����
		System.out.print("�˻��� ������ Ű���� : ");
		String keyword = sc.nextLine();
		
		// 2�� ����
		ArrayList<Book> searchList = bc.searchBook(keyword);
		
		// 3�� ����
		if(searchList.isEmpty()) {
			System.out.println("�˻� ����� �����ϴ�.");
		}else {
			for(int i=0; i<searchList.size(); i++) {
				System.out.println(searchList.get(i));
			}
		}
	}
	
	
	// 4. ���� ������ view �޼ҵ�
	public void deleteBook() {
		/*
		 * 1. ������ ������ �Է¹ޱ� (String title)
		 * 2. ������ ���ڸ� �Է¹ޱ� (String author)
		 * 
		 * ** �� ������ �Է¹޴°� �ƴ϶�  ���ڸ� �Է¹޳���??
		 *    ���� �������̶�� �ص� ���ڸ��� �ٸ� ������ ���� �� ���ڳ���~~����
		 *    �׷��� ���� �� Ȯ���� �Ϸ��� ������ ���ڸ� �� �� �Էƹ��� �ſ���~!!
		 *    
		 * 3. bc(BookConroller)�� deleteBook() �޼ҵ�� ���� title, autor �� ���� ��
		 * 	  --> ��� ���� ������ Book(Book remove)�� ����
		 * 
		 * 4. ���ǽ� �̿��ؼ�
		 * 4_1. remove�� �����ϴ� ���        -->  "���������� �����Ǿ����ϴ�." ��� �˶� ���� ���
		 * 4_2. remove�� �������� ���� ��� -->  "������ ������ ã�� ���߽��ϴ�." ��� �˶� ���� ���
		 *  
		 */
		
		// 1�� ~ 2�� ����
		System.out.print("������ ������ : ");
		String title = sc.nextLine();
		System.out.print("������ ���ڸ� : ");
		String author = sc.nextLine();
		
		// 3�� ����
		Book remove = bc.deleteBook(title, author);
		
		// 4�� ����
		if(remove != null) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
		
	}
	

}
