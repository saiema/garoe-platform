/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_waterjars;

import engines.DepthFirstSearchEngine;
import engines.IterativeDeepeningSearchEngine;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author simon
 */
public class WaterJarsIAController {
    private WaterJarsMainController mainController;
    private IAgui gui;
    private String selectedIA;
    private int step;
    private int maxTreeLevel;
    private int maxIterations;
    private int maxNodes;
    
    public WaterJarsIAController(WaterJarsMainController mainController, IAgui gui) {
        this.mainController = mainController;
        this.gui = gui;
        this.selectedIA = this.mainController.currentAI();
    }
    
    public void show() {
        this.mainController.hide();
        this.gui.setEnabled(true);
        this.gui.setVisible(true);
        List<String> ias = new LinkedList<String>();
        ias.add("DepthFirstSearchWithVisitedControlEngine");
        ias.add("IterativeDeepeningSearchEngine");
        ias.add("BreadthFirstSearchEngine");
        ias.add("DepthFirstSearchEngine");
        this.gui.loadSelector(ias);
        if (this.selectedIA.compareToIgnoreCase("IterativeDeepeningSearchEngine")==0) {
            this.maxTreeLevel = ((IterativeDeepeningSearchEngine)this.mainController.getAi()).getMaxTreeLevel();
            this.step = ((IterativeDeepeningSearchEngine)this.mainController.getAi()).getStep();
            this.maxIterations = ((IterativeDeepeningSearchEngine)this.mainController.getAi()).getMaxIterations();
            
        } else {
            this.maxIterations = -1;
            this.maxTreeLevel = 1;
            this.step = 1;
        }
        if (this.selectedIA.compareToIgnoreCase("DepthFirstSearchEngine")==0) {
            this.maxNodes = ((DepthFirstSearchEngine)this.mainController.getAi()).getMaxNodes();
        } else {
            this.maxNodes = 0;
        }
        this.gui.update(selectedIA);
    }
    
    public void save() {
        this.mainController.changeAI(selectedIA);
        if (this.selectedIA.compareToIgnoreCase("IterativeDeepeningSearchEngine")==0) {
            this.mainController.setIterativeDeepening(this.maxTreeLevel, this.step, this.maxIterations);
        }
        if (this.selectedIA.compareToIgnoreCase("DepthFirstSearchEngine")==0) {
            this.mainController.setDepthFirstSearch(this.maxNodes);
        }
        exit();
    }
    
    public void exit() {
        this.gui.setFocusable(false);
        this.gui.setVisible(false);
        this.gui.dispose();
        this.mainController.show();
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public int getMaxTreeLevel() {
        return maxTreeLevel;
    }

    public void setMaxTreeLevel(int maxTreeLevel) {
        this.maxTreeLevel = maxTreeLevel;
    }

    public void setSelectedIA(String selectedIA) {
        this.selectedIA = selectedIA;
        this.gui.update(selectedIA);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
    
    public int getMaxNodes() {
        return this.maxNodes;
    }
    
    public void setMaxNodes(int nodes) {
        this.maxNodes = nodes;
    }
    
    
    
    
}
