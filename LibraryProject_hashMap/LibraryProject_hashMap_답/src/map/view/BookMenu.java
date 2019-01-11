package map.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import map.controller.BookController;
import map.model.vo.Book;

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
			case 2: selectMap(); break;
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
		 * 3. �帣 �Է¹ޱ� (int category) --> ���ڷ� �Է¹ޱ� (1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ)
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
	public void selectMap() {
		/*
		 * 1. bc(BookController)�� selectMap() �޼ҵ带 ȣ�� ��
		 *    --> ��� ���� ������ ��(HashMap<Integer, Book> bookMap)�� ����
		 * 
		 * 2. ���ǽ� �̿��ؼ� 
		 * 2_1. bookMap�� "����ִ� ���"    -->   "�����ϴ� ������ �����ϴ�." ��� �˶� ���� ���
		 * 2_2. bookMap�� "������� ���� ���" -->   keySet() �Ǵ� entrySet()�� ���� bookMap ���� Book ��ü�� ���
		 * 
		 */
		
		// 1�� ����
		HashMap<Integer, Book> bookMap = bc.selectMap();
		
		// 2�� ����
		if(bookMap.isEmpty()) {
			System.out.println("�����ϴ� ������ �����ϴ�.");
		}else {
			
			// keySet����
			
			Set<Integer> keySet = bookMap.keySet();
			Iterator<Integer> itKey = keySet.iterator();
			
			while(itKey.hasNext()) {
				Integer key = itKey.next();
				
				System.out.println(key + ", " + bookMap.get(key));
			}
			
			
			// 2�� ����_entrySet����
			/* ---------------------------------------
			Set<Entry<Integer, Book>> entrySet = bookMap.entrySet();
			Iterator<Entry<Integer, Book>> itEntry = entrySet.iterator();
			
			while(itEntry.hasNext()) {
				Entry<Integer, Book> en = itEntry.next();
				
				System.out.println(en.getKey() + ", " + en.getValue());
			}
			--------------------------------------- */
			
		}
	}
	
	
	// 3. ���� �˻��� view �޼ҵ�
	public void searchBook() {
		/*
		 * 1. �˻��� ������ Ű����� �Է¹ޱ� (String keyword) 
		 * 2. bc(BookController)�� searchBook() �޼ҵ�� ���� keyword �� ���� ��  
		 *    --> ��� ���� ������ ����Ʈ(HashMap<Integer, Book> searchMap)�� ����
		 *    
		 * 
		 * 3. ���ǽ� �̿��ؼ�
		 * 3_1. searchMap�� "����ִ� ���"    -->  "�˻� ����� �����ϴ�." ��� �˶� ���� ���
		 * 3_2. searchMap�� "������� ���� ���" -->  �ݺ����� ���� searchMap ���� Book ��ü�� ���
		 * 
		 */
		
		// 1�� ����
		System.out.print("�˻��� ������ Ű���� : ");
		String keyword = sc.nextLine();
		
		// 2�� ����
		HashMap<Integer, Book> searchMap = bc.searchBook(keyword);
		
		// 3�� ����
		if(searchMap.isEmpty()) {
			System.out.println("�˻� ����� �����ϴ�.");
		}else {
			
			// keySet����
			/* ---------------------------------------
			Set<Integer> keySet = searchMap.keySet();
			Iterator<Integer> itKey = keySet.iterator();
			
			while(itKey.hasNext()) {
				Integer key = itKey.next();
				
				System.out.println(key + ", " + searchMap.get(key));
			}
			--------------------------------------- */
			
			// 2�� ����_entrySet����
			Set<Entry<Integer, Book>> entrySet = searchMap.entrySet();
			Iterator<Entry<Integer, Book>> itEntry = entrySet.iterator();
			
			while(itEntry.hasNext()) {
				Entry<Integer, Book> en = itEntry.next();
				
				System.out.println(en.getKey() + ", " + en.getValue());
			}
		}
		
	}
	
	
	// 4. ���� ������ view �޼ҵ�
	public void deleteBook() {
		/*
		 * 1. ������ ������ȣ �Է¹ޱ� (int bNo)
		 *
		 * 2. bc(BookConroller)�� deleteBook() �޼ҵ�� ���� bNo �� ���� ��
		 * 	  --> ��� ���� ������ Book(Book remove)�� ����
		 * 
		 * 3. ���ǽ� �̿��ؼ�
		 * 3_1. remove�� �����ϴ� ���        -->  "���������� ���������� �����Ǿ����ϴ�." ��� �˶� ���� ���
		 * 3_2. remove�� �������� ���� ��� -->  "������ ������ ã�� ���߽��ϴ�." ��� �˶� ���� ���
		 *  
		 */
		
		// 1�� ����
		System.out.print("������ ������ȣ : ");
		int bNo = sc.nextInt();
		
		// 2�� ����
		Book remove = bc.deleteBook(bNo);
		
		// 3�� ����
		if(remove != null) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		}else {
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
				
	}
}
