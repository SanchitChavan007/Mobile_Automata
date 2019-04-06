//package edu.neu.csye6200.ma;
//
//public class MARuleB implements MARule {
//	int location = -1;
//
//	public MARuleB() {
//	}
//
//	@Override
//	public MAFrame generateCellFrame(MAFrame ma) {
//		MACell[][] cellArr = ma.cellArray;
//
//		cellArr[0][10].setState(true);
//		cellArr[0][10].setColor(false);
//		for (int i = 1; i < ma.cellArray.length - 1; i++) {
//
//			for (int k = 0; k < ma.cellArray.length - 1; k++) {
//				ma.cellArray[i][k].setColor(ma.cellArray[i - 1][k].getColor()); // copy the colors of previous row
//				if (ma.cellArray[i - 1][k].isState() == true) {
//					location = k; // location of active cell at previous row
//				}
//			}
//			/* rules implementation start */
//			if (ma.cellArray[i - 1][location].getColor() == false) {
//
//				if (ma.cellArray[i - 1][location - 1].getColor() == false
//						&& ma.cellArray[i - 1][location + 1].getColor() == true) {
//
//					ma.cellArray[i][location].setColor(true);
//					ma.cellArray[i][location + 1].setState(true);
//				}
//
//				else if (ma.cellArray[i - 1][location - 1].getColor() == false
//						&& ma.cellArray[i - 1][location + 1].getColor() == false) {
//
//					ma.cellArray[i][location].setColor(true);
//					ma.cellArray[i][location - 1].setState(true);
//
//				} else if (ma.cellArray[i - 1][location - 1].getColor() == true
//						&& ma.cellArray[i - 1][location + 1].getColor() == false) {
//
//					ma.cellArray[i][location].setColor(false);
//					ma.cellArray[i][location + 1].setState(true);
//
//				} else if (ma.cellArray[i - 1][location - 1].getColor() == true
//						&& ma.cellArray[i - 1][location + 1].getColor() == true) {
//
//					ma.cellArray[i][location].setColor(false);
//					ma.cellArray[i][location - 1].setState(true);
//				}
//
//			}
//
//			else if (ma.cellArray[i - 1][location].getColor() == true) {
//
//				if (ma.cellArray[i - 1][location - 1].getColor() == false
//						&& ma.cellArray[i - 1][location + 1].getColor() == true) {
//
//					ma.cellArray[i][location].setColor(false);
//					ma.cellArray[i][location + 1].setState(true);
//				}
//
//				else if (ma.cellArray[i - 1][location - 1].getColor() == true
//						&& ma.cellArray[i - 1][location + 1].getColor() == true) {
//
//					ma.cellArray[i][location].setColor(false);
//					ma.cellArray[i][location + 1].setState(true);
//				} else if (ma.cellArray[i - 1][location - 1].getColor() == true
//						&& ma.cellArray[i - 1][location + 1].getColor() == false) {
//
//					ma.cellArray[i][location].setColor(false);
//					ma.cellArray[i][location + 1].setState(true);
//
//				} else if (ma.cellArray[i - 1][location - 1].getColor() == false
//						&& ma.cellArray[i - 1][location + 1].getColor() == false) {
//
//					ma.cellArray[i][location].setColor(true);
//					ma.cellArray[i][location - 1].setState(true);
//
//				}
//
//			}
//			/* rules implementation end */
//		}
//
//		ma.cellArray = cellArr;
//		return ma;
//	}
//
//}
