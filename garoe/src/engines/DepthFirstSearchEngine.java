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
 * Motor de busqueda sin adversario usando depth first search
 * @param <State> : El estado sobre el cual va a operar el motor de búsqueda : {@code IBasicState}
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IBasicState
 * @see SearchEngine
 */
public class DepthFirstSearchEngine<State extends IBasicState> extends SearchEngine<State> {

    private List<State> visited;
    private int visitedNodes;
    private long timeUsed;
    
    /**
     * Constructor de la clase
     * @param searchProblem : el problema sobre el cual opera el motor : {@code SearchProblem<State>}
     */
    public DepthFirstSearchEngine(SearchProblem<State> searchProblem){
        super(searchProblem);
    }
    
    
    
    @Override
    public boolean performSearch() {
        visited = new LinkedList<State>();
        path = new LinkedList<State>();
        State initial = this.searchProblem.getInitialState();
        this.visitedNodes = 0;
        this.timeUsed = 0;
        long startingTime = System.nanoTime();
        boolean found = performSearch(initial);
        long finishTime = System.nanoTime();
        this.timeUsed = finishTime - startingTime;
        return found;
    }
    
    
    /**
     * Realiza el algoritmo de búsqueda "Depth First Search"
     * @param state : el estado sobre el cual se realiza la búsqueda : {@code State}
     * @return true sii se encuentra un estado exitoso : {@code boolean} 
     */
    private boolean performSearch (State state){
        if (!visited.contains(state)) {visited.add(state);this.visitedNodes++;}
        if (state.success()){
            path.add(state);
            return true;
        } else {
            boolean found = false;
            List<State>succesors = this.searchProblem.getSuccessors(state);
            for (int i = 0 ;i < succesors.size()&& !found;i++) {
                State current = succesors.get(i);
                if (!visited.contains(current)) {
                    visited.add(current);
                    this.visitedNodes++;
                    if (performSearch(current)){
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
