package board.model.vo;

import java.util.Comparator;

public class DescBoardNo implements Comparator<Board>{

	@Override
	public int compare(Board b1, Board b2) {
		return b1.getBoardNo() < b2.getBoardNo() ? 1 : b1.getBoardNo() > b2.getBoardNo() ? -1 : 0;
	}

}
