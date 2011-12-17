/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import java.awt.Color;

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
        this.settings.setHintValue(this.logic.getModel().getGui().getRender().getHint(), this.logic.getModel().getGui().getRender().getWhiteColor(), this.logic.getModel().getGui().getRender().getBlackColor());
    }
    
    public void show() {
        this.settings.setEnabled(true);
        this.settings.setVisible(true);
        if (this.logic.imPlaying()) {
            this.settings.getPlayer1NameValue().setEnabled(false);
            this.settings.getPlayer2NameValue().setEnabled(false);
            this.settings.getPlayer1Color().setEnabled(false);
            this.settings.getPlayer2Color().setEnabled(false);
            this.settings.getPlayer1BrainsSelect().setEnabled(false);
            this.settings.getPlayer2BrainsSelect().setEnabled(false);
        }
    }
    
    public void save(String name1, String name2, int color1, int color2, boolean ai1, boolean ai2, boolean hintEnable, Color whiteColor, Color blackColor) {
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
        this.logic.getModel().getGui().getRender().enableHint(hintEnable);
        this.logic.getModel().getGui().getRender().setWhiteHintColor(whiteColor);
        this.logic.getModel().getGui().getRender().setBlackHintColor(blackColor);
        this.logic.getModel().getGui().repaintBoard();
        close();
    }
    
    public void close() {
        this.logic.getModel().getGui().setEnabled(true);
        this.logic.getModel().getGui().setFocusable(true);
        this.settings.dispose();
    }
}
