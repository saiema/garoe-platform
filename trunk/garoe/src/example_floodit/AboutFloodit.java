package example_floodit;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
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
public class AboutFloodit extends javax.swing.JDialog {
	private JTextArea aboutText;
	private String infoText;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				AboutFloodit inst = new AboutFloodit(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public AboutFloodit(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				infoText = "Floodit ver 0.1 alfa\nAutores:\nCarla Noelia Fiori  Simón Emmanuel Gutiérrez Brida\nFecha:27/10/2011\n\n\nAgracedimientos: A todos los tajaritos de tolores en sus tarbolitos\n";
				aboutText = new JTextArea();
				getContentPane().add(getAboutText(), BorderLayout.CENTER);
				aboutText.setText(infoText);
				aboutText.setEditable(false);
			}
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JTextArea getAboutText() {
		return aboutText;
	}

}
