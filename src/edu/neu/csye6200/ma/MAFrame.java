package edu.neu.csye6200.ma;

public class MAFrame {

	MACell[][] cellArray = null;
	private final static String white = "WHITE";
	private final static String green = "GREEN";
	private final static String gray = "GRAY";
	private final static String red = "RED";
	public static int[] pos = new int[2];
	int m = 0;
	int n = 0;
	
	public MAFrame(int i, int j) {
		cellArray =  new MACell[500][500];
		this.m = i;
		this.n = j;
		init(cellArray);
	}

	public void init(MACell[][] cellArray) {
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray.length; j++) {
				cellArray[i][j] = new MACell();
				if(m == i && n == j) {cellArray[i][j].setColor(red); pos[0] = i; pos[1] = j; continue;}
				cellArray[i][j].setColor(white);
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
