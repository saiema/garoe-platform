/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author BigEma
 */
public class GaroePlaygroundController {
    private GaroePlaygroundGUI mainGUI;
    private ReversiGame reversi;
    private FlooditGame floodit;
    
    public GaroePlaygroundController(GaroePlaygroundGUI mainGUI) {
        this.mainGUI = mainGUI;
        this.reversi = new ReversiGame(this);
        this.floodit = new FlooditGame(this);
        
    }
    
    public void startMainGUI() {
        this.mainGUI.setEnabled(true);
        this.mainGUI.setVisible(true);
    }
    
    public void startReversi() {
        this.mainGUI.setEnabled(false);
        this.mainGUI.setVisible(false);
        reversi.start();
    }
    
    public void startFloodit() {
        this.mainGUI.setEnabled(false);
        this.mainGUI.setVisible(false);
        floodit.start();
    }
    
    public void showAbout() {
        
    }
    
    public void exit() {
        this.mainGUI.setVisible(false);
        this.mainGUI.setEnabled(false);
        this.mainGUI.dispose();
    }
    
    
}
