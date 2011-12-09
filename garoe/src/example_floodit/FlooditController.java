package example_floodit;

import examples.GaroePlaygroundController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FlooditController implements ActionListener{
	private FlooditMainGui gui;
	private FlooditState model;
    private boolean gameExited = false;
    private boolean standAlone = true;
    private GaroePlaygroundController mainController = null;
	
	public FlooditController(FlooditMainGui gui, FlooditState model) {
		this.gui = gui;
		this.model = model;
	}
    
    public void setMainController(GaroePlaygroundController mainController) {
        if (mainController != null) {
            this.standAlone = false;
            this.mainController = mainController;
        } else {
            this.standAlone = true;
            this.mainController = null;
        }
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
            cleanButtons();
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
			exit();
		} else if (this.gui.getNewGameMenuItem() == source) {
			this.model = new FlooditState();
            this.model.setGeneratorMode(FlooditState.REDUCED_BY_CONTEXT_MODE);
			this.model.populateBoard();
			this.gui.enableButtons(true);
			update = true;
		} else if (this.gui.getAboutMenuItem() == source) {
			AboutFloodit about = new AboutFloodit(this.gui, true);
			about.setVisible(true);
		} else if (this.gui.getPistaMenuItem() == source) {
			/*IAController iaController = new IAController(this.gui, new IAGui(), this, this.model);
			if (iaController.runSearchEngine()) {
				iaController.markNextMove();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}*/
            IAGui iaGui = new IAGui();
            IAController iaController = new IAController(this.gui, iaGui, this, this.model);
            iaGui.setController(iaController);
			if (iaController.search()) {
				iaController.hint();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}
		} else if (this.gui.getJugarMenuItem() == source) {
			/*IAController iaController = new IAController(this.gui, new IAGui(), this, this.model);
			if (iaController.runSearchEngine()) {
				iaController.show();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}*/
            IAGui iaGui = new IAGui();
            IAController iaController = new IAController(this.gui, iaGui, this, this.model);
            iaGui.setController(iaController);
			if (iaController.search()) {
				iaController.showGui();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}
		}
		if (update) {
			this.gui.update(model);
		}
	}
    
    private void cleanButtons() {
        this.gui.getBotonAmarillo().setBackground(null);
        this.gui.getBotonAzul().setBackground(null);
        this.gui.getBotonCeleste().setBackground(null);
        this.gui.getBotonRojo().setBackground(null);
        this.gui.getBotonRosa().setBackground(null);
        this.gui.getBotonVerde().setBackground(null);
    }

    private void exit() {
        if (this.standAlone) {
            System.exit(0);
        } else {
            this.gui.setEnabled(false);
            this.gui.setVisible(false);
            this.gui.dispose();
            this.mainController.startMainGUI();
        }
    }
    

}
