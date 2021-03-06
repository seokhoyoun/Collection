package board.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581754646070382939L;
	// Field
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Date boardDate;
	private String boardContent;
	private int readCount;
	
	// Constructor
	public Board() {
		
	}
	
	public Board(int boardNo, String boardTitle, String boardWriter, Date boardDate, String boardContent,
			int readCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.readCount = readCount;
	}
	// Getter and Setter
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		// Date 미확인
		return "번호 : "+this.boardNo+" \n"+"글 제목 : "+this.boardTitle+"\n"+"작성자 : "
				+this.boardWriter+"\n"+this.boardDate+"\n조회수 : "+this.readCount+"\n"+this.boardContent;
	}
}
