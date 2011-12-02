package example_floodit;

public class FlodditApp_gui {

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
            java.util.logging.Logger.getLogger(NewWinLoseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewWinLoseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewWinLoseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewWinLoseWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		/*FlooditState test = new FlooditState();
		test.populateBoard();
		System.out.println(test.toString());*/
		FlooditMainGui mainWindow = new FlooditMainGui();
		FlooditState gameState = new FlooditState();
        gameState.setGeneratorMode(FlooditState.REDUCED_BY_CONTEXT_MODE);
		gameState.populateBoard();
		FlooditController controller = new FlooditController(mainWindow, gameState);
		controller.show();
		//mainWindow.setVisible(true);
	}

}
