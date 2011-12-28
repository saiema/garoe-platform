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
 * Motor de búsqueda sin adevrsario usando Iterative Deepening Search
 * @param <State> : El estado sobre el cual va a operar el motor de búsqueda : {@Code IBasicState}
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IBasicState
 * @see SearchEngine
 */
public class IterativeDeepeningSearchEngine<State extends IBasicState> extends SearchEngine<State> {
    private int maxTreeLevel;
    private int maxIterations;
    private int step;
    private int visitedNodes = 0;
    private long timeUsed = 0;
    
    
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
        int localIterations = this.maxIterations;
        int localMaxTreeLevel = this.maxTreeLevel;
        this.visitedNodes = 0;
        this.timeUsed = 0;
        boolean stopSearch = false;
        path = new LinkedList<State>();
        State initial = this.searchProblem.getInitialState();
        boolean found = false;
        long startingTime = System.currentTimeMillis();
        while(!stopSearch) {
            this.path = new LinkedList<State>();
            if (iterativeSearch(initial, localMaxTreeLevel)) {
                stopSearch = true;
                found = true;
            } else if (localIterations == -1 || localIterations > 0) {
                localMaxTreeLevel += this.step;
                localIterations = localIterations==-1?-1:localIterations - 1;
            } else {
                stopSearch = true;
            }
        }
        long finishTime = System.currentTimeMillis();
        this.timeUsed = (finishTime - startingTime);
        if (!found) current = null;
        return found;
    }
    
    private boolean iterativeSearch(State state, int level) {
        if (state.success()){
            current = state;
            return true;
        } else if (level == 0) {
            return false;
        } else {
            boolean found = false;
            List<State>succesors = this.searchProblem.getSuccessors(state);
            for (int i = 0 ;i < succesors.size()&& !found;i++) {
                current = succesors.get(i);
                this.visitedNodes++;
                int newLevel = level - 1;
                if (iterativeSearch(current, newLevel)){
                    found = true;
                }
            }
            return found;
        }
    }

    @Override
    public String getReport() {
        if (this.path.isEmpty()){
            return "no se encontro solucion | nodos visitados: "+this.visitedNodes+" | "+"tiempo utilizado: "+this.timeUsed+"ms";
        } else { 
           return "solucion encontrada | nodos visitados: "+this.visitedNodes+" | "+"tiempo utilizado: "+this.timeUsed+"ms"; 
        }
    }

    @Override
    public String status() {
       if (this.path.isEmpty()){
            return "no se encontro solucion | nodos visitados: "+this.visitedNodes+" | "+"tiempo utilizado: "+this.timeUsed+"ms";
        } else { 
           return "solucion encontrada | nodos visitados: "+this.visitedNodes+" | "+"tiempo utilizado: "+this.timeUsed+"ms"; 
        }
    }
    
    public long getTimeUsed() {
        return this.timeUsed;
    }
    
    public Integer getNodesVisited() {
        return this.visitedNodes;
    }
    
}
