package example_floodit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FlooditController implements ActionListener{
	private FlooditMainGui gui;
	private FlooditState model;
	
	public FlooditController(FlooditMainGui gui, FlooditState model) {
		this.gui = gui;
		this.model = model;
	}
	
	public void changeModel(FlooditState newModel) {
		this.model = newModel;
	}
	
	public void show() {
		this.gui.setVisible(true);
		this.gui.setListenerButtons(this);
		this.gui.update(model);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();
		boolean update = false;
		if (source instanceof JButton) {
			String color = ((JButton) source).getText();
			if (color.compareTo("verde") == 0) {
				model.changeColor(FlooditState.verde);
			} else if (color.compareTo("azul") == 0) {
				model.changeColor(FlooditState.azul);
			} else if (color.compareTo("rojo") == 0) {
				model.changeColor(FlooditState.rojo);
			} else if (color.compareTo("amarillo") == 0) {
				model.changeColor(FlooditState.amarillo);
			} else if (color.compareTo("celeste") == 0) {
				model.changeColor(FlooditState.celeste);
			} else if (color.compareTo("rosa") == 0) {
				model.changeColor(FlooditState.rosa);
			}
			update = true;
		} else if (this.gui.getExitMenuItem() == source) {
			this.gui.setVisible(false);
			this.gui.dispose();
			System.exit(0);
		} else if (this.gui.getNewGameMenuItem() == source) {
			this.model = new FlooditState();
			this.model.populateBoard();
			this.gui.enableButtons(true);
			update = true;
		} else if (this.gui.getAboutMenuItem() == source) {
			AboutFloodit about = new AboutFloodit(this.gui, true);
			about.setVisible(true);
		} else if (this.gui.getPistaMenuItem() == source) {
			IAController iaController = new IAController(this.gui, new IAGui(), this, this.model);
			if (iaController.runSearchEngine()) {
				iaController.markNextMove();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}
		} else if (this.gui.getJugarMenuItem() == source) {
			IAController iaController = new IAController(this.gui, new IAGui(), this, this.model);
			if (iaController.runSearchEngine()) {
				iaController.show();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}
		}
		if (update) {
			this.gui.update(model);
		}
	}

}
