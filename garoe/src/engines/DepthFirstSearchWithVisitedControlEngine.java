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
public class DepthFirstSearchWithVisitedControlEngine<State extends IBasicState> extends SearchEngine<State> {

    private List<State> visited;
    private int visitedNodes;
    private long timeUsed;
    
    /**
     * Constructor de la clase
     * @param searchProblem : el problema sobre el cual opera el motor : {@code SearchProblem<State>}
     */
    public DepthFirstSearchWithVisitedControlEngine(SearchProblem<State> searchProblem){
        super(searchProblem);
    }
    
    
    
    @Override
    public boolean performSearch() {
        visited = new LinkedList<State>();
        path = new LinkedList<State>();
        State initial = this.searchProblem.getInitialState();
        this.visitedNodes = 0;
        this.timeUsed = 0;
        long startingTime = System.currentTimeMillis();
        boolean found = performSearch(initial);
        long finishTime = System.currentTimeMillis();
        this.timeUsed = (finishTime - startingTime);
        if (!found) current = null;
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
            current = state;
//            path.add(state);
            return true;
        } else {
            boolean found = false;
            List<State>succesors = this.searchProblem.getSuccessors(state);
            for (int i = 0 ;i < succesors.size()&& !found;i++) {
                current = succesors.get(i);
                if (!visited.contains(current)) {
                    visited.add(current);
                    this.visitedNodes++;
                    if (performSearch(current)){
                        found = true;
//                        path.add(state);
                    }
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
