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
	}
	
	
	public ArrayList<Book> selectList(){
		/*
		 * 1. �ش� bookList�� �ּ� �� ��ȯ
		 */
		
		return null; 	// �� �κ� �����ؾߵǿ�~! �켱�� null�� �س����
	}
	
	
	public ArrayList<Book> searchBook(String keyword){
		/*
		 * 1. �˻� ��� ����Ʈ�� ����� ����Ʈ(ArrayList<Book> searchList) ���� �� ����
		 * 2. �ݺ����� ���� bookList�� å�� �� å�� ���޹��� keyword�� "���� �Ǿ��ִ� ���" --> HINT : ���ǽ� �ۼ��� �� String Ŭ������ contains �޼ҵ� ����ϸ� �ǰ���?
		 *    searchList�� �ش� å "�߰�"�ϱ� 
		 * 
		 * 3. searchList�� �ּ� �� ��ȯ
		 */
		
		return null;   // �� �κ� �����ؾߵǿ�~! �켱�� null�� �س����
	}
	
	public Book deleteBook(String title, String author) {
		/*
		 * 1. ������ ������ ���� Book��ü(Book remove) ���� �� null�� �ʱ�ȭ
		 * 2. �ݺ����� ���� bookList�� å�� �� å���� ���޹��� title�� �����ϰ�, ���ڸ��� ���޹��� author�� ������ ��� 
		 *    �ش� �ε����� ���� "����"�ϰ� ���������� (�̶� �ش� �ε��� ������ remove�� ����)
		 * 
		 * 3. remove�� �ּ� �� ��ȯ 
		 */
		
		return null;   // �� �κ� �����ؾߵǿ�~! �켱�� null�� �س����
	}
	
	
	
	
}
