/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

/**
 *
 * @author BigEma
 */
public class ReversiSettingsController {
    private ReversiLogic logic;
    private SettingsGUI settings;
    
    public ReversiSettingsController(ReversiLogic logic) {
        this.logic = logic;
        this.settings = new SettingsGUI();
        this.settings.setController(this);
        this.settings.getPlayer1NameValue().setText(this.logic.getModel().getPlayersNames()[0]);
        this.settings.getPlayer2NameValue().setText(this.logic.getModel().getPlayersNames()[1]);
        int player1Color = this.logic.getModel().getPlayersColors()[0];
        int player2Color = this.logic.getModel().getPlayersColors()[1];
        this.settings.getPlayer1Color().setText(player1Color == ReversiToken.WHITE?"WHITE":"BLACK");
        this.settings.getPlayer2Color().setText(player2Color == ReversiToken.WHITE?"WHITE":"BLACK");
        boolean player1Brains = this.logic.getModel().getPlayersBrains()[0];
        boolean player2Brains = this.logic.getModel().getPlayersBrains()[1];
        this.settings.getPlayer1BrainsSelect().setSelectedIndex(player1Brains?0:1);
        this.settings.getPlayer2BrainsSelect().setSelectedIndex(player2Brains?0:1);
    }
    
    public void show() {
        this.settings.setEnabled(true);
        this.settings.setVisible(true);
    }
    
    public void save(String name1, String name2, int color1, int color2, boolean ai1, boolean ai2) {
        if (!logic.imPlaying()) {
            this.logic.changePlayersName(0, name1);
            this.logic.changePlayersName(1, name2);
            this.logic.changePlayersColor(0, color1);
            this.logic.changePlayersColor(1, color2);
            this.logic.changePlayersBrain(0, ai1);
            this.logic.changePlayersBrain(1, ai2);
            close();
        } else {
            //NO SE PUEDEN REALIZAR CAMBIOS MIENTRAS SE JUEGA
        }
    }
    
    public void close() {
        this.logic.getModel().getGui().setEnabled(true);
        this.logic.getModel().getGui().setFocusable(true);
        this.settings.dispose();
    }
}
