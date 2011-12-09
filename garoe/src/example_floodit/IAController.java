/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_floodit;

import engine_framework.IRule;
import engine_framework.SearchProblem;
import engines.GuidedDepthFirstSearchEngine;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author BigEma
 */
public class IAController {
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
        this.moves = new LinkedList<FlooditState>();
		List<IRule<FlooditState>> rules = new LinkedList<IRule<FlooditState>>();
		rules.add(new FlooditMoveRule());
		SearchProblem<FlooditState> problem = new SearchProblem<FlooditState>(model,rules);
		this.searchEngine = new GuidedDepthFirstSearchEngine<FlooditState>(problem);
	}
    
    public void showGui() {
        this.iaGui.setEnabled(true);
        this.iaGui.setVisible(true);
        this.mainGui.setEnabled(false);
        this.mainGui.setFocusable(false);
        updateList();
    }
    
    public int exit() {
        this.mainGui.setEnabled(true);
        this.mainGui.setFocusable(true);
        this.iaGui.setVisible(false);
        this.iaGui.setEnabled(false);
        return 0;
    }
    
    public void auto() {
        while (!this.moves.isEmpty()) {
            next();
        }
    }
    
    public void next() {
        this.model.changeColor(this.moves.get(this.moves.size()-1).getColorOfToken(0, 0));
        this.moves.remove(this.moves.size()-1);
        this.mainGui.update(model);
        updateList();
    }
    
    public boolean search() {
        boolean boardCanBeSolved = this.searchEngine.performSearch();
		if (boardCanBeSolved) {
			this.moves = this.searchEngine.getPath();
            this.moves.remove(this.moves.size()-1); //TODO: PARCHE TEMPORAL
            System.out.println("El siguiente movimiento es: " + colorIntToString(this.moves.get(this.moves.size()-1).getColorOfToken(0, 0)));
        }
        this.iaGui.setButtonsState(boardCanBeSolved);
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
    
    private void updateList() {
        List<String> newMoveList = new LinkedList<String>();
        for (FlooditState s:this.moves) {
            newMoveList.add(0, colorIntToString(s.getColorOfToken(0,0)));
        }
        this.iaGui.updateListModel(newMoveList);
        this.iaGui.setButtonsState(!this.moves.isEmpty());
    }
    
    public void hint() {
        if (!this.moves.isEmpty()) {
            int hint = this.moves.get(this.moves.size()-1).getColorOfToken(0, 0);
            String stringHint = colorIntToString(hint);
            if (stringHint.compareToIgnoreCase("verde")==0) {
                //this.mainGui.getBotonVerde().setForeground(Color.green);
                this.mainGui.getBotonVerde().setBackground(Color.green);
            } else if (stringHint.compareToIgnoreCase("amarillo")==0) {
                //this.mainGui.getBotonAmarillo().setForeground(Color.green);
                this.mainGui.getBotonAmarillo().setBackground(Color.green);
            } else if (stringHint.compareToIgnoreCase("azul")==0) {
                //this.mainGui.getBotonAzul().setForeground(Color.green);
                this.mainGui.getBotonAzul().setBackground(Color.green);
            } else if (stringHint.compareToIgnoreCase("celeste")==0) {
                //this.mainGui.getBotonCeleste().setForeground(Color.green);
                this.mainGui.getBotonCeleste().setBackground(Color.green);
            } else if (stringHint.compareToIgnoreCase("rosa")==0) {
                //this.mainGui.getBotonRosa().setForeground(Color.green);
                this.mainGui.getBotonRosa().setBackground(Color.green);
            } else if (stringHint.compareToIgnoreCase("rojo")==0) {
                //this.mainGui.getBotonRojo().setForeground(Color.green);
                this.mainGui.getBotonRojo().setBackground(Color.green);
            }
        }
    }
    
    
}
