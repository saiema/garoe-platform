package example_floodit;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class IAGui extends javax.swing.JDialog {
	private JPanel buttonsPanel;
	private JButton autoPlay;
	private JButton nextMove;
	private JList moveList;
	private JButton exit;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new IAGui());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public IAGui() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(366, 291));
			this.setEnabled(true);
			this.setName("moves");
			this.setResizable(false);
			this.setSize(366, 291);
	{
		buttonsPanel = new JPanel();
		TableLayout buttonsPanelLayout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL}});
		buttonsPanelLayout.setHGap(5);
		buttonsPanelLayout.setVGap(5);
		buttonsPanel.setLayout(buttonsPanelLayout);
		this.add(getButtonsPanel(), BorderLayout.SOUTH);
		buttonsPanel.setPreferredSize(new java.awt.Dimension(20, 20));
		{
			autoPlay = new JButton();
			buttonsPanel.add(getAutoPlay(), "0, 0");
			autoPlay.setText("auto");
		}
		{
			nextMove = new JButton();
			buttonsPanel.add(getNextMove(), "1, 0");
			nextMove.setText("next");
		}
		{
			exit = new JButton();
			buttonsPanel.add(getExit(), "2, 0");
			exit.setText("exit");
		}
	}
	{
		ListModel moveListModel = 
				new DefaultComboBoxModel(
						new String[] { "Item One", "Item Two" });
		moveList = new JList();
		getContentPane().add(moveList, BorderLayout.NORTH);
		moveList.setModel(moveListModel);
		moveList.setPreferredSize(new java.awt.Dimension(400, 258));
		moveList.setMinimumSize(new java.awt.Dimension(350, 256));
		moveList.setMaximumSize(new java.awt.Dimension(380, 256));
	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}
	
	public JButton getAutoPlay() {
		return autoPlay;
	}
	
	public JButton getNextMove() {
		return nextMove;
	}
	
	public JButton getExit() {
		return exit;
	}
	
	public JList getMoveList() {
		return moveList;
	}
	
	public void setListenerButtons(ActionListener lis) {
		this.autoPlay.addActionListener(lis);
		this.nextMove.addActionListener(lis);
		this.exit.addActionListener(lis);
	}

}
