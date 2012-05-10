/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import framework.AdversarySearchEngine;
import javax.swing.SwingWorker;
//import utils.Pair;

/**
 *
 * @author BigEma
 */
public class ReversiLogic {
    private AdversarySearchEngine<ReversiState> ai;
    private Model model;
    private int turn;
    private boolean playing;
    private int delay;
    
    private class AiTask extends SwingWorker<ReversiState,Void> {
        @Override
        synchronized protected ReversiState doInBackground() {
            model.getGui().enableBoardInteraction(false);
            return ai.nextMove(model.getState());
        }
        
        @Override
        synchronized public void done() {
            try {
                    //System.out.println("AI played");
                    wait(delay);
                    model.setState(get());
                    turn = 1 - turn;
                    model.update();
                    //showGameStatus();
                    if (canIAMoveAgain()) {changeCurrentPlayer();nextMove();}
                    else model.getGui().enableBoardInteraction(false);
                    if (nextMoveIsIA()) nextMove();
            } catch (InterruptedException ignore) {}
            catch (java.util.concurrent.ExecutionException e) {
                String why = null;
                Throwable cause = e.getCause();
                if (cause != null) {
                    why = cause.getMessage();
                } else {
                    why = e.getMessage();
                }
                System.err.println("Error: " + why);
            }
        }
    }
    
    public ReversiLogic(Model model, AdversarySearchEngine<ReversiState> ai) {
        this.model = model;
        this.ai = ai;
        this.turn = 0;
        this.playing = false;
        this.delay = 1;
    }
    
    public void startGame() {
        this.playing = true;
        this.model.startGUI();
        //this.model.disableSettings();
        nextMove();
    }
    
    public void newGame() {
        this.turn = 0;
        this.model.setState(new ReversiState());
        //showBoard(this.model.getState());
        startGame();
    }
    
    public void playerMoves(int row, int col) {
        model.getState().set(col, row, model.getPlayersColors()[turn], true);
        //showBoard(this.model.getState());
        this.model.update();
        //System.out.println(this.model.getPlayersNames()[turn] + " played");
        turn = 1 - turn;
        //showGameStatus();
        if (!this.model.gameIsOver()) nextMove();
    }
    
    public void nextMove() {
        //showGameStatus();
        boolean isAI = this.model.getPlayersBrains()[turn];
        boolean canMove = this.model.getPlayersColors()[turn]==ReversiToken.WHITE?!this.model.getState().whiteAvailableMoves.isEmpty():!this.model.getState().blackAvailableMoves.isEmpty();
        if (canMove) {
            if (isAI) {
//                this.model.setState(this.ai.nextMove(this.model.getState()));
//                turn = 1 - turn;
//                this.model.update();
                AiTask aiTask = new AiTask();
                aiTask.execute();
            }
        } else {
            if (!this.model.gameIsOver()) {
                changeCurrentPlayer();
                nextMove();
            }
        }
    }
    
    private boolean canIAMoveAgain() {
        boolean currentPlayerCanMove = this.model.getPlayersColors()[turn]==ReversiToken.WHITE?!this.model.getState().whiteAvailableMoves.isEmpty():!this.model.getState().blackAvailableMoves.isEmpty();
        boolean isNextPlayerAI = this.model.getPlayersBrains()[1-turn];
        boolean canAIMove = this.model.getPlayersColors()[1-turn]==ReversiToken.WHITE?!this.model.getState().whiteAvailableMoves.isEmpty():!this.model.getState().blackAvailableMoves.isEmpty();
        return !currentPlayerCanMove && (isNextPlayerAI && canAIMove);
    }
    
    private boolean nextMoveIsIA() {
        boolean isAI = this.model.getPlayersBrains()[turn];
        boolean canMove = this.model.getPlayersColors()[turn]==ReversiToken.WHITE?!this.model.getState().whiteAvailableMoves.isEmpty():!this.model.getState().blackAvailableMoves.isEmpty();
        return isAI && canMove;
    }
    
    private void changeCurrentPlayer() {
        turn = 1 - turn;
        this.model.getState().changeLevel();
        this.model.update();
    }
    
    public boolean imPlaying() {
        return this.playing;
    }
    
    public void stopPlaying() {
        this.playing = false;
        this.turn = 0;
        this.model.enableSettings();
    }
    
    
    private void showGameStatus() {
		System.out.println("Current player : " + this.model.getPlayersNames()[turn]);
        System.out.println("Whites possible moves : " + this.model.getState().whiteAvailableMoves.size());
        System.out.println("Blacks possible moves : " + this.model.getState().blackAvailableMoves.size());
	}
    
    public void changePlayersName(int player, String newName) {
        this.model.getPlayersNames()[player] = newName;
    }
    
    public void changePlayersBrain(int player, boolean ai) {
        this.model.getPlayersBrains()[player] = ai;
    }
    
    public void changePlayersColor(int player, int newColor) {
        this.model.getPlayersColors()[player] = newColor;
    }
    
    public void setAIdelay(int delay) {
        this.delay = delay>0? delay*1000:1;
    }
    
    public int getAIdelay() {
        return this.delay==1? 0:this.delay / 1000;
    }
    
    public Model getModel() {
        return this.model;
    }
    
    public AdversarySearchEngine<ReversiState> getAI() {
        return this.ai;
    }    
}
