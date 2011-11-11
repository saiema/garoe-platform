/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import engine_framework.AdversarySearchEngine;
import utils.Pair;

/**
 *
 * @author BigEma
 */
public class ReversiLogic {
    private AdversarySearchEngine<ReversiState> ai;
    private Model model;
    private int turn;
    private boolean playing;
    
    public ReversiLogic(Model model, AdversarySearchEngine<ReversiState> ai) {
        this.model = model;
        this.ai = ai;
        this.turn = 0;
        this.playing = false;
    }
    
    public void startGame() {
        this.playing = true;
        this.model.startGUI();
        nextMove();
    }
    
    public void newGame() {
        this.model.setState(new ReversiState());
        showBoard(this.model.getState());;
        startGame();
    }
    
    public void playerMoves(int row, int col) {
        model.getState().set(col, row, model.getPlayersColors()[turn], true);
        showBoard(this.model.getState());
        this.model.update();     
        turn = 1 - turn;
        nextMove();
    }
    
    public void nextMove() {
        boolean isAI = this.model.getPlayersBrains()[turn];
        boolean canMove = this.model.getPlayersColors()[turn]==ReversiToken.WHITE?!this.model.getState().whiteAvailableMoves.isEmpty():!this.model.getState().blackAvailableMoves.isEmpty();
        if (canMove) {
            if (isAI) {
                this.model.setState(this.ai.nextMove(this.model.getState()));
                turn = 1 - turn;
                this.model.update();
            }
        } else {
            turn = 1 - turn;
            this.model.update();
        }
    }
    
    public boolean imPlaying() {
        return this.playing;
    }
    
    public void stopPlaying() {
        this.playing = false;
    }
    
    
    private void showBoard(ReversiState gameState) {
		System.out.println(gameState.toString());
		System.out.println();
		for (Pair<Integer,Integer> move : (gameState.isMax()?gameState.whiteAvailableMoves:gameState.blackAvailableMoves)) {
			System.out.println(move.toString());
		}
	}
    
}
