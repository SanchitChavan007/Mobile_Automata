package edu.neu.csye6200.ma;

import java.util.HashSet;

public class MAFrame {

	MACell[][] cellArray = null;
	private final static String white = "WHITE";
	private final static String green = "GREEN";
	private final static String gray = "GRAY";
	private final static String red = "RED";
	public static int[] pos = new int[2];
	private HashSet<Integer> set = new HashSet<>();
	
	public MAFrame(HashSet<Integer> set) {
		cellArray =  new MACell[500][500];
		this.set = set;
		init(cellArray);
	}

	//Creating empty cell Array with all green cells
	public void init(MACell[][] cellArray) {
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray.length; j++) {
				cellArray[i][j] = new MACell();
				if(set.contains(j)&&i==0) {cellArray[i][j].setColor(red); pos[0] = i; pos[1] = j; continue;}
				cellArray[i][j].setColor(green);
			}
		}
	}
	
	public MACell[][] getCellArray() {
		return cellArray;
	}

	public void setCellArray(MACell[][] cellArray) {
		this.cellArray = cellArray;
	}
	

}
