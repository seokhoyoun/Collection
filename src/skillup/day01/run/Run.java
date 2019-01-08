package skillup.day01.run;

import java.util.ArrayList;
import java.util.List;

import skillup.day01.model.vo.Music;

public class Run {

	public static void main(String[] args) {
		
//		List list = new ArrayList();
		ArrayList<Music> list = new ArrayList<>(3);
		System.out.println(list);
		
		// 1. add(E e ) : ����Ʈ�� ���� �ν��Ͻ� �߰�
		
		list.add(new Music("�۹�ȣ","�Ƴ���"));
		list.add(new Music("����","SOLO"));
		list.add(new Music("��","����̾ȷ��ҵ�"));
		
//		list.add("��"); // ������ ũ�⺸�� ũ�� ���� �־ ������ ���� ����
						
		System.out.println(list);
		
		// 2. add(int index, E e)
		list.add(1, new Music("������","������"));
		
		System.out.println(list);
		
		// 3.set(int index, E e)
		list.set(0, new Music("����","artist"));
		System.out.println(list);
		
		//4. size()
		System.out.println("size : "+ list.size());
		
		//5. remove(int index)
		list.remove(1);
		System.out.println(list);
		
		//6.get(int index)
		Music m = list.get(0);
//		String str = list.get(3).toString();
		
		System.out.println(m);
//		System.out.println(str);
		
		//7. contains(Object o)
		System.out.println(list.contains(new Music("����","artist")));
		
		//8. subList(int index1, int index2) list : �ش� �ε����� ������ ���� list�� ����
		List<Music> sub = list.subList(0, 2);
		System.out.println(sub);
		
		//9. addAll(Collection c) : �÷��� �߰�
		list.addAll(sub);
		System.out.println(list);
		
		//10. isEmpty() ����Ʈ �ȿ� ���� �����
		System.out.println(list.isEmpty());
		
		//11. clear() : ��ü ����
		list.clear();
		System.out.println(list.isEmpty());
		
		// �ݺ��� ���
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(Music e : list) {
			System.out.println(e);
		}
		
	}
}
