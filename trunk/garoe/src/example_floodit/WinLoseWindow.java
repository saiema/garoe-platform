package example_floodit;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


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
public class WinLoseWindow extends javax.swing.JDialog {
	private JPanel mainPanel;
	private JTextArea WinLoseMsg;
	private JLabel icon;
	private JLabel steps;
	private JLabel stepsMade;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				WinLoseWindow inst = new WinLoseWindow(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public WinLoseWindow(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setResizable(false);
			}
			{
				mainPanel = new JPanel();
				TableLayout mainPanelLayout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL}});
				mainPanelLayout.setHGap(5);
				mainPanelLayout.setVGap(5);
				mainPanel.setLayout(mainPanelLayout);
				getContentPane().add(getMainPanel(), BorderLayout.CENTER);
				{
					WinLoseMsg = new JTextArea();
					mainPanel.add(getWinLoseMsg(), "1,0,f,f");
					WinLoseMsg.setText("Win" + '\n' + "Lose");
					WinLoseMsg.setFont(new java.awt.Font("Zapfino",3,12));
					WinLoseMsg.setOpaque(false);
					WinLoseMsg.setEditable(false);
				}
				{
					stepsMade = new JLabel();
					mainPanel.add(getStepsMade(), "2,0,c,t");
					stepsMade.setText("Steps made ");
					stepsMade.setFont(new java.awt.Font("Courier New",1,14));
				}
				{
					steps = new JLabel();
					mainPanel.add(getSteps(), "2,0,c,c");
					steps.setText("XXX");
					steps.setFont(new java.awt.Font("Brush Script MT",1,24));
				}
				{
					icon = new JLabel();
					mainPanel.add(getIcon(), "0,0,c,c");
					icon.setText("N/A");
				}
			}
			this.setSize(390, 137);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	public JTextArea getWinLoseMsg() {
		return WinLoseMsg;
	}
	
	public JLabel getStepsMade() {
		return stepsMade;
	}
	
	public JLabel getSteps() {
		return steps;
	}
	
	public JLabel getIcon() {
		return icon;
	}

}
