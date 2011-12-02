/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import example_floodit.FlooditController;
import example_floodit.FlooditMainGui;
import example_floodit.FlooditState;

/**
 *
 * @author BigEma
 */
public class FlooditGame {
    private GaroePlaygroundController mainController;
    
    public FlooditGame(GaroePlaygroundController mainController) {
        this.mainController = mainController;
    }
    
    
    public void start() {
        FlooditMainGui mainWindow = new FlooditMainGui();
		FlooditState gameState = new FlooditState();
        gameState.setGeneratorMode(FlooditState.REDUCED_BY_CONTEXT_MODE);
		gameState.populateBoard();
		FlooditController controller = new FlooditController(mainWindow, gameState);
		controller.setMainController(mainController);
        controller.show();
    }
}
