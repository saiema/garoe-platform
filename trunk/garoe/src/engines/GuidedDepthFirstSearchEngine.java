/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engines;

import engine_framework.IinformedState;
import engine_framework.SearchEngine;
import engine_framework.SearchProblem;
import java.util.LinkedList;
import java.util.List;

/**
 * Motor de busqueda sin adversario usando depth first search guiado, es decir
 * utiliza estados informados y la evaluación de los mismos para ordenar a los sucesores
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IinformedState
 * @see SearchEngine
 */
public class GuidedDepthFirstSearchEngine<EvalState extends IinformedState> extends SearchEngine<EvalState> {

    private List<EvalState> visited;
    
    /**
     * Constructor de la clase
     * @param searchProblem : el problema sobre el cual opera el motor : {@code SearchProblem<EvalState>}
     */
    public GuidedDepthFirstSearchEngine(SearchProblem<EvalState> searchProblem){
        super(searchProblem);
    }
    
    
    
    @Override
    public boolean performSearch() {
        visited = new LinkedList<EvalState>();
        path = new LinkedList<EvalState>();
        EvalState initial = this.searchProblem.getInitialState();
        return performSearch(initial);
    }
    
    
    /**
     * Realiza el algoritmo de búsqueda "Depth First Search guiado"
     * @param state : el estado sobre el cual se realiza la búsqueda : {@code EvalState}
     * @return true sii se encuentra un estado exitoso : {@code boolean} 
     */
    private boolean performSearch (EvalState state){
        visited.add(state);
        if (state.success()){
            path.add(state);
            return true;
        } else {
            boolean found = false;
            List<EvalState>succesors = this.searchProblem.getSuccessors(state);
            List<EvalState>orderedSuccesors = new LinkedList<EvalState>();
            for (EvalState s:succesors) {
                insert(orderedSuccesors,s);
            }
            for (int i = 0 ;i < orderedSuccesors.size()&& !found;i++) {
                EvalState current = orderedSuccesors.get(i);
                if (!visited.contains(current)) {
                    visited.add(current);
                    if (performSearch(current)){
                        found = true;
                        path.add(state);
                    }
                }
            }
            return found;
        }
    }
    
    /**
     * Inserta un elemento a una lista tratando de manera ordenada (mayor a menor).
     * @param queue : la lista sobre la cual insertar : {@code Queue<EvalState>}
     * @param state : el estado a insertar : {@code EvalState}
     */
	private void insert(List<EvalState> list, EvalState state) {
        /*
         * El elemento primero se inserta al final y se va corriendo hacia adelante
         * mientras se encuentren elementos peores por delante.
         */
		boolean inserted = list.isEmpty();
		int index = list.size();
		while (!inserted && index > 0) {
			if (state.evaluate().compareTo(list.get(index-1).evaluate()) > 0) { //state es mas grande que el ultimo de la cola
				index--;
			} else {
				inserted = true;
			}
		}
		list.add(index, state);
		if (index > 0 && (list.size() > index)) {
			list.remove(list.size() - 1);
		}
	}

    @Override
    public String getReport() {
        return "report";
    }

    @Override
    public String status() {
        return "status";
    }
   
}
