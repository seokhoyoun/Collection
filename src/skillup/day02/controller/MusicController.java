package skillup.day02.controller;

import java.util.ArrayList;

import skillup.day02.model.vo.Music;

public class MusicController {
	
	private ArrayList<Music> list = new ArrayList<>();

	public void addMusic(Music m) {
		list.add(m);
	}

	public ArrayList<Music> selectList() {
		/*for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		return list;
	}

	public Music search(String title) {
		Music search = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title))
				search = list.get(i);
		}
		return search;
	}

	public Music removeMusic(String title) {
		Music remove = null;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title))
				remove = list.remove(i);
		}
		
		return remove;
	}

	public void changeMusic(String artist, String title) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle().equals(title)) {
				list.get(i).setTitle(title);
			}
		}
	}
	
}
