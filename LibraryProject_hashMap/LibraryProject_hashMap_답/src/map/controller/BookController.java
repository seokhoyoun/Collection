package map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import map.model.vo.Book;

public class BookController {
	
	// ��������  ��� �ִ� bookMap
	private HashMap<Integer, Book> bookMap = new HashMap<>();
	int count = 0;	// Ű������ ���� ����
	
	{
		// �ʱⰪ 4������ �߰�
		bookMap.put(1, new Book("�ڹ��� ����", "ȫ�浿", "��Ÿ", 20000));
		bookMap.put(2, new Book("C���", "�踻��", "��Ÿ", 15000));
		bookMap.put(3, new Book("������ ������ �Ǿ�����", "������", "�ι�", 17500));
		bookMap.put(4, new Book("�����Ҿ�� ������", "KH", "�Ƿ�", 10000));
		
		count = 5;
	}
	
	
	
	public void insertBook(Book bk) {
		/*
		 * 1. ���޹��� bk�� bookMap�� Ű��(count)�� �Բ� "�߰� "�ϱ�
		 * 2. count ���������ֱ�
		 */
		
		// 1�� ����
		bookMap.put(count, bk);
		// 2�� ����
		count++;
	}
	
	
	public HashMap<Integer, Book> selectMap(){
		/*
		 * 1. �ش� bookMap�� �ּ� �� ��ȯ
		 */
		
		return bookMap; 	
	}
	
	
	public HashMap<Integer, Book> searchBook(String keyword){
		/*
		 * 1. �˻� ����� ����� ������ ��(HashMap<Integer, Book> searchMap) ���� �� ����
		 *    
		 * 2. �ݺ����� ���� bookMap�� å�� �� å�� ���޹��� keyword�� "���� �Ǿ��ִ� ���" --> HINT : ���ǽ� �ۼ��� �� String Ŭ������ contains �޼ҵ� ����ϸ� �ǰ���?
		 *    searchMap�� �ش� å "�߰�"�ϱ� 
		 *    
		 *    ** keySet����� �غ��ð� entrySet����� �غ�����~!!
		 * 
		 * 3. searchMap�� �ּ� �� ��ȯ
		 */
		
		// 1�� ����
		HashMap<Integer, Book> searchMap = new HashMap<Integer, Book>();
		
		// 2�� ����_keySet����
		/* ---------------------------------------
		Set<Integer> keySet = bookMap.keySet();
		Iterator<Integer> itKey = keySet.iterator();
		
		while(itKey.hasNext()) {
			Integer key = itKey.next(); // Ű��
			Book bk = bookMap.get(key); // �����
			
			if(bk.getTitle().contains(keyword)){
				searchMap.put(key, bk);
			}
		}
		--------------------------------------- */
		
		// 2�� ����_entrySet����
		Set<Entry<Integer, Book>> entrySet = bookMap.entrySet();
		Iterator<Entry<Integer, Book>> itEntry = entrySet.iterator();
		
		while(itEntry.hasNext()) {
			Entry<Integer, Book> en = itEntry.next();
			
			Integer key = en.getKey();
			Book bk = en.getValue();
			
			if(bk.getTitle().contains(keyword)) {
				searchMap.put(key, bk);
			}
		}
		
		// 3�� ����
		return searchMap;  
	}
	
	public Book deleteBook(int bNo) {
		/*
		 * 1. ������ ������ ���� Book��ü(Book remove) ���� �� null�� �ʱ�ȭ
		 * 2. bookMap�� ���޹��� bNo(Ű ��)�� �̿��Ͽ� ����  (�̶� �ش� Ű ���� ������ remove�� ����)
		 * 
		 * 3. remove�� �ּ� �� ��ȯ 
		 */
		
		// 1�� ����
		Book remove = null;
		
		// 2�� ����
		remove = bookMap.remove(bNo);
		
		// 3�� ����
		return remove;  
	}
	
	
		

}
