/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engines;

import framework.IBasicState;
import framework.SearchEngine;
import framework.SearchProblem;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author simon
 */
public class IterativeDeepeningSearchEngine<State extends IBasicState> extends SearchEngine<State> {
    private int maxTreeLevel;
    private int maxIterations;
    private int step;
    private int visitedNodes = 0;
    private long timeUsed = 0;
    
    private List<State> visited;
    
    public IterativeDeepeningSearchEngine(SearchProblem<State> problem) {
        super(problem);
        this.maxTreeLevel = 1;
        this.maxIterations = -1; //infinito
        this.step = 1;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public void setMaxTreeLevel(int maxTreeLevel) {
        this.maxTreeLevel = maxTreeLevel;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public int getMaxTreeLevel() {
        return maxTreeLevel;
    }

    public int getStep() {
        return step;
    }
    
    
    
    @Override
    public boolean performSearch() {
        this.visited = new LinkedList<State>();
        this.visitedNodes = 0;
        this.timeUsed = 0;
        boolean stopSearch = false;
        path = new LinkedList<State>();
        State initial = this.searchProblem.getInitialState();
        boolean found = false;
        long startingTime = System.nanoTime();
        while(!stopSearch) {
            this.visited = new LinkedList<State>();
            this.path = new LinkedList<State>();
            if (iterativeSearch(initial, this.maxTreeLevel)) {
                stopSearch = true;
                found = true;
            } else if (this.maxIterations == -1 || this.maxIterations > 0) {
                this.maxTreeLevel += this.step;
                this.maxIterations = this.maxIterations==-1?-1:this.maxIterations - 1;
            } else {
                found = false;
            }
        }
        long finishTime = System.nanoTime();
        this.timeUsed = finishTime - startingTime;
        return found;
    }
    
    private boolean iterativeSearch(State state, int level) {
        if (!visited.contains(state)) {visited.add(state);this.visitedNodes++;}
        if (state.success()){
            path.add(state);
            return true;
        } else if (level == 0) {
            return false;
        } else {
            boolean found = false;
            List<State>succesors = this.searchProblem.getSuccessors(state);
            for (int i = 0 ;i < succesors.size()&& !found;i++) {
                State current = succesors.get(i);
                if (!visited.contains(current)) {
                    visited.add(current);
                    this.visitedNodes++;
                    if (iterativeSearch(current, level--)){
                        found = true;
                        path.add(state);
                    }
                }
            }
            return found;
        }
    }

    @Override
    public String getReport() {
        return "nodos visitados: "+this.visitedNodes+" | "+"tiempo utilizado: "+this.timeUsed+"ms";
    }

    @Override
    public String status() {
        return "nodos visitados: "+this.visitedNodes+" | "+"tiempo utilizado: "+this.timeUsed+"ms";
    }
    
}
