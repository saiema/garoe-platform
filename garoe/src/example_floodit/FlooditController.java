package example_floodit;

import examples.GaroePlaygroundController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Controlador para la interfaz principal del Floodit
 * @author Carla Noelia Fiori, Simón Emmanuel Gutiérrez Brida
 * @version 0.1
 */
public class FlooditController implements ActionListener{
	private FlooditMainGui gui;
	private FlooditState model;
    private boolean standAlone = true;
    private GaroePlaygroundController mainController = null;
    private int difficulty = 0;
	
    /**
     * Constructor de la clase
     * @param gui : la interfaz gráfica con la cual trabaja el controlador : {@code FlooditMainGui}
     * @param model : el modelo que utiliza el controlador para manejar el estado del juego : {@code FlooditState}
     */
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
            if (this.difficulty == 0) {
                this.model.easy();
            } else if (this.difficulty == 1) {
                this.model.medium();
            } else if (this.difficulty == 2) {
                this.model.hard();
            }
			this.model.populateBoard();
			this.gui.enableButtons(true);
			update = true;
		} else if (this.gui.getAboutMenuItem() == source) {
			AboutFloodit about = new AboutFloodit(this.gui, true);
			about.setVisible(true);
		} else if (this.gui.getPistaMenuItem() == source) {
            IAGui iaGui = new IAGui();
            IAController iaController = new IAController(this.gui, iaGui, this, this.model);
            iaGui.setController(iaController);
			if (iaController.search()) {
				iaController.hint();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}
		} else if (this.gui.getJugarMenuItem() == source) {
            IAGui iaGui = new IAGui();
            IAController iaController = new IAController(this.gui, iaGui, this, this.model);
            iaGui.setController(iaController);
			if (iaController.search()) {
				iaController.showGui();
			} else {
				System.out.println("NO SE PUEDE GANAR EN MENOS DE 25 MOVIMIENTOS");
			}
		} else if (this.gui.getEasyDifficulty() == source) {
            this.difficulty = 0;
            this.model = new FlooditState();
            this.model.easy();
			this.model.populateBoard();
			this.gui.enableButtons(true);
            update = true;
        } else if (this.gui.getMediumDifficulty() == source) {
            this.difficulty = 1;
            this.model = new FlooditState();
            this.model.medium();
			this.model.populateBoard();
			this.gui.enableButtons(true);
            update = true;
        } else if (this.gui.getHardDifficulty() == source) {
            this.difficulty = 2;
            this.model = new FlooditState();
            this.model.hard();
			this.model.populateBoard();
			this.gui.enableButtons(true);
            update = true;
        }
		if (update) {
            cleanButtons();
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
