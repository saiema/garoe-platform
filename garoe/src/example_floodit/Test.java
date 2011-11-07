package example_floodit;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*FlooditState test = new FlooditState();
		test.populateBoard();
		System.out.println(test.toString());*/
		FlooditMainAppGui mainWindow = new FlooditMainAppGui();
		FlooditState gameState = new FlooditState();
		gameState.populateBoard();
		FlooditController controller = new FlooditController(mainWindow, gameState);
		controller.show();
		//mainWindow.setVisible(true);
	}

}
