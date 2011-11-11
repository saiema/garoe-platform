/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

/**
 *
 * @author BigEma
 */
public class Model {
    private ReversiState state;
    private ReversiGUI gui;
    private String[] playersNames;
    private int[] playersColors;
    private boolean[] playersBrains;
    
    public Model(ReversiState state, ReversiGUI gui) {
        this.state = state;
        this.gui = gui;
        this.playersNames = new String[] {"player1", "player2"};
        this.playersColors = new int[] {ReversiToken.WHITE, ReversiToken.BLACK};
        this.playersBrains = new boolean[] {false, false};
    }
    
    public ReversiState getState() {
        return this.state;
    }

    public void setState(ReversiState state) {
        this.state = state;
    }
    
    public void startGUI() {
        this.gui.enableBoard();
        this.gui.getPlayer1Name().setText(playersNames[0] + (playersBrains[0]?"(AI)":"(Human)"));
        this.gui.getPlayer2Name().setText(playersNames[1] + (playersBrains[1]?"(AI)":"(Human)"));
        this.gui.getPlayer1Color().setText(playersColors[0]==ReversiToken.WHITE?"WHITE":"BLACK");
        this.gui.getPlayer2Color().setText(playersColors[1]==ReversiToken.WHITE?"WHITE":"BLACK");
        update();
    }
    
    public void update() {
        this.gui.update(state);
    }

    public ReversiGUI getGui() {
        return gui;
    }

    public boolean[] getPlayersBrains() {
        return playersBrains;
    }

    public int[] getPlayersColors() {
        return playersColors;
    }

    public String[] getPlayersNames() {
        return playersNames;
    }
    
}
