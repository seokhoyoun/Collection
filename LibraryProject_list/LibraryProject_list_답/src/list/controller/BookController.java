package list.controller;

import java.util.ArrayList;

import list.model.vo.Book;

public class BookController {
	
	// ��������  ��� �ִ� bookList
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	{
		// �ʱⰪ 4������ �߰�
		bookList.add(new Book("�ڹ��� ����", "ȫ�浿", "��Ÿ", 20000));
		bookList.add(new Book("C���", "�踻��", "��Ÿ", 15000));
		bookList.add(new Book("������ ������ �Ǿ�����", "������", "�ι�", 17500));
		bookList.add(new Book("�����Ҿ�� ������", "KH", "�Ƿ�", 10000));
	}
	
	
	public void insertBook(Book bk) {
		/*
		 * 1. ���޹��� bk�� bookList�� "�߰� "
		 */
		
		bookList.add(bk);
	}
	
	
	public ArrayList<Book> selectList(){
		/*
		 * 1. �ش� bookList�� �ּ� �� ��ȯ
		 */
		
		return bookList; 	
	}
	
	
	public ArrayList<Book> searchBook(String keyword){
		/*
		 * 1. �˻� ��� ����Ʈ�� ����� ����Ʈ(ArrayList<Book> searchList) ���� �� ����
		 * 2. �ݺ����� ���� bookList�� å�� �� å�� ���޹��� keyword�� "���� �Ǿ��ִ� ���" --> HINT : ���ǽ� �ۼ��� �� String Ŭ������ contains �޼ҵ� ����ϸ� �ǰ���?
		 *    searchList�� �ش� å "�߰�"�ϱ� 
		 * 
		 * 3. searchList�� �ּ� �� ��ȯ
		 */
		
		// 1�� ����
		ArrayList<Book> searchList = new ArrayList<Book>();
		
		// 2�� ����
		for(int i=0; i<bookList.size(); i++) {
			
			Book bk = bookList.get(i);
			
			if(bk.getTitle().contains(keyword)) {
				searchList.add(bk);
			}
		}
		
		// 3�� ����
		return searchList;
	}
	
	public Book deleteBook(String title, String author) {
		/*
		 * 1. ������ ������ ���� Book��ü(Book remove) ���� �� null�� �ʱ�ȭ
		 * 2. �ݺ����� ���� bookList�� å�� �� å���� ���޹��� title�� �����ϰ�, ���ڸ��� ���޹��� author�� ������ ��� 
		 *    �ش� �ε����� ���� "����"�ϱ� (�̶� �ش� �ε��� ������ remove�� ����)
		 *    
		 * 3. remove�� �ּ� �� ��ȯ
		 */
		
		// 1�� ����
		Book remove = null;
		
		// 2�� ����_�ܼ� for�� ����ϱ�
		/* ---------------------------------------
		for(int i=0; i<bookList.size(); i++) {
			Book bk = bookList.get(i);
			
			if(bk.getTitle().equals(title) && bk.getAuthor().equals(author)) {
				bookList.remove(i);
				remove = bk;
			}
		}
		---------------------------------------- */
		
		// 2�� ����_for each�� ����ϱ� 
		for(Book bk : bookList) {
			
			if(bk.getTitle().equals(title) && bk.getAuthor().equals(author)) {
				bookList.remove(bk);
				remove = bk;
				break; // ���� �ܼ� for�� ��İ� ����ϰ� �����ϸ� ū ���� --> for each�� ����Ҷ��� �� break�� ���� ����������ߵȴ�. 
					   // ������ �� �����Ҷ��� ������ ���� ���� �� ������ ��� ���� �����Ϸ��� ���� ConcurrentModificationException ���ܰ� �߻��� �� �ִ�. 
					   // List�� ��ȸ�ϴ� for each���� ���� ������ �� ���� �� �� �ִ� �����̴�.
				
					   // ��, �����е��� for each���� �ܼ��� ��ü ��ȸ�� ���� ���� ������ ���̼���~! 
			}
			
		}
		
		// 3�� ����
		return remove; 
	}
	
	
	
	
}
