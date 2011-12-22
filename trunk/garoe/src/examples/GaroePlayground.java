/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author BigEma
 */
public class GaroePlayground {
    
    public static void main(String[] args) {
        GaroePlaygroundGUI gui = new GaroePlaygroundGUI();
        GaroePlaygroundController controller = new GaroePlaygroundController(gui);
        gui.setController(controller);
        controller.startMainGUI();
    }

}
