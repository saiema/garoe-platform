package example_floodit;

public class FlodditApp_gui {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
