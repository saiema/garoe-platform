package example_reversi;
import info.clearthought.layout.TableLayout;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import utils.Pair;


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
public class ReversiGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton board00;
	private JButton board01;
	private JButton board02;
	private JButton board03;
	private JButton board04;
	private JButton board05;
	private JButton board06;
	private JButton board07;
	private JButton board10;
	private JButton board11;
	private JButton board12;
	private JButton board13;
	private JButton board14;
	private JButton board15;
	private JButton board16;
	private JButton board17;
	private JButton board20;
	private JButton board21;
	private JButton board22;
	private JButton board23;
	private JButton board24;
	private JButton board25;
	private JButton board26;
	private JButton board27;
	private JButton board30;
	private JButton board31;
	private JButton board32;
	private JButton board33;
	private JButton board34;
	private JButton board35;
	private JButton board36;
	private JButton board37;
	private JButton board40;
	private JButton board41;
	private JButton board42;
	private JButton board43;
	private JButton board44;
	private JButton board45;
	private JButton board46;
	private JButton board47;
	private JButton board50;
	private JButton board51;
	private JButton board52;
	private JButton board53;
	private JButton board54;
	private JButton board55;
	private JButton board56;
	private JButton board57;
	private JButton board60;
	private JButton board61;
	private JButton board62;
	private JButton board63;
	private JButton board64;
	private JButton board65;
	private JButton board66;
	private JButton board67;
	private JButton board70;
	private JButton board71;
	private JButton board72;
	private JButton board73;
	private JButton board74;
	private JButton board75;
	private JButton board76;
	private JButton board77;
	protected JButton[][] buttons;
	protected ImageIcon whiteToken;
	protected ImageIcon blackToken;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ReversiGUI inst = new ReversiGUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ReversiGUI() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			buttons = new JButton[8][8];
			whiteToken = new ImageIcon("token_white.png");
			blackToken = new ImageIcon("token_black.png");
			TableLayout thisLayout = new TableLayout(new double[][] {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}});
			thisLayout.setHGap(5);
			thisLayout.setVGap(5);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				board00 = new JButton();
				getContentPane().add(board00, "0, 0");
				board00.setText("00");
				board00.setEnabled(false);
				buttons[0][0] = board00;
			}
			{
				board01 = new JButton();
				getContentPane().add(board01, "1, 0");
				board01.setText("01");
				board01.setEnabled(false);
				buttons[0][1] = board01;
			}
			{
				board02 = new JButton();
				getContentPane().add(board02, "2, 0");
				board02.setText("02");
				board02.setEnabled(false);
				buttons[0][2] = board02;
			}
			{
				board03 = new JButton();
				getContentPane().add(board03, "3, 0");
				board03.setText("03");
				board03.setEnabled(false);
				buttons[0][3] = board03;
			}
			{
				board04 = new JButton();
				getContentPane().add(board04, "4, 0");
				board04.setText("04");
				board04.setEnabled(false);
				buttons[0][4] = board04;
			}
			{
				board05 = new JButton();
				getContentPane().add(board05, "5, 0");
				board05.setText("05");
				board05.setEnabled(false);
				buttons[0][5] = board05;
			}
			{
				board06 = new JButton();
				getContentPane().add(board06, "6, 0");
				board06.setText("06");
				board06.setEnabled(false);
				buttons[0][6] = board06;
			}
			{
				board07 = new JButton();
				getContentPane().add(board07, "7, 0");
				board07.setText("07");
				board07.setEnabled(false);
				buttons[0][7] = board07;
			}
			{
				board10 = new JButton();
				getContentPane().add(board10, "0, 1");
				board10.setText("10");
				board10.setEnabled(false);
				buttons[1][0] = board10;
			}
			{
				board11 = new JButton();
				getContentPane().add(board11, "1, 1");
				board11.setText("11");
				board11.setEnabled(false);
				buttons[1][1] = board11;
			}
			{
				board12 = new JButton();
				getContentPane().add(board12, "2, 1");
				board12.setText("12");
				board12.setEnabled(false);
				buttons[1][2] = board12;
			}
			{
				board13 = new JButton();
				getContentPane().add(board13, "3, 1");
				board13.setText("13");
				board13.setEnabled(false);
				buttons[1][3] = board13;
			}
			{
				board14 = new JButton();
				getContentPane().add(board14, "4, 1");
				board14.setText("14");
				board14.setEnabled(false);
				buttons[1][4] = board14;
			}
			{
				board15 = new JButton();
				getContentPane().add(board15, "5, 1");
				board15.setText("15");
				board15.setEnabled(false);
				buttons[1][5] = board15;
			}
			{
				board16 = new JButton();
				getContentPane().add(board16, "6, 1");
				board16.setText("16");
				board16.setEnabled(false);
				buttons[1][6] = board16;
			}
			{
				board17 = new JButton();
				getContentPane().add(board17, "7, 1");
				board17.setText("17");
				board17.setEnabled(false);
				buttons[1][7] = board17;
			}
			{
				board20 = new JButton();
				getContentPane().add(board20, "0, 2");
				board20.setText("20");
				board20.setEnabled(false);
				buttons[2][0] = board20;
			}
			{
				board21 = new JButton();
				getContentPane().add(board21, "1, 2");
				board21.setText("21");
				board21.setEnabled(false);
				buttons[2][1] = board21;
			}
			{
				board22 = new JButton();
				getContentPane().add(board22, "2, 2");
				board22.setText("22");
				board22.setEnabled(false);
				buttons[2][2] = board22;
			}
			{
				board23 = new JButton();
				getContentPane().add(board23, "3, 2");
				board23.setText("23");
				board23.setEnabled(false);
				buttons[2][3] = board23;
			}
			{
				board24 = new JButton();
				getContentPane().add(board24, "4, 2");
				board24.setText("24");
				board24.setEnabled(false);
				buttons[2][4] = board24;
			}
			{
				board25 = new JButton();
				getContentPane().add(board25, "5, 2");
				board25.setText("25");
				board25.setEnabled(false);
				buttons[2][5] = board25;
			}
			{
				board26 = new JButton();
				getContentPane().add(board26, "6, 2");
				board26.setText("26");
				board26.setEnabled(false);
				buttons[2][6] = board26;
			}
			{
				board27 = new JButton();
				getContentPane().add(board27, "7, 2");
				board27.setText("27");
				board27.setEnabled(false);
				buttons[2][7] = board27;
			}
			{
				board30 = new JButton();
				getContentPane().add(board30, "0, 3");
				board30.setText("30");
				board30.setEnabled(false);
				buttons[3][0] = board30;
			}
			{
				board31 = new JButton();
				getContentPane().add(board31, "1, 3");
				board31.setText("31");
				board31.setEnabled(false);
				buttons[3][1] = board31;
			}
			{
				board32 = new JButton();
				getContentPane().add(board32, "2, 3");
				board32.setText("32");
				board32.setEnabled(false);
				buttons[3][2] = board32;
			}
			{
				board33 = new JButton();
				getContentPane().add(board33, "3, 3");
				board33.setText("33");
				board33.setEnabled(false);
				buttons[3][3] = board33;
			}
			{
				board34 = new JButton();
				getContentPane().add(board34, "4, 3");
				board34.setText("34");
				board34.setEnabled(false);
				buttons[3][4] = board34;
			}
			{
				board35 = new JButton();
				getContentPane().add(board35, "5, 3");
				board35.setText("35");
				board35.setEnabled(false);
				buttons[3][5] = board35;
			}
			{
				board36 = new JButton();
				getContentPane().add(board36, "6, 3");
				board36.setText("36");
				board36.setEnabled(false);
				buttons[3][6] = board36;
			}
			{
				board37 = new JButton();
				getContentPane().add(board37, "7, 3");
				board37.setText("37");
				board37.setEnabled(false);
				buttons[3][7] = board37;
			}
			{
				board40 = new JButton();
				getContentPane().add(board40, "0, 4");
				board40.setText("40");
				board40.setEnabled(false);
				buttons[4][0] = board40;
			}
			{
				board41 = new JButton();
				getContentPane().add(board41, "1, 4");
				board41.setText("41");
				board41.setEnabled(false);
				buttons[4][1] = board41;
			}
			{
				board42 = new JButton();
				getContentPane().add(board42, "2, 4");
				board42.setText("42");
				board42.setEnabled(false);
				buttons[4][2] = board42;
			}
			{
				board43 = new JButton();
				getContentPane().add(board43, "3, 4");
				board43.setText("43");
				board43.setEnabled(false);
				buttons[4][3] = board43;
			}
			{
				board44 = new JButton();
				getContentPane().add(board44, "4, 4");
				board44.setText("44");
				board44.setEnabled(false);
				buttons[4][4] = board44;
			}
			{
				board45 = new JButton();
				getContentPane().add(board45, "5, 4");
				board45.setText("45");
				board45.setEnabled(false);
				buttons[4][5] = board45;
			}
			{
				board46 = new JButton();
				getContentPane().add(board46, "6, 4");
				board46.setText("46");
				board46.setEnabled(false);
				buttons[4][6] = board46;
			}
			{
				board47 = new JButton();
				getContentPane().add(board47, "7, 4");
				board47.setText("47");
				board47.setEnabled(false);
				buttons[4][7] = board47;
			}
			{
				board50 = new JButton();
				getContentPane().add(board50, "0, 5");
				board50.setText("50");
				board50.setEnabled(false);
				buttons[5][0] = board50;
			}
			{
				board51 = new JButton();
				getContentPane().add(board51, "1, 5");
				board51.setText("51");
				board51.setEnabled(false);
				buttons[5][1] = board51;
			}
			{
				board52 = new JButton();
				getContentPane().add(board52, "2, 5");
				board52.setText("52");
				board52.setEnabled(false);
				buttons[5][2] = board52;
			}
			{
				board53 = new JButton();
				getContentPane().add(board53, "3, 5");
				board53.setText("53");
				board53.setEnabled(false);
				buttons[5][3] = board53;
			}
			{
				board54 = new JButton();
				getContentPane().add(board54, "4, 5");
				board54.setText("54");
				board54.setEnabled(false);
				buttons[5][4] = board54;
			}
			{
				board55 = new JButton();
				getContentPane().add(board55, "5, 5");
				board55.setText("55");
				board55.setEnabled(false);
				buttons[5][5] = board55;
			}
			{
				board56 = new JButton();
				getContentPane().add(board56, "6, 5");
				board56.setText("56");
				board56.setEnabled(false);
				buttons[5][6] = board56;
			}
			{
				board57 = new JButton();
				getContentPane().add(board57, "7, 5");
				board57.setText("57");
				board57.setEnabled(false);
				buttons[5][7] = board57;
			}
			{
				board60 = new JButton();
				getContentPane().add(board60, "0, 6");
				board60.setText("60");
				board60.setEnabled(false);
				buttons[6][0] = board60;
			}
			{
				board61 = new JButton();
				getContentPane().add(board61, "1, 6");
				board61.setText("61");
				board61.setEnabled(false);
				buttons[6][1] = board61;
			}
			{
				board62 = new JButton();
				getContentPane().add(board62, "2, 6");
				board62.setText("62");
				board62.setEnabled(false);
				buttons[6][2] = board62;
			}
			{
				board63 = new JButton();
				getContentPane().add(board63, "3, 6");
				board63.setText("63");
				board63.setEnabled(false);
				buttons[6][3] = board63;
			}
			{
				board64 = new JButton();
				getContentPane().add(board64, "4, 6");
				board64.setText("64");
				board64.setEnabled(false);
				buttons[6][4] = board64;
			}
			{
				board65 = new JButton();
				getContentPane().add(board65, "5, 6");
				board65.setText("65");
				board65.setEnabled(false);
				buttons[6][5] = board65;
			}
			{
				board66 = new JButton();
				getContentPane().add(board66, "6, 6");
				board66.setText("66");
				board66.setEnabled(false);
				buttons[6][6] = board66;
			}
			{
				board67 = new JButton();
				getContentPane().add(board67, "7, 6");
				board67.setText("67");
				board67.setEnabled(false);
				buttons[6][7] = board67;
			}
			{
				board70 = new JButton();
				getContentPane().add(board70, "0, 7");
				board70.setText("70");
				board70.setEnabled(false);
				buttons[7][0] = board70;
			}
			{
				board71 = new JButton();
				getContentPane().add(board71, "1, 7");
				board71.setText("71");
				board71.setEnabled(false);
				buttons[7][1] = board71;
			}
			{
				board72 = new JButton();
				getContentPane().add(board72, "2, 7");
				board72.setText("72");
				board72.setEnabled(false);
				buttons[7][2] = board72;
			}
			{
				board73 = new JButton();
				getContentPane().add(board73, "3, 7");
				board73.setText("73");
				board73.setEnabled(false);
				buttons[7][3] = board73;
			}
			{
				board74 = new JButton();
				getContentPane().add(board74, "4, 7");
				board74.setText("74");
				board74.setEnabled(false);
				buttons[7][4] = board74;
			}
			{
				board75 = new JButton();
				getContentPane().add(board75, "5, 7");
				board75.setText("75");
				board75.setEnabled(false);
				buttons[7][5] = board75;
			}
			{
				board76 = new JButton();
				getContentPane().add(board76, "6, 7");
				board76.setText("76");
				board76.setEnabled(false);
				buttons[7][6] = board76;
			}
			{
				board77 = new JButton();
				getContentPane().add(board77, "7, 7");
				board77.setText("77");
				board77.setEnabled(false);
				buttons[7][7] = board77;
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void changeBoard(ReversiState state) {
		int r = 0;
		int c = 0;
		for (ReversiToken[] row : state.getBoard()) {
			for (ReversiToken token : row) {
				JButton button = getButtonByCoord(r,c);
				if (token != null) {
					changeButton(button,token.getColor() == ReversiToken.WHITE?this.whiteToken:this.blackToken);
				}
				button.setEnabled(false);
				c = (c == 7)?0:c + 1;
			}
			r = (r == 7)?0:r + 1;
		}
		for (Pair<Integer,Integer> am : state.isMax()?state.whiteAvailableMoves:state.blackAvailableMoves) {
			JButton button = getButtonByCoord(am.getFirstElem(),am.getSecondElem());
			button.setEnabled(true);
		}
	}
	
	public void changeButton(int c, int r, Icon icon, boolean enable) {
		JButton button = getButtonByCoord(r,c);
		button.setText("");
		button.setDisabledIcon(icon);
		button.setIcon(icon);
		button.setEnabled(enable);
		
	}
	
	private void changeButton(JButton button, Icon icon) {
		button.setText("");
		button.setDisabledIcon(icon);
		button.setIcon(icon);
	}
	
	private JButton getButtonByCoord(int r, int c) {
		return buttons[r][c];
	}
	
	public void setListenerButtons(ActionListener lis) {
		for (JButton[] row : buttons) {
			for (JButton button : row) {
				button.addActionListener(lis);
			}
		}
	}

}
