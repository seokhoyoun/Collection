package board.model.vo;

import java.util.Comparator;

public class DescBoardTitle implements Comparator<Board>{

	@Override
	public int compare(Board o1, Board o2) {
		if(o1.getBoardTitle().compareTo(o2.getBoardTitle()) == 1)
			return -1;
		else if(o1.getBoardTitle().compareTo(o2.getBoardTitle()) == -1) 
			return 1;
		else
			return 0;
	}

}
