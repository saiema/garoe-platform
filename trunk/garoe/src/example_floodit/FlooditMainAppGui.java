package example_floodit;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class FlooditMainAppGui extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JMenuItem iaPlayMenuItem;
	private JMenuItem pistaMenuItem;
	private JMenu IAmenu;
	private JTable board;
	private JButton button6;
	private JButton button5;
	private JButton button4;
	private JButton button3;
	private JButton button2;
	private JButton button1;
	private JPanel buttonsPanel;
	private JLabel steps;
	private JPanel mainPanel;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;

	/**
	* Auto-generated main method to display this JFrame
	*/
		
	public FlooditMainAppGui() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				this.setResizable(false);
			}
			{
				mainPanel = new JPanel();
				TableLayout mainPanelLayout = new TableLayout(new double[][] {{93.0, TableLayout.FILL}, {45.0, TableLayout.FILL}});
				mainPanelLayout.setHGap(5);
				mainPanelLayout.setVGap(5);
				getContentPane().add(getMainPanel(), BorderLayout.CENTER);
				mainPanel.setLayout(mainPanelLayout);
				{
					steps = new JLabel();
					mainPanel.add(getSteps(), "0,0,c,f");
					steps.setText("XXX");
				}}
		{
			buttonsPanel = new JPanel();
			TableLayout buttonsPanelLayout = new TableLayout(new double[][] {{93.0, TableLayout.FILL}, {30.0, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
			buttonsPanelLayout.setHGap(5);
			buttonsPanelLayout.setVGap(5);
			buttonsPanel.setLayout(buttonsPanelLayout);
			mainPanel.add(buttonsPanel, "0,1,f,f");
			{
				button1 = new JButton();
				buttonsPanel.add(getButton1(), "0, 0");
				button1.setText("azul");
			}
			{
				button2 = new JButton();
				buttonsPanel.add(getButton2(), "0, 1");
				button2.setText("verde");
			}
			{
				button3 = new JButton();
				buttonsPanel.add(getButton3(), "0, 2");
				button3.setText("rojo");
			}
			{
				button4 = new JButton();
				buttonsPanel.add(getButton4(), "0, 3");
				button4.setText("amarillo");
			}
			{
				button5 = new JButton();
				buttonsPanel.add(getButton5(), "0, 4");
				button5.setText("celeste");
			}
			{
				button6 = new JButton();
				buttonsPanel.add(getButton6(), "0, 5");
				button6.setText("rosa");
			}
		}
		{
			TableModel boardModel = 
					new DefaultTableModel(
							new String[14][14],
							new String[14]);
			board = new JTable();
			mainPanel.add(board, "1, 1");
			board.setModel(boardModel);
			board.setDefaultRenderer(Object.class, new BoardRender());
		}

			{
			}
			this.setSize(400, 322);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("New");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("About");
					}
				}
				{
					IAmenu = new JMenu();
					jMenuBar1.add(getIAmenu());
					IAmenu.setText("IA");
					{
						pistaMenuItem = new JMenuItem();
						IAmenu.add(getPistaMenuItem());
						pistaMenuItem.setText("pista");}
					{
						iaPlayMenuItem = new JMenuItem();
						IAmenu.add(getIaPlayMenuItem());
						iaPlayMenuItem.setText("jugar");
					}
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public JPanel getMainPanel() {
		return mainPanel;
	}
	
	public JLabel getSteps() {
		return steps;
	}
	
	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}
	
	public JButton getButton1() {
		return button1;
	}
	
	public JButton getButton2() {
		return button2;
	}
	
	
	public JButton getButton3() {
		return button3;
	}
	
	public JButton getButton4() {
		return button4;
	}
	
	public JButton getButton5() {
		return button5;
	}
	
	public JButton getButton6() {
		return button6;
	}
	
	public JTable getBoard() {
		return board;
	}
	
	public void update(FlooditState model) {
		//System.out.println("ENTRE A UPDATE");
		for (int row = 0; row<model.getSize();row++) {
			for (int col = 0; col<model.getSize();col++) {
				if (model.getColorOfToken(row, col) == FlooditState.verde) {
					this.board.setValueAt("verde", row, col);
				} else if (model.getColorOfToken(row, col) == FlooditState.amarillo) {
					this.board.setValueAt("amarillo", row, col);
				} else if (model.getColorOfToken(row, col) == FlooditState.rojo) {
					this.board.setValueAt("rojo", row, col);
				} else if (model.getColorOfToken(row, col) == FlooditState.azul) {
					this.board.setValueAt("azul", row, col);
				} else if (model.getColorOfToken(row, col) == FlooditState.celeste) {
					this.board.setValueAt("celeste", row, col);
				} else if (model.getColorOfToken(row, col) == FlooditState.rosa) {
					this.board.setValueAt("rosa", row, col);
				}
			}
		}
		//System.out.println("PASO HECHOS : " + model.getSteps());
		this.steps.setText(Integer.toString(model.getSteps()));
		if (model.success()) {
			WinLoseWindow winWindow = new WinLoseWindow(this);
			winWindow.getWinLoseMsg().setText("  WOW!...\nGANASTE!");
			winWindow.getSteps().setText(Integer.toString(model.getSteps()));
			winWindow.getIcon().setIcon(new ImageIcon("win120x120.jpg"));
			winWindow.setVisible(true);
			enableButtons(false);
		} else if (model.isFinal()) {
			WinLoseWindow loseWindow = new WinLoseWindow(this);
			loseWindow.getWinLoseMsg().setText("  UPS...\nPERDISTE!");
			loseWindow.getSteps().setText(Integer.toString(model.getSteps()));
			loseWindow.getIcon().setText("");
			loseWindow.getIcon().setIcon(new ImageIcon("lose120x120.png"));
			loseWindow.setVisible(true);
			enableButtons(false);
		}
	}
	
	public void enableButtons(boolean enable) {
		this.button1.setEnabled(enable);
		this.button2.setEnabled(enable);
		this.button3.setEnabled(enable);
		this.button4.setEnabled(enable);
		this.button5.setEnabled(enable);
		this.button6.setEnabled(enable);
	}
	
	public void setListenerButtons(ActionListener lis) {
		this.button1.addActionListener(lis);
		this.button2.addActionListener(lis);
		this.button3.addActionListener(lis);
		this.button4.addActionListener(lis);
		this.button5.addActionListener(lis);
		this.button6.addActionListener(lis);
		this.newFileMenuItem.addActionListener(lis);
		this.exitMenuItem.addActionListener(lis);
		this.helpMenuItem.addActionListener(lis);
		this.iaPlayMenuItem.addActionListener(lis);
		this.pistaMenuItem.addActionListener(lis);
	}

	/**
	 * @return the helpMenuItem
	 */
	protected JMenuItem getHelpMenuItem() {
		return helpMenuItem;
	}

	/**
	 * @return the exitMenuItem
	 */
	protected JMenuItem getExitMenuItem() {
		return exitMenuItem;
	}

	/**
	 * @return the newFileMenuItem
	 */
	protected JMenuItem getNewFileMenuItem() {
		return newFileMenuItem;
	}
	
	public JMenu getIAmenu() {
		return IAmenu;
	}
	
	public JMenuItem getPistaMenuItem() {
		return pistaMenuItem;
	}
	
	public JMenuItem getIaPlayMenuItem() {
		return iaPlayMenuItem;
	}

}
