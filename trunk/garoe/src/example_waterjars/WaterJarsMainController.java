/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_waterjars;

import engines.DepthFirstSearchEngine;
import engines.IterativeDeepeningSearchEngine;
import examples.GaroePlaygroundController;
import framework.IRule;
import framework.SearchEngine;
import framework.SearchProblem;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author simon
 */
public class WaterJarsMainController {
    private WaterJarsState state;
    private WaterJarsState stateBackup;
    private WaterJarsGUI gui;
    private boolean standAlone = true;
    private GaroePlaygroundController mainController = null;
    private SearchEngine<WaterJarsState> ai;
    private List<IRule<WaterJarsState>> rules;
    private SearchProblem<WaterJarsState> problem;
   
    private List<WaterJarsState> lastSearchResult;
    
    public WaterJarsMainController(WaterJarsState state, WaterJarsGUI gui) {
        this.gui = gui;
        this.state = state;
        this.stateBackup = state.clone();
        this.rules = new LinkedList<IRule<WaterJarsState>>();
        rules.add(new WaterJarsEmptyRule());
        rules.add(new WaterJarsFillRule());
        rules.add(new WaterJarsTransferRule());
        problem = new SearchProblem<WaterJarsState>(state,rules);
        ai = new DepthFirstSearchEngine<WaterJarsState>(problem);
    }
    
    public void changeAI(String aiName) {
        if (aiName.compareToIgnoreCase("DepthFirstSearhEngine")==0) {
            this.ai = new DepthFirstSearchEngine<WaterJarsState>(problem);
        } else if (aiName.compareToIgnoreCase("IterativeDeepeningSearchEngine")==0) {
            this.ai = new IterativeDeepeningSearchEngine<WaterJarsState>(problem);
        }
    }
    
    public String currentAI() {
        return ai.getClass().getSimpleName(); //TODO: CHECK!!!!
    }

    public SearchEngine<WaterJarsState> getAi() {
        return ai;
    }
    
    public void setIterativeDeepening(int minHeight, int stepSize, int maxIterations) {
        ((IterativeDeepeningSearchEngine)this.ai).setMaxTreeLevel(minHeight);
        ((IterativeDeepeningSearchEngine)this.ai).setStep(stepSize);
        ((IterativeDeepeningSearchEngine)this.ai).setMaxIterations(maxIterations);
    }
    
    public void resetState() {
        this.state = this.stateBackup.clone();
        this.gui.unpaintAllButtons();
        this.gui.update(state);
    }
    
    public void setMainController(GaroePlaygroundController mainController) {
        this.mainController = mainController;
        standAlone = false;
    }
    
    public void setNewState(WaterJarsState state) {
        this.state = state;
        this.stateBackup = state.clone();
        this.gui.unpaintAllButtons();
    }
    
    public WaterJarsState getState() {
        return state.clone();
    }
    
    public void show() {
		this.gui.setVisible(true);
        this.gui.setFocusable(true);
        this.gui.setEnabled(true);
		this.gui.update(state);
	}
    
    public void hide() {
        this.gui.setEnabled(false);
        this.gui.setFocusable(false);
    }
    
    public void transferTojar1() {
        this.state.transferToJar1();
        this.gui.update(state);
    }
    
    public void transferToJar2() {
        this.state.transferToJar2();
        this.gui.update(state);
    }
    
    public void emptyJar1() {
        this.state.emptyJar1();
        this.gui.update(state);
    }
    
    public void emptyJar2() {
        this.state.emptyJar2();
        this.gui.update(state);
    }
    
    public void fillJar1() {
        this.state.fillJar1();
        this.gui.update(state);
    }
    
    public void fillJar2() {
        this.state.fillJar2();
        this.gui.update(state);
    }
    
    public void exit() {
        this.gui.unpaintAllButtons();
        if (this.standAlone) {
            System.exit(0);
        } else {
            this.gui.setEnabled(false);
            this.gui.setVisible(false);
            this.gui.dispose();
            this.mainController.startMainGUI();
        }
    }
    
    public void about() {
        AboutJars about = new AboutJars(this.gui,true);
        about.setVisible(true);
    }
    
    public boolean hint() {
        boolean solutionFound = false;
        this.problem.setInitialState(this.state);
        if (this.ai.performSearch()) {
            this.lastSearchResult = new LinkedList<WaterJarsState>();
            for (WaterJarsState step:this.ai.getPath()) {
                 this.lastSearchResult.add(0, step);
            }
            this.lastSearchResult.remove(0); //Remueve el estado inicial
            for (WaterJarsState step:this.lastSearchResult) {
                System.out.println(step.lastStepDone);
            }
            solutionFound = true;
        }
        if (solutionFound) {
            nextHint();
        }
        return solutionFound;
    }
    
    public void nextHint() {
        this.gui.unpaintAllButtons();
        if (!this.lastSearchResult.isEmpty()) {
            markNextTip(this.lastSearchResult.get(0).lastStepDone);
            this.lastSearchResult.remove(0);
        }   
    }
    
    private void markNextTip(String tip) {
        //System.out.println("pista: "+tip);
        if (tip.compareToIgnoreCase("empty1")==0) {
            this.gui.paintEmpty1Button(Color.green);
        } else if (tip.compareToIgnoreCase("empty2")==0) {
            this.gui.paintEmpty2Button(Color.green);
        } else if (tip.compareToIgnoreCase("fill1")==0) {
            this.gui.paintFill1Button(Color.green);
        } else if (tip.compareToIgnoreCase("fill2")==0) {
            this.gui.paintFill2Button(Color.green);
        } else if (tip.compareToIgnoreCase("transfer1")==0) {
            this.gui.paintTransfer2Button(Color.green);
        } else if (tip.compareToIgnoreCase("transfer2")==0) {
            this.gui.paintTransfer1Button(Color.green);
        }
    }
    
}
