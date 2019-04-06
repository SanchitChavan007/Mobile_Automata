package edu.neu.csye6200.ma;

import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
//import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


/**
 * A sample canvas that draws a rainbow of lines
 * @author MMUNSON
 */
public class MACanvas extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	//private Logger log = Logger.getLogger(MACanvas.class.getName());
    private int stepSize = 7;
    private Color col = null;
    private long counter = 0L;
    private MAFrame maf;
    private Graphics2D g;
    private int m = 1;
    private int n = 10;
    private int c = 0;
    private MARuleA ruleA = null;
    private boolean firstTime = true;
	Dimension size = getSize();
	int maxRows = size.height / stepSize;
	int maxCols = size.width / stepSize;
    /**
     * MACanvas constructor
     */
	public MACanvas() {
		col = Color.gray;
		
		// Create 2d Array
	}
	
	// Map 2d Array to UI
	public void draw2dArray(MAFrame maf) {
		size = getSize();
		maxRows = size.height / stepSize;
		maxCols = size.width / stepSize;
		for(int i = 0; i <maxRows  ; i++) {
			for(int j = 0; j < maxCols; j++) {
					   paintRect(g, j*stepSize, i*stepSize, stepSize-1, stepSize-1, getCol(maf.cellArray[i][j].getColor().toString())); 
								
			}
			
		}
	}
	
	private Color getCol(String s) {
		if(s.equals("GRAY")){
			return Color.gray;
		}else if(s.equals("BLUE")){
			return Color.blue;
		}else if(s.equals("RED")){
			return Color.red;
		}else if(s.equals("GREEN")){
			return Color.green;
		}else if(s.equals("WHITE")){
			return Color.white;
		}
		return Color.BLACK;
	}
	
	
	//Create a 2d Array applying respective rule on it
	public void create2DArray(MAFrame maf) {
		
		int i = 0;
		ruleA = new  MARuleA();

		ruleA.applyRule(maf, MAFrame.pos[i]);
		i++;
		draw2dArray(maf);
		
		//for(int i = 0; i<10; i++) {
		//try {
			//Thread.sleep(1000);
	//	} catch (InterruptedException e) {
	//		e.printStackTrace();
	//	}
		//shift(maf);
		//}
	}
	
	public void start() {
		System.out.println("inside start");
		  this.create2DArray(maf);
	}
	
	private void shift(MAFrame maf) {
		MACell[][] a = maf.getCellArray();
		for(int i = 1; i<a.length; i++) {
			for(int j = 0; j<a[i].length; j++) {
				a[i-1][j] = a[i][j];
			}
		}
		System.out.println(m);
		//ruleA.generateCellFrame(maf, a.length-1, 0);
		drawMA(this.g);
		draw2dArray(maf);
	}
	

	/**
	 * The UI thread calls this method when the screen changes, or in response.
	 * to a user initiated call to repaint();
	 */
	
	public void changeStart(MAFrame maf) {
		
		for (int i = 0; i < maxRows; i++) {
			for (int j = 0; j < maxCols; j++) {

				MACell temp = maf.cellArray[i][j];
				maf.cellArray[i][j] = maf.cellArray[i+1][j];
				maf.cellArray[i+1][j] = temp;
				
			}
		}		
	
		
		
	}
	public void paint(Graphics g) {
		if(firstTime == true) {
		  this.g = (Graphics2D) g;
		  drawMA( (Graphics2D) g);// Our Added-on drawing
		  maf = new MAFrame(0, maxCols/2);
		  firstTime = false;
		}
		draw2dArray(maf);
    }
	

	/**
	 * Draw the MA graphics panel
	 * @param g
	 */
	public void drawMA(Graphics2D g2d) {
		//System.out.println("Drawing MA " + counter++);
		Dimension size = getSize();
		this.size = size;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);

		int maxRows = size.height / stepSize;
		int maxCols = size.width / stepSize;
		this.maxCols = maxCols;
		for (int j = 0; j < maxRows; j++) {
		   for (int i = 0; i < maxCols; i++) {
	
			   
			   int startx = i*stepSize;
			   int starty = j*stepSize;
			   
			   // Draw a box, one pixel less than the step size to create a black outline
			   paintRect(g2d, startx, starty, stepSize-1, stepSize-1, col); 
			 
		   }
		}
		g2d.setColor(Color.white);

	}
	
	/*
	 * A local routine to ensure that the color value is in the valid 0 to 255 range.
	 */
	private int validColor(int colorVal) {
		//if (colorVal > 255)
		//	colorVal = 255;
		//if (colorVal < 0)
		//	colorVal = 0;
		colorVal &= 0xFF; // It's faster to just crop the value to the lower 8 bits (i.e. 0x00 through 0xFF)
		return colorVal;
	}
	
	/*
	 * A convenience routine to set the color and draw a line
	 * @param g2d the 2D Graphics context
	 * @param startx the line start position on the x-Axis
	 * @param starty the line start position on the y-Axis
	 * @param endx the line end position on the x-Axis
	 * @param endy the line end position on the y-Axis
	 * @param color the line color
	 */
	private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy, Color color) {
		g2d.setColor(color);
		g2d.drawLine(startx, starty, endx, endy);
	}
	
	/*
	 * A convenience routine to set the color and draw a filled rectangle
	 * @param g2d
	 * @param x the upper top left box start position on the x-Axis
	 * @param y the upper top left box start position on the y-Axis
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @param color
	 */
	private void paintRect(Graphics2D g2d, int x, int y, int width, int height, Color color) {
		g2d.setColor(color);
		g2d.fillRect(x, y, width, height);
	}	

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("MACanvas received an update");
		
		// this.repaint(); // Request the UI to redraw the JPanel
	}
	
}
