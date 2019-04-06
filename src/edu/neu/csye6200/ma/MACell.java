package edu.neu.csye6200.ma;

public class MACell {

	private Color color;
	
	enum Color 
    { 
        RED, GREEN, GRAY, WHITE, BLUE; 
    } 

	public MACell() {

	}

	public MACell(String color) {
		this.color = Color.valueOf(color);
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = Color.valueOf(color);
	}
	
	public String toString(Color color) {
		switch(color.ordinal()) {
		case 0:
			return "RED";
		case 1:
			return "GREEN";
		case 2:
			return "GRAY";
		case 3:
			return "WHITE";
		case 4:
			return "BLUE";
		}
		return "";
	}

}
