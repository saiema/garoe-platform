package example_floodit;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import engine_framework.IRule;
import engine_framework.SearchProblem;
import engines.GuidedDepthFirstSearchEngine;

public class IAController implements ActionListener {
	private FlooditController mainController;
	private FlooditMainGui mainGui;
	private IAGui iaGui;
	private FlooditState model;
	private GuidedDepthFirstSearchEngine<FlooditState> searchEngine;
	private List<FlooditState> moves;
	
	public IAController (FlooditMainGui mainGui, IAGui iaGui, FlooditController mainController, FlooditState model) {
		this.mainGui = mainGui;
		this.iaGui = iaGui;
		this.model = model;
		this.mainController = mainController;
		List<IRule<FlooditState>> rules = new LinkedList<IRule<FlooditState>>();
		rules.add(new FlooditMoveRule());
		SearchProblem<FlooditState> problem = new SearchProblem<FlooditState>(model,rules);
		this.searchEngine = new GuidedDepthFirstSearchEngine<FlooditState>(problem);
		this.iaGui.setListenerButtons(this);
	}
	
	public void show() {
		this.mainGui.setFocusable(false);
		this.mainGui.setEnabled(false);
		List<String> moves = new LinkedList<String>();
		for (FlooditState move : this.moves) {
			int color = move.getColorOfToken(0, 0);
			if (color == FlooditState.azul) {
				moves.add("azul");
			} else if (color == FlooditState.verde) {
				moves.add("verde");
			} else if (color == FlooditState.rojo) {
				moves.add("rojo");
			} else if (color == FlooditState.amarillo) {
				moves.add("amarillo");
			} else if (color == FlooditState.celeste) {
				moves.add("celeste");
			} else if (color == FlooditState.rosa) {
				moves.add("rosa");
			}
		}
		this.iaGui.getMoveList().setListData(moves.toArray());
		this.iaGui.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (this.iaGui.getNextMove() == source) {
			if (!this.moves.isEmpty()) {
				this.model.changeColor(this.moves.get(this.moves.size()-1).getColorOfToken(0, 0));
				this.moves.remove(this.moves.size()-1);
				this.iaGui.getMoveList().setListData(this.moves.toArray());
				this.mainGui.update(this.model);
				this.mainController.changeModel(this.model);
			} else {
				this.iaGui.getNextMove().setEnabled(false);
				this.iaGui.getAutoPlay().setEnabled(false);
			}
		} else if (this.iaGui.getAutoPlay() == source) {
			if (!this.moves.isEmpty()) {
				while (!this.moves.isEmpty()) {
					this.model.changeColor(this.moves.get(this.moves.size()-1).getColorOfToken(0, 0));
					this.moves.remove(this.moves.size()-1);
					this.iaGui.getMoveList().setListData(this.moves.toArray());
					this.mainGui.update(this.model);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.mainController.changeModel(this.model);
				}
				
			} else {
				this.iaGui.getNextMove().setEnabled(false);
				this.iaGui.getAutoPlay().setEnabled(false);
			}
		} else if (this.iaGui.getExit() == source) {
			this.iaGui.setEnabled(false);
			this.iaGui.setVisible(false);
			this.mainGui.setEnabled(true);
			this.mainGui.setFocusable(true);
		}
	}
	
	public boolean runSearchEngine() {
		boolean boardCanBeSolved = this.searchEngine.performSearch();
		if (boardCanBeSolved) {
			this.moves = this.searchEngine.getPath();
			System.out.println("El siguiente movimiento es: " + colorIntToString(this.moves.get(this.moves.size()-1).getColorOfToken(0, 0)));
		}
		return boardCanBeSolved;
	}
    
    private String colorIntToString(int color) {
        if (color == FlooditState.amarillo) {
            return "amarillo";
        } else if (color == FlooditState.verde) {
            return "verde";
        } else if (color == FlooditState.rojo) {
            return "rojo";
        } else if (color == FlooditState.azul) {
            return "azul";
        } else if (color == FlooditState.rosa) {
            return "rosa";
        } else {
            return "celeste";
        }
    }
	
	
	public void markNextMove() {
		if (!this.moves.isEmpty()) {
			int nextMove = this.moves.get(0).getColorOfToken(0, 0);
			if (nextMove == FlooditState.azul) {
				this.mainGui.getBotonAzul().setBackground(Color.GREEN);
			} else if (nextMove == FlooditState.verde) {
				this.mainGui.getBotonVerde().setBackground(Color.GREEN);
			} else if (nextMove == FlooditState.rojo) {
				this.mainGui.getBotonRojo().setBackground(Color.GREEN);
			} else if (nextMove == FlooditState.amarillo) {
				this.mainGui.getBotonAmarillo().setBackground(Color.GREEN);
			} else if (nextMove == FlooditState.celeste) {
				this.mainGui.getBotonCeleste().setBackground(Color.GREEN);
			} else if (nextMove == FlooditState.rosa) {
				this.mainGui.getBotonRosa().setBackground(Color.GREEN);
			}
		}
	}
	

}
