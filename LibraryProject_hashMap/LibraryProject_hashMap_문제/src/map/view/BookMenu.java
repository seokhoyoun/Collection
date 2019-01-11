package map.view;

import java.util.ArrayList;
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
		
		// ���� ������� �ۼ��غ����� ~ ����^^
		
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
		
		// ���� ������� �ۼ��غ����� ~ ȭ����^^
	}
	
	
	// 3. ���� �˻��� view �޼ҵ�
	public void searchBook() {
		/*
		 * 1. �˻��� ������ Ű����� �Է¹ޱ� (String keyword) 
		 * 2. bc(BookController)�� searchBook() �޼ҵ�� ���� keyword �� ���� ��  
		 *    --> ��� ���� ������ ����Ʈ(HashMap<Integer, Book> searchMap)�� ����
		 *    
		 *    ** �� ��� ���� �� ������ Book ��ü�� �ƴ϶� ���ΰ���??
		 *    	  ���.. ������ ���α׷����� �˻��� �� �� Ǯ ������ �ļ� �˻����� �ʴ´�. ���� Ű����� �˻��Ѵ�
		 *       ��, �� Ű���带 ������ ����� �ϳ��� �ƴ϶� �������� �� �ֱ� ������ ����Ʈ�� �޾ƺ���~!
		 * 
		 * 3. ���ǽ� �̿��ؼ�
		 * 3_1. searchMap�� "����ִ� ���"    -->  "�˻� ����� �����ϴ�." ��� �˶� ���� ���
		 * 3_2. searchMap�� "������� ���� ���" -->  �ݺ����� ���� searchMap ���� Book ��ü�� ���
		 * 
		 */

		// ���� ������� �ۼ��غ����� ~ �� �ȳ��Ҿ��~!!
		
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

		// ���� ������� �ۼ��غ����� ~ ���� ���� �������~!!
		
	}
}
