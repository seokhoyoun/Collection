package skillup.day01.run;

import java.util.ArrayList;
import java.util.List;

import skillup.day01.model.vo.Music;

public class Run {

	public static void main(String[] args) {
		
//		List list = new ArrayList();
		ArrayList<Music> list = new ArrayList<>(3);
		System.out.println(list);
		
		// 1. add(E e ) : 리스트의 끝에 인스턴스 추가
		
		list.add(new Music("송민호","아낙네"));
		list.add(new Music("제니","SOLO"));
		list.add(new Music("퀸","보헤미안랩소디"));
		
//		list.add("끝"); // 지정한 크기보다 크게 값을 넣어도 오류가 나지 않음
						
		System.out.println(list);
		
		// 2. add(int index, E e)
		list.add(1, new Music("강보람","기술향상"));
		
		System.out.println(list);
		
		// 3.set(int index, E e)
		list.set(0, new Music("지코","artist"));
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
		System.out.println(list.contains(new Music("지코","artist")));
		
		//8. subList(int index1, int index2) list : 해당 인덱스들 사이의 값을 list로 추출
		List<Music> sub = list.subList(0, 2);
		System.out.println(sub);
		
		//9. addAll(Collection c) : 컬렉션 추가
		list.addAll(sub);
		System.out.println(list);
		
		//10. isEmpty() 리스트 안에 값이 비었나
		System.out.println(list.isEmpty());
		
		//11. clear() : 전체 삭제
		list.clear();
		System.out.println(list.isEmpty());
		
		// 반복문 사용
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(Music e : list) {
			System.out.println(e);
		}
		
	}
}
