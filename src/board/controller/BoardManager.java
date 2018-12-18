package board.controller;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import board.model.vo.Board;

public class BoardManager {
	// Field
	ArrayList<Board> list = new ArrayList<Board>();
	Scanner sc = new Scanner(System.in);
	
	// Constructor
	public BoardManager() {
		try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream (new FileInputStream("board_list.dat")))){
			while(true) {
				list.add((Board) ois.readObject());
			}
		} catch (EOFException e) {
			System.out.println("저장 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeBoard() {
		
	}
	public void displayAllList() {
		
	}
	
	public void displayBoard() {
		
	}
	
	public void modifyTitle() {
		
	}
	
	public void modifyContent() {
		
	}
	
	public void deleteBoard() {
		
	}
	
	public void searchBoard() {
		
	}
	
	public void saveListFile() {
		
	}
	
	public void sortList(int item, boolean isDesc) {
		
	}
	
}
