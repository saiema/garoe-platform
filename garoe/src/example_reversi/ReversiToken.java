package example_reversi;

/**
 * Representacion de una ficha de reversi, la misma tiene su color y sus vecinos en el tablero
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 *
 */
public class ReversiToken {
	final static public int BLACK = -1;
	final static public int WHITE = 1;
	private int color; //
	private ReversiToken left = null;
	private ReversiToken right = null;
	private ReversiToken down = null;
	private ReversiToken up = null;
	private ReversiToken upperLeft = null;
	private ReversiToken upperRight = null;
	private ReversiToken lowerLeft = null;
	private ReversiToken lowerRight = null;
	
	public ReversiToken(int color) {
		this.color = color;
	}

	/**
	 * @return the color
	 */
	protected int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	protected void setColor(int color) {
		this.color = color;
	}

	/**
	 * @return the sameTokens_left
	 */
	protected ReversiToken getLeft() {
		return left;
	}

	/**
	 * @param sameTokens_left the sameTokens_left to set
	 */
	protected void setLeft(ReversiToken t) {
		this.left = t;
	}

	/**
	 * @return the sameTokens_right
	 */
	protected ReversiToken getRight() {
		return right;
	}

	/**
	 * @param sameTokens_right the sameTokens_right to set
	 */
	protected void setRight(ReversiToken t) {
		this.right = t;
	}

	/**
	 * @return the sameTokens_down
	 */
	protected ReversiToken getDown() {
		return down;
	}

	/**
	 * @param sameTokens_down the sameTokens_down to set
	 */
	protected void setDown(ReversiToken t) {
		this.down = t;
	}

	/**
	 * @return the sameTokens_up
	 */
	protected ReversiToken getUp() {
		return up;
	}

	/**
	 * @param sameTokens_up the sameTokens_up to set
	 */
	protected void setUp(ReversiToken t) {
		this.up = t;
	}

	/**
	 * @return the sameTokens_upperLeft
	 */
	protected ReversiToken getUpperLeft() {
		return upperLeft;
	}

	/**
	 * @param sameTokens_upperLeft the sameTokens_upperLeft to set
	 */
	protected void setUpperLeft(ReversiToken t) {
		this.upperLeft = t;
	}

	/**
	 * @return the sameTokens_upperRight
	 */
	protected ReversiToken getUpperRight() {
		return upperRight;
	}

	/**
	 * @param sameTokens_upperRight the sameTokens_upperRight to set
	 */
	protected void setUpperRight(ReversiToken t) {
		this.upperRight = t;
	}

	/**
	 * @return the sameTokens_lowerLeft
	 */
	protected ReversiToken getLowerLeft() {
		return lowerLeft;
	}

	/**
	 * @param sameTokens_lowerLeft the sameTokens_lowerLeft to set
	 */
	protected void setLowerLeft(ReversiToken t) {
		this.lowerLeft = t;
	}

	/**
	 * @return the sameTokens_lowerRight
	 */
	protected ReversiToken getLowerRight() {
		return lowerRight;
	}

	/**
	 * @param sameTokens_lowerRight the sameTokens_lowerRight to set
	 */
	protected void setLowerRight(ReversiToken t) {
		this.lowerRight = t;
	}
	
	public ReversiToken clone() {
		ReversiToken clonedToken = new ReversiToken(this.getColor());
		/*clonedToken.setDown(this.getDown() == null?null:this.getDown().clone());
		clonedToken.setLeft(this.getLeft() == null?null:this.getLeft().clone());
		clonedToken.setLowerLeft(this.getLowerLeft() == null?null:this.getLowerLeft().clone());
		clonedToken.setLowerRight(this.getLowerRight() == null?null:this.getLowerRight().clone());
		clonedToken.setRight(this.getRight() == null?null:this.getRight().clone());
		clonedToken.setUp(this.getUp() == null?null:this.getUp().clone());
		clonedToken.setUpperLeft(this.getUpperLeft() == null?null:this.getUpperLeft().clone());
		clonedToken.setUpperRight(this.getUpperRight() == null?null:this.getUpperRight().clone());*/
		return clonedToken;
	}
	

}
