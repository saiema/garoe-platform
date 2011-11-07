/**
 * 
 */
package example_reversi;

import java.util.LinkedList;
import java.util.List;

import utils.ComparableInt;
import utils.IComparable;
import utils.Pair;
import engine_framework.IStateAdversary;

/**
 * El estado del reversi
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public class ReversiState implements IStateAdversary {
	protected ReversiToken[][] board = new ReversiToken[8][8];
	protected List<Pair<Integer,Integer>> blackAvailableMoves;
	protected List<Pair<Integer,Integer>> whiteAvailableMoves;
	boolean iamMax; //white
	boolean iamMin; //black
	int blackCount;
	int whiteCount;

	public ReversiState() {
		for (ReversiToken[] row : board) {
			for (int i = 0; i < 8; i++) {
				row[i] = null;
			}
		}
		board[3][3] = new ReversiToken(ReversiToken.WHITE);
		board[4][3] = new ReversiToken(ReversiToken.BLACK);
		board[3][4] = new ReversiToken(ReversiToken.BLACK);
		board[4][4] = new ReversiToken(ReversiToken.WHITE);
		linkTokens(3,3);
		linkTokens(4,3);
		linkTokens(3,4);
		linkTokens(4,4);
		blackCount = 2;
		whiteCount = 2;
		iamMax = true;
		iamMin = false;
		blackAvailableMoves = new LinkedList<Pair<Integer,Integer>>();
		blackAvailableMoves.add(new Pair<Integer,Integer>(2,3));
		blackAvailableMoves.add(new Pair<Integer,Integer>(3,2));
		blackAvailableMoves.add(new Pair<Integer,Integer>(5,4));
		blackAvailableMoves.add(new Pair<Integer,Integer>(4,5));
		whiteAvailableMoves = new LinkedList<Pair<Integer,Integer>>();
		whiteAvailableMoves.add(new Pair<Integer,Integer>(2,4));
		whiteAvailableMoves.add(new Pair<Integer,Integer>(4,2));
		whiteAvailableMoves.add(new Pair<Integer,Integer>(5,3));
		whiteAvailableMoves.add(new Pair<Integer,Integer>(3,5));
	}
	
	public ReversiState clone() {
		ReversiState revClone = new ReversiState();
		revClone.board = new ReversiToken[8][8];
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				revClone.board[r][c] = this.board[r][c] == null?null:this.board[r][c].clone();
			}
		}
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				revClone.linkTokens(r,c);
			}
		}
		revClone.iamMax = this.iamMax;
		revClone.iamMin = this.iamMin;
		revClone.blackAvailableMoves.clear();
		revClone.whiteAvailableMoves.clear();
		for (Pair<Integer,Integer> pair : this.blackAvailableMoves) {
			revClone.blackAvailableMoves.add(new Pair<Integer,Integer>(pair.getFirstElem(), pair.getSecondElem()));
		}
		for (Pair<Integer,Integer> pair : this.whiteAvailableMoves) {
			revClone.whiteAvailableMoves.add(new Pair<Integer,Integer>(pair.getFirstElem(), pair.getSecondElem()));
		}
		revClone.blackCount = this.blackCount;
		revClone.whiteCount = this.whiteCount;
		return revClone;
	}
	
	public List<Pair<Integer,Integer>> getWhiteAvailableMoves() {
		return this.whiteAvailableMoves;
	}
	
	public List<Pair<Integer,Integer>> getBlackAvailableMoves() {
		return this.blackAvailableMoves;
	}
	
	public void set(int c, int r, int color, boolean autoPlayerSet) {
		ReversiToken newToken = new ReversiToken(color);
		board[r][c] = newToken;
		if (this.iamMax) {
			whiteCount++;
		} else {
			blackCount++;
		}
		linkTokens(r,c);
		if (c == 0 && r == 0) { //esquina superior izquierda
			goHorizontalToRight(c,r,newToken, true);
			goVerticalDown(c,r,newToken, true);
			goDiagonalToLowerRight(c,r,newToken, true);
		} else if (c == 0 && r == 7) { //esquina inferior izquierda
			goHorizontalToRight(c,r,newToken, true);
			goVerticalUp(c,r,newToken, true);
			goDiagonalToUpperRight(c,r,newToken, true);
		} else if (c == 0) { //borde izquierdo
			goHorizontalToRight(c,r,newToken, true);
			goVerticalUp(c,r,newToken, true);
			goVerticalDown(c,r,newToken, true);
			goDiagonalToUpperRight(c,r,newToken, true);
			goDiagonalToLowerRight(c,r,newToken, true);
		} else if (c == 7 && r == 0) { //esquina superior derecha
			goHorizontalToLeft(c,r,newToken, true);
			goDiagonalToLowerLeft(c,r,newToken, true);
			goVerticalDown(c,r,newToken, true);
		} else if (c == 7 && r == 7) { //esquina inferior derecha
			goHorizontalToLeft(c,r,newToken, true);
			goVerticalUp(c,r,newToken, true);
			goDiagonalToUpperLeft(c,r,newToken, true);
		} else if (c == 7) { //borde derecho
			goHorizontalToLeft(c,r,newToken, true);
			goVerticalUp(c,r,newToken, true);
			goVerticalDown(c,r,newToken, true);
			goDiagonalToLowerLeft(c,r,newToken, true);
			goDiagonalToUpperLeft(c,r,newToken, true);
		} else if (r == 0) { //borde superior
			goHorizontalToLeft(c,r,newToken, true);
			goHorizontalToRight(c,r,newToken, true);
			goVerticalDown(c,r,newToken, true);
			goDiagonalToLowerLeft(c,r,newToken, true);
			goDiagonalToLowerRight(c,r,newToken, true);
		} else if (r == 7) { //borde inferior
			goHorizontalToLeft(c,r,newToken, true);
			goHorizontalToRight(c,r,newToken, true);
			goDiagonalToUpperRight(c,r,newToken, true);
			goDiagonalToUpperLeft(c,r,newToken, true);
			goVerticalUp(c,r,newToken, true);
		} else { //resto del tablero
			goHorizontalToLeft(c,r,newToken, true);
			goHorizontalToRight(c,r,newToken, true);
			goDiagonalToUpperRight(c,r,newToken, true);
			goDiagonalToUpperLeft(c,r,newToken, true);
			goDiagonalToLowerLeft(c,r,newToken, true);
			goDiagonalToLowerRight(c,r,newToken, true);
			goVerticalUp(c,r,newToken, true);
			goVerticalDown(c,r,newToken, true);
		}
		refreshAvailableMoves();
		if (autoPlayerSet) {
			if (this.isMax()) {
				this.setMin();
			} else {
				this.setMax();
			}
		}
	}
	
	private void linkTokens(int r, int c) {
		ReversiToken token = board[r][c];
		if (token != null) {
			if ((r - 1) >= 0) { //arriba
				token.setUp(board[r-1][c]);
				if (board[r-1][c] != null) board[r-1][c].setDown(token);
				if ((c - 1) >= 0) { //diagonal arriba a la izquierda
					token.setUpperLeft(board[r-1][c-1]);
					if (board[r-1][c-1] != null) board[r-1][c-1].setLowerRight(token);
				}
				if ((c + 1) < 8) { //diagonal arriba a la derecha
					token.setUpperRight(board[r-1][c+1]);
					if (board[r-1][c+1] != null) board[r-1][c+1].setLowerLeft(token);
				}
			}
			if ((r+1) < 8) { //abajo
				token.setDown(board[r+1][c]);
				if (board[r+1][c] != null) board[r+1][c].setUp(token);
				if ((c+1) < 8) { //diagonal abajo a la derecha
					token.setLowerRight(board[r+1][c+1]);
					if (board[r+1][c+1] != null) board[r+1][c+1].setUpperLeft(token);
				}
				if ((c-1) >= 0) { //diagonal abajo a la izquierda
					token.setLowerLeft(board[r+1][c-1]);
					if (board[r+1][c-1] != null) board[r+1][c-1].setUpperRight(token);
				}
			}
			if ((c - 1) >= 0) { //izquierda
				token.setLeft(board[r][c-1]);
				if (board[r][c-1] != null) board[r][c-1].setRight(token);
			}
			if ((c + 1) < 8) { //derecha
				token.setRight(board[r][c+1]);
				if (board[r][c+1] != null) board[r][c+1].setLeft(token);
			}
		}
	}
	
	public void refreshAvailableMoves() {
		this.blackAvailableMoves.clear();
		this.whiteAvailableMoves.clear();
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (board[r][c] == null) {
					boolean isAvailableBlack = false;
					boolean isAvailableWhite = false;
					if (c == 0 && r == 0) { //esquina superior izquierda
						isAvailableBlack = !isAvailableBlack? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalDown(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalDown(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableBlack;
					} else if (c == 0 && r == 7) { //esquina inferior izquierda
						isAvailableBlack = !isAvailableBlack? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalUp(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalUp(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else if (c == 0) { //borde izquierdo
						isAvailableBlack = !isAvailableBlack? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalDown(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalDown(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalUp(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalUp(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else if (c == 7 && r == 0) { //esquina superior derecha
						isAvailableBlack = !isAvailableBlack? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalDown(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalDown(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else if (c == 7 && r == 7) { //esquina inferior derecha
						isAvailableBlack = !isAvailableBlack? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalUp(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalUp(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else if (c == 7) { //borde derecho
						isAvailableBlack = !isAvailableBlack? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalDown(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalDown(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalUp(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalUp(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else if (r == 0) { //borde superior
						isAvailableBlack = !isAvailableBlack? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalDown(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalDown(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else if (r == 7) { //borde inferior
						isAvailableBlack = !isAvailableBlack? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalUp(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalUp(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					} else { //resto del tablero
						isAvailableBlack = !isAvailableBlack? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goHorizontalToRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToUpperRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalUp(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalUp(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goVerticalDown(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goVerticalDown(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerLeft(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
						isAvailableBlack = !isAvailableBlack? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.BLACK), false):isAvailableBlack;
						isAvailableWhite = !isAvailableWhite? goDiagonalToLowerRight(c,r,new ReversiToken(ReversiToken.WHITE), false):isAvailableWhite;
					}	
					if (isAvailableBlack) {
						this.blackAvailableMoves.add(new Pair<Integer,Integer>(r,c));
					} 
					if (isAvailableWhite) {
						this.whiteAvailableMoves.add(new Pair<Integer,Integer>(r,c));
					}
				}
			}
		}
	}
	
	private boolean goHorizontalToRight(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r][c+1] != null && board[r][c+1].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r][c+1];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getRight(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r][c+1]
				int tokenCount = 0;
				current = current.getLeft(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getLeft();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goHorizontalToLeft(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if ((board[r][c-1] != null) && board[r][c-1].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r][c-1];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getLeft(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r][c-1]
				int tokenCount = 0;
				current = current.getRight(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getRight();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goVerticalUp(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r-1][c] != null && board[r-1][c].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r-1][c];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getUp(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r-1][c]
				int tokenCount = 0;
				current = current.getDown(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getDown();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goVerticalDown(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r+1][c] != null && board[r+1][c].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r+1][c];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getDown(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r+1][c]
				int tokenCount = 0;
				current = current.getUp(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getUp();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goDiagonalToUpperRight(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r-1][c+1] != null && board[r-1][c+1].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r-1][c+1];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getUpperRight(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r-1][c+1]
				int tokenCount = 0;
				current = current.getLowerLeft(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getLowerLeft();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goDiagonalToUpperLeft(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r-1][c-1] != null && board[r-1][c-1].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r-1][c-1];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getUpperLeft(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r-1][c-1]
				int tokenCount = 0;
				current = current.getLowerRight(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getLowerRight();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goDiagonalToLowerRight(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r+1][c+1] != null && board[r+1][c+1].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r+1][c+1];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getLowerRight(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r+1][c+1]
				int tokenCount = 0;
				current = current.getUpperLeft(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getUpperLeft();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	private boolean goDiagonalToLowerLeft(int c, int r, ReversiToken token, boolean modify) {
		boolean res = false;
		int oppositeColor = token.getColor() == ReversiToken.WHITE?ReversiToken.BLACK:ReversiToken.WHITE;
		if (board[r+1][c-1] != null && board[r+1][c-1].getColor() == oppositeColor) {
			//revisar si se puede
			boolean ok = false;
			ReversiToken current = board[r+1][c-1];
			boolean end = current == null;
			while (!end && !ok && (current.getColor() == oppositeColor)) {
				current = current.getLowerLeft(); //avanzo
				if (current != null) {
					if (current.getColor() == token.getColor()) { //llegue a un final bueno
						ok = true;
					}
				} else {
					end = true;
				}
			}
			res = ok;
			if (ok && modify) { //revertir color desde current hasta board[r+1][c-1]
				int tokenCount = 0;
				current = current.getUpperRight(); //ultima ficha de color contrario
				while (current != token) { //solo hay un objeto por ficha, asi que comparacion por referencia alcanza
					current.setColor(token.getColor());
					current = current.getUpperRight();
					tokenCount++;
				}
				if (token.getColor() == ReversiToken.WHITE) {
					this.whiteCount += tokenCount;
					this.blackCount -= tokenCount;
				} else {
					this.blackCount += tokenCount;
					this.whiteCount -= tokenCount;
				}
			}
		}
		return res;
	}
	
	
	
	@Override
	public IComparable evaluate() {
		//return new ComparableInt(whiteCount - blackCount);
		return new ComparableInt(count());
	}

	@Override
	public IComparable minVal() {
		return new ComparableInt(-184);
	}

	@Override
	public IComparable maxVal() {
		return new ComparableInt(184);
	}


	@Override
	public boolean isFinal() {
		return (this.isMin() && this.blackAvailableMoves.isEmpty()) || (this.isMax() && this.whiteAvailableMoves.isEmpty());
	}

	@Override
	public boolean success() {
		return minWins() || maxWins();
	}

	@Override
	public boolean repOk() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean minWins() {
		return isFinal() && evaluate().compareTo(new ComparableInt(0)) < 0;
	}

	@Override
	public boolean maxWins() {
		return isFinal() && evaluate().compareTo(new ComparableInt(0)) > 0;
	}

	@Override
	public boolean isMax() {
		return this.iamMax;
	}

	@Override
	public boolean isMin() {
		return this.iamMin;
	}

	@Override
	public void setMax() {
		this.iamMin = false;
		this.iamMax = true;
	}

	@Override
	public void setMin() {
		this.iamMax = false;
		this.iamMin = true;
	}

	@Override
	public String toString() {
		String status = "current player : " + (this.isMax()?"White(W)":"Black(B)") + "\n";
		String score = "whites : " + this.whiteCount + "\n" + "blacks : " + this.blackCount + "\n";
		String stateRep = "   0|1|2|3|4|5|6|7\n";
		for (int r = 0; r < 8; r++) {
			String line = r + " |";
			for (int c = 0; c < 8; c++) {
				line += board[r][c] == null?(" "):(board[r][c].getColor() == ReversiToken.BLACK?"B":"W");
				if (c < 7) {
					line += '|';
				}
			}
			line += '|';
			stateRep += line + '\n';
		}
		return status + score + "\n" + stateRep;
	}

	/**
	 * @return the board
	 */
	public ReversiToken[][] getBoard() {
		return board;
	}
	
	public void changeLevel() {
		if (this.isMax()) {
			this.setMin();
		} else {
			this.setMax();
		}
	}
	
	public int count() {
		int res = 0;
		int normal = 1;
		int border = 5;
		int corner = 7;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (board[row][col] != null) {
					if (board[row][col].getColor() == ReversiToken.WHITE) {
						if ((row == 0 && col == 0) || (row == 7 && col == 7) || (row == 0 && col == 7) || (row == 7 && col == 0)) {
							res += corner;
						} else if (row == 0 || col == 0 || row == 7 || col == 7) {
							res += border;
						} else {
							res += normal;
						}
					} else {
						if ((row == 0 && col == 0) || (row == 7 && col == 7) || (row == 0 && col == 7) || (row == 7 && col == 0)) {
							res -= corner;
						} else if (row == 0 || col == 0 || row == 7 || col == 7) {
							res -= border;
						} else {
							res -= normal;
						}
					}
				}
			}
		}
		return res;
	}
	
	
}
