package board.model.vo;

import java.text.SimpleDateFormat;
import java.util.Comparator;

public class AscBoardDate implements Comparator<Board>{

	@Override
	public int compare(Board o1, Board o2) {
		long l1 = o1.getBoardDate().getTime();
		long l2 = o2.getBoardDate().getTime();
		
		return l1 > l2 ? 1 : l1 < l2 ? -1 : 0; 
	}

	

	
}
