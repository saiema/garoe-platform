/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import examples.GaroePlaygroundController;
import javax.swing.ImageIcon;

/**
 *
 * @author BigEma
 */
public class ReversiController {
    private ReversiLogic logic;
    private boolean gameExited = false;
    private boolean standAlone = true;
    private GaroePlaygroundController mainController = null;
    
    public ReversiController (ReversiLogic logic) {
        this.logic = logic;
    }
    
    public void setMainController(GaroePlaygroundController mainController) {
        if (mainController != null) {
            this.standAlone = false;
            this.mainController = mainController;
        } else {
            this.standAlone = true;
            this.mainController = null;
        }
    }
    
    public void placeToken(int row, int col) {
        this.logic.playerMoves(row, col);
//        if (this.logic.getModel().gameIsOver()) {
//            ReversiState model = this.logic.getModel().getState();
//            if (model.maxWins()) {
//                this.gameResults(true, false);
//            } else if (model.minWins()) {
//                this.gameResults(false,true);
//            } else {
//                this.gameResults(true, true);
//            }
//                this.endGame();
//        }
    }
    
    public void exitGame() {
        if (this.standAlone) {
            System.exit(0);
        } else {
            this.logic.getModel().getGui().setEnabled(false);
            this.logic.getModel().getGui().setVisible(false);
            this.logic.getModel().getGui().dispose();
            this.mainController.startMainGUI();
        }
    }
    
    public void newGame() {
        this.logic.newGame();
    }
    
    public void about() {
        AboutReversi about = new AboutReversi(this.logic.getModel().getGui(), true);
        about.setVisible(true);
    }
    
    public void settings() {
        this.logic.getModel().getGui().setFocusable(false);
        this.logic.getModel().getGui().setEnabled(false);
        ReversiSettingsController settingsController = new ReversiSettingsController(this.logic);
        settingsController.show();
    }
    
    public void iaSettings() {
        this.logic.getModel().getGui().setFocusable(false);
        this.logic.getModel().getGui().setEnabled(false);
        ReversiAISettingsController aiController = new ReversiAISettingsController(this.logic);
        aiController.show();
    }
    
    public void endGame() {
        this.logic.stopPlaying();
    }
    
    public ReversiLogic getLogic() {
        return this.logic;
    }
    
//    private void gameResults(boolean maxWon, boolean minWon) {
//        boolean singlePlayer = logic.getModel().getPlayersBrains()[0] ^ logic.getModel().getPlayersBrains()[1];
//        int player = singlePlayer?!logic.getModel().getPlayersBrains()[0]?0:1:-1;
//        EndGameDialog endGameDialog;
//        if (maxWon && minWon) {
//            endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/empataste120x120.jpg")),"EMPATARON!!!");
//        } else {
//            if (singlePlayer) {
//                if (maxWon && this.logic.getModel().getPlayersColors()[player] == ReversiToken.WHITE) {
//                    endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),"GANASTE!!!");
//                } else if (minWon && this.logic.getModel().getPlayersColors()[player] == ReversiToken.BLACK) {
//                    endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),"GANASTE!!!");
//                } else {
//                    endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/perdiste120x120.jpg")),"PERDISTE!!!");
//                }
//            } else {
//                if (maxWon) {
//                    if (this.logic.getModel().getPlayersColors()[0]==ReversiToken.WHITE) {
//                        endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),this.logic.getModel().getPlayersNames()[0]/*+" GANO!!"*/);
//                    } else {
//                        endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),this.logic.getModel().getPlayersNames()[1]/*+" GANO!!"*/);
//                    }
//                } else {
//                    if (this.logic.getModel().getPlayersColors()[0]==ReversiToken.BLACK) {
//                        endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),this.logic.getModel().getPlayersNames()[0]/*+" GANO!!"*/);
//                    } else {
//                        endGameDialog = new EndGameDialog(new ImageIcon(System.class.getResource("/images/ganaste120x120.jpg")),this.logic.getModel().getPlayersNames()[1]/*+" GANO!!"*/);
//                    }
//                }
//            }   
//        }
//        this.logic.getModel().getGui().setEnabled(false);
//        this.logic.getModel().getGui().setFocusable(false);
//        endGameDialog.setFather(this.logic.getModel().getGui());
//        endGameDialog.setVisible(true);
//    }
    
}
