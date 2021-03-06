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

    private int visitedNodes;
    private long timeUsed;
    private int maxNodes = -1;
    
    /**
     * Constructor de la clase
     * @param searchProblem : el problema sobre el cual opera el motor : {@code SearchProblem<State>}
     */
    public DepthFirstSearchEngine(SearchProblem<State> searchProblem){
        super(searchProblem);
    }
    
    
    
    @Override
    public boolean performSearch() {
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
    
    public void setMaxNodes(int nodes) {
        this.maxNodes = nodes;
    }
    
    public int getMaxNodes() {
        return this.maxNodes;
    }
    
    
    /**
     * Realiza el algoritmo de búsqueda "Depth First Search"
     * @param state : el estado sobre el cual se realiza la búsqueda : {@code State}
     * @return true sii se encuentra un estado exitoso : {@code boolean} 
     */
    private boolean performSearch (State state){
        if (state.success()){
            return true;
        } else if (!(this.maxNodes == -1?false:this.visitedNodes>=this.maxNodes)) {
            boolean found = false;
            List<State>succesors = this.searchProblem.getSuccessors(state);
            for (int i = 0 ;i < succesors.size()&& !found && !(this.maxNodes == -1?false:this.visitedNodes>=this.maxNodes);i++) {
                current = succesors.get(i);
                this.visitedNodes++;
                if (!(this.maxNodes == -1?false:this.visitedNodes>=this.maxNodes) && performSearch(current)){
                    found = true;
                }
            }
            return found;
        } else {
            return false;
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
