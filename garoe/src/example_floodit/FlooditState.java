/**
 * 
 */
package example_floodit;

import framework.IBasicState;
import java.util.HashSet;
import java.util.Random;

import utils.ComparableFloat;
import utils.IComparable;
import framework.IinformedState;
import java.util.Set;
import java.util.TreeSet;

/**
 * El estado del flood it
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public class FlooditState implements IinformedState {
    private FlooditState parent;
	public static int verde = 0;
	public static int amarillo = 1;
	public static int rojo = 2;
	public static int azul = 3;
	public static int celeste = 4;
	public static int rosa = 5;
	private final int DEFAULT_BOARD_SIZE = 14;
	private final int DEFAULT_COLORS = 6;
	private final int max_steps = 25;
	private FlooditToken[][] board;
	private FlooditToken firstToken;
	private int stepsMade = 0;
    
    //generacion
    static public final int ALL_RANDOM_MODE = 0;
    static public final int REDUCED_BY_CONTEXT_MODE = 1;
    static public final int REDUCED_BY_CONTEXT_MODE_2 = 2;
    private int genMode = ALL_RANDOM_MODE;
	
	
	public FlooditState() {
		board = new FlooditToken[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
	}

	public void populateBoard() {
		//Random colorGenerator = new Random();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				//FlooditToken newToken = new FlooditToken(colorGenerator.nextInt(DEFAULT_COLORS));
				FlooditToken newToken = new FlooditToken(genColor(this.genMode,row,col));
                board[row][col] = newToken;
			}
		}
		linkTokens();
		firstToken = board[0][0];
	}
    
    public void easy() {
        this.genMode = REDUCED_BY_CONTEXT_MODE;
    }
    
    public void medium() {
        this.genMode = REDUCED_BY_CONTEXT_MODE_2;
    }
    
    public void hard() {
        this.genMode = ALL_RANDOM_MODE;
    }
    
    public void setGeneratorMode(int mode) {
        this.genMode = mode;
    }
    
    private int genColor(int mode, int row, int col) {
        Random colorGenerator = new Random();
        Set<Integer> filteredColors = new TreeSet<Integer>();
        int color = 0;
        if (mode == this.ALL_RANDOM_MODE) {
            color = colorGenerator.nextInt(DEFAULT_COLORS);
        } else if (mode == this.REDUCED_BY_CONTEXT_MODE || mode == this.REDUCED_BY_CONTEXT_MODE_2) {
            if (row == 0 && col == 0) {
                return genColor(this.ALL_RANDOM_MODE,row,col);
            } else if (row == 0) {
                filteredColors.add(board[row][col-1].getColor());
            } else if (row > 0) {
                if (col > 0) {
                    filteredColors.add(board[row-1][col-1].getColor());
                    filteredColors.add(board[row][col-1].getColor());
                }
                filteredColors.add(board[row-1][col].getColor());
            }
            int remainingColors = 0;
            if (mode == REDUCED_BY_CONTEXT_MODE) {
                remainingColors = 4 - filteredColors.size();
            } else if (mode == REDUCED_BY_CONTEXT_MODE_2) {
                remainingColors = 5 - filteredColors.size();
            }
            
            for (int i = remainingColors; i > 0;i--) {
                boolean newColorFound = false;
                int newColor = 0;
                while (!newColorFound) {
                    newColor = colorGenerator.nextInt(DEFAULT_COLORS);
                    if (!filteredColors.contains(newColor)) {
                        newColorFound = true;
                    }
                }
                filteredColors.add(newColor);
            }
            color = (Integer)filteredColors.toArray()[colorGenerator.nextInt(4)];
        }
        return color;
    }
	
	private void linkTokens() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row == 0 && col == 0) { 											//superior izquierda
					board[row][col].addNeighbour(board[row][col+1]);
					board[row][col].addNeighbour(board[row+1][col]);
				} else if (row == 0 && (col == board.length - 1)) { 					//superior derecha
					board[row][col].addNeighbour(board[row+1][col]);
					board[row][col].addNeighbour(board[row][col-1]);
				} else if (row == (board.length - 1) && col == 0) { 					//inferior izquierda
					board[row][col].addNeighbour(board[row-1][col]);
					board[row][col].addNeighbour(board[row][col+1]);
				} else if (row == (board.length - 1) && col == (board.length - 1)) { 	//inferior derecha
					board[row][col].addNeighbour(board[row][col-1]);
					board[row][col].addNeighbour(board[row-1][col]);
				} else if (col == 0) { 													//borde izquierdo
					board[row][col].addNeighbour(board[row-1][col]);
					board[row][col].addNeighbour(board[row][col+1]);
					board[row][col].addNeighbour(board[row+1][col]);
				} else if (col == (board.length - 1)) { 								//borde derecho
					board[row][col].addNeighbour(board[row+1][col]);
					board[row][col].addNeighbour(board[row][col-1]);
					board[row][col].addNeighbour(board[row-1][col]);
				} else if (row == 0) { 													//boarde superior
					board[row][col].addNeighbour(board[row][col+1]);
					board[row][col].addNeighbour(board[row+1][col]);
					board[row][col].addNeighbour(board[row][col-1]);
				} else if (row == (board.length - 1)) { 								//borde inferior
					board[row][col].addNeighbour(board[row][col+1]);
					board[row][col].addNeighbour(board[row][col-1]);
					board[row][col].addNeighbour(board[row-1][col]);				
				} else { 																//resto del tablero
					board[row][col].addNeighbour(board[row-1][col]);
					board[row][col].addNeighbour(board[row][col+1]);
					board[row][col].addNeighbour(board[row+1][col]);
					board[row][col].addNeighbour(board[row][col-1]);
				}
			}
		}
	}
	
	
	public int changeColor(int color) {
		if (!isFinal() && this.firstToken.getColor() != color) {
			stepsMade++;
			int changed = this.firstToken.changeColor(color);
			return changed;
		} else {
			return -1;
		}
	}


	@Override
	public boolean isFinal() {
		return this.stepsMade == this.max_steps || success();
	}

	@Override
	public boolean success() {
		return this.firstToken.checkSameColors(new HashSet<FlooditToken>()) == (this.board.length * this.board.length);
	}
	

	@Override
	public boolean repOk() {
		return true;
	}

	@Override
	public IComparable evaluate() {
		if (this.stepsMade == 0) {
			return new ComparableFloat((float) 0);
		} else {
			return new ComparableFloat(((float)this.firstToken.checkSameColors(new HashSet<FlooditToken>())/(float)this.stepsMade));
		}
	}

	@Override
	public IComparable minVal() {
		return new ComparableFloat((float) 0);
	}

	@Override
	public IComparable maxVal() {
		return new ComparableFloat((float) this.board.length * this.board.length);
	}
	
	public int getColorOfToken(int row, int col) {
		return this.board[row][col].getColor();
	}
	
	public int getSteps() {
		return this.stepsMade;
	}
	
	public int getMaxSteps() {
		return this.max_steps;
	}
	
	public int getColors() {
		return this.DEFAULT_COLORS;
	}
	
    @Override
	public FlooditState clone() {
		//int boardSize, int colors, int maxSteps
		FlooditState newClone = new FlooditState();
		for (int row = 0; row < this.board.length; row++) {
			for (int col = 0; col < this.board.length; col++) {
				newClone.board[row][col] = new FlooditToken(this.board[row][col].getColor());
			}
		}
		newClone.linkTokens();
		newClone.stepsMade = this.stepsMade;
		newClone.firstToken = newClone.board[0][0];
		return newClone;
	}
	
    @Override
	public String toString() {
		String status = "moves made : " + this.stepsMade + "\n";
		String boardRep = "";
		String line = "";
		for (int i = 0; i < this.board.length; i++) {
			line += "----";
		}
		line += "\n";
		for (int row = 0; row < this.board.length; row++) {
			String lineRep = "|";
			for (int col = 0; col < this.board.length; col++) {
				lineRep += this.board[row][col].getColor() + " | ";
			}
			boardRep += lineRep + "\n";
		}
		return status + line + boardRep + line + "\n";
	}
	
	public int getSize() {
		return this.board.length;
	}
    
    public int getSameColor() {
        return this.firstToken.checkSameColors(new HashSet<FlooditToken>());
    }
    
    /*@Override
    public boolean equals(Object o) {
        FlooditState other = (FlooditState)o;
        int thisSameColor = this.firstToken.checkSameColors(new HashSet<FlooditToken>());
        int otherSameColor = other.firstToken.checkSameColors(new HashSet<FlooditToken>());
        return (thisSameColor == otherSameColor);
    }*/

    @Override
    public IBasicState getParent() {
        return this.parent;
    }

    @Override
    public void setParent(IBasicState parent) {
        this.parent = (FlooditState)parent;
    }


}
