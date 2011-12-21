package example_waterjars;

import example_floodit.*;

/**
 * Aplicación principal para el ejemplo del Floodit
 * @author Carla Noelia Fiori, Simón Emmanuel Gutiérrez Brida
 * @version 0.1
 */
public class WaterJarsApp_gui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WaterJarsApp_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaterJarsApp_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaterJarsApp_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaterJarsApp_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		WaterJarsGUI mainWindow = new WaterJarsGUI();
		WaterJarsState gameState = new WaterJarsState();
		WaterJarsMainController controller = new WaterJarsMainController(gameState, mainWindow);
        mainWindow.setMainController(controller);
		controller.show();
	}

}
