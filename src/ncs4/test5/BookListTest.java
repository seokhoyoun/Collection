package ncs4.test5;

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
import java.util.List;

public class BookListTest {

	public static void main(String[] args) {
		BookListTest blt = new BookListTest();
		ArrayList<Book> list = new ArrayList<>();
		
		blt.storeList(list); // Book 객체를 3개 생성하여 리스트에 넣는다.
		blt.saveFile(list); //books.dat 파일에 리스트에 저장된 Book 객체들을 저장한다.
		
		List<Book> booksList = blt.loadFile(); //books.dat 파일로부터 객체들을 읽어서 리스트에 담는다.
		
		blt.printList(booksList); //리스트에 저장된 객체 정보를 출력한다.
		
		
		// 할인된 가격은 booksList 에 기록된 객체 정보를 사용하여 getter 로 계산 출력한다.
		// – for each 문을 이용 할 것
	}

	public void printList(List<Book> booksList) {
		for(Book e : booksList) {
			System.out.println(e);
			System.out.println("할인된 가격 : "+(int)(e.getPrice()-(e.getPrice()*e.getDiscountRate()))+"원");
		}
	}

	public List<Book> loadFile() {
		List<Book> list = new ArrayList<>();
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.dat")))){
			while(true) {
				list.add((Book) ois.readObject());
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당파일이 없습니다.");
		} catch (EOFException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void saveFile(ArrayList<Book> list) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.dat")))){
			for(int i = 0; i < list.size(); i++) {
				oos.writeObject(list.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void storeList(ArrayList<Book> list) {
		list.add(new Book("자바의 정석","남궁성",30000,"도우출판",0.15));
		list.add(new Book("열혈강의 자바","구정은",29000,"프리렉",0.2));
		list.add(new Book("객체지향 JAVA 8","금영욱",30000,"북스홈",0.1));
	}

}
