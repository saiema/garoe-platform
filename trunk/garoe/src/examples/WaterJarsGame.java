/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import example_waterjars.WaterJarsGUI;
import example_waterjars.WaterJarsMainController;
import example_waterjars.WaterJarsState;

/**
 *
 * @author BigEma
 */
public class WaterJarsGame {
    private GaroePlaygroundController mainController;
    
    public WaterJarsGame(GaroePlaygroundController mainController) {
        this.mainController = mainController;
    }
    
    
    public void start() {
        WaterJarsGUI mainWindow = new WaterJarsGUI();
		WaterJarsState gameState = new WaterJarsState();
		WaterJarsMainController controller = new WaterJarsMainController(gameState, mainWindow);
        mainWindow.setMainController(controller);
		controller.setMainController(mainController);
        controller.show();
    }
}
