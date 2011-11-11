/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import javax.swing.JFrame;

/**
 *
 * @author BigEma
 */
public class ReversiController {
    private ReversiLogic logic;
    
    public ReversiController (ReversiLogic logic) {
        this.logic = logic;
    }
    
    public void placeToken(int row, int col) {
        this.logic.playerMoves(row, col);
    }
    
    public void exitGame() {
        System.exit(0);
    }
    
    public void newGame() {
        this.logic.newGame();
    }
    
    public void about(JFrame father) {
        
    }
    
    public void settings(JFrame father) {
        
    }
    
    public void iaSettings(JFrame father) {
        
    }
    
    public void endGame() {
        this.logic.stopPlaying();
    }
    
}
