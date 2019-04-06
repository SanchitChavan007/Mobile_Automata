package edu.neu.csye6200.ma;

import edu.neu.csye6200.ma.MACell.Color;

public class MARuleB implements MARule {
	int location = -1;
	private final static String white = "WHITE";
	private final static String green = "GREEN";
	private final static String gray = "GRAY";
	private final static String red = "RED";
	private final static String blue = "BLUE";
	MACell[][] a = null;


	@Override
	public MAFrame applyRule(MAFrame ma, int i) {
		a = ma.getCellArray();
		if(i>a.length) return null;
		for(int j = 0; j<a[i].length; j++) {
			if(a[i-1][j].getColor() == Color.GRAY) {
				a[i][j].setColor(gray);
			}
		}
		for(int j = 1; j<a[i].length; j++) {
			if(a[i-1][j].getColor() == MACell.Color.BLUE) {
					if(a[i-1][j-1].getColor()  == MACell.Color.GRAY && a[i-1][j+1].getColor()  == MACell.Color.GRAY) {
						applyConditionA(i, j);
					}else if(a[i-1][j-1].getColor()  == MACell.Color.GRAY && a[i-1][j+1].getColor()  == MACell.Color.WHITE) {
						applyConditionA(i,j);
					}else if(a[i-1][j+1].getColor()  == MACell.Color.GRAY && a[i-1][j-1].getColor()  == MACell.Color.WHITE) {
						applyConditionA(i, j);

					}else if(a[i-1][j+1].getColor()  == MACell.Color.WHITE && a[i-1][j-1].getColor()  == MACell.Color.WHITE) {
						a[i][j].setColor(gray);
						if(a[i][j-1].getColor() == MACell.Color.GRAY) {
							a[i][j-1].setColor(blue);
						}else {
							a[i][j-1].setColor(red);
						}
					}
					
			}else if(a[i-1][j].getColor() == MACell.Color.RED) {
				if(a[i-1][j-1].getColor()  == MACell.Color.GRAY && a[i-1][j+1].getColor()  == MACell.Color.GRAY) {
					a[i][j].setColor(white);
					if(a[i][j-1].getColor() == MACell.Color.GRAY) {
						a[i][j-1].setColor(blue);
					}else {
						a[i][j-1].setColor(red);
					}
					
				}else if(a[i-1][j-1].getColor()  == MACell.Color.GRAY && a[i-1][j+1].getColor()  == MACell.Color.WHITE) {
					a[i][j].setColor(white);
					if(a[i][j+1].getColor() == MACell.Color.GRAY) {
						a[i][j+1].setColor(blue);
					}else {
						a[i][j+1].setColor(red);
					}
					
					
				}else if(a[i-1][j+1].getColor()  == MACell.Color.GRAY && a[i-1][j-1].getColor()  == MACell.Color.WHITE) {
					a[i][j].setColor(gray);
					if(a[i][j+1].getColor() == MACell.Color.GRAY) {
						a[i][j+1].setColor(blue);
					}else {
						a[i][j+1].setColor(red);
					}
					
					
				}else if(a[i-1][j+1].getColor()  == MACell.Color.WHITE && a[i-1][j-1].getColor()  == MACell.Color.WHITE) {
					a[i][j].setColor(gray);
					if(a[i][j-1].getColor() == MACell.Color.GRAY) {
						a[i][j-1].setColor(blue);
					}else {
						a[i][j-1].setColor(red);
					}
				}
			}
		}
		return null;
	}
	
	private void applyConditionB(int i, int j) {
		a[i][j].setColor(gray);
		if(a[i][j-1].getColor() == MACell.Color.GRAY) {
			a[i][j-1].setColor(blue);
		}else {
			a[i][j-1].setColor(red);
		}
	}
	
	private void applyConditionA(int i, int j) {
		a[i][j].setColor(white);
		if(a[i][j+1].getColor() == MACell.Color.GRAY) {
			a[i][j+1].setColor(blue);
		}else {
			a[i][j+1].setColor(red);
		}
	}


}
