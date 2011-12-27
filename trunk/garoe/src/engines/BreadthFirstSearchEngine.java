/**
 * 
 */
package engines;

import framework.IBasicState;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import framework.IinformedState;
import framework.SearchEngine;
import framework.SearchProblem;

/**
 * Motor de busqueda sin adversario usando breadth first search
 * @param <EvalState> : El estado sobre el cual va a operar el motor de búsqueda : {@Code IinformedState}
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IinformedState
 * @see SearchEngine
 */
public class BreadthFirstSearchEngine<State extends IBasicState> extends SearchEngine<State> {
	private List<String> log;
	private Queue<State> queue;
    private List<State> visited;
    private int visitedNodes;
    private long timeUsed;
	
    /**
     * Constructor de la clase
     * @param problem : el problema sobre el cual opera el motor : {@code SearchProblem<EvalState>}
     */
	public BreadthFirstSearchEngine(SearchProblem<State> problem) {
        super(problem);
		this.path = new LinkedList<State>();
		this.log = new LinkedList<String>();
		this.queue = new LinkedList<State>();
	}
	
	@Override
	public boolean performSearch() {
		queue.clear();
        this.visited = new LinkedList<State>();
        this.timeUsed = 0;
        this.visitedNodes = 0;
        long startingTime = System.currentTimeMillis();
        boolean found = performSearch(this.searchProblem.getInitialState());
        long finishTime = System.currentTimeMillis();
        this.timeUsed = (finishTime - startingTime);
        return found;
	}
    

	
    /**
     * Realiza el algoritmo de búsqueda "Breadth First Search"
     * Se utiliza una cola para ir agregando los estados sucesores y el algoritmo de búsqueda
     * siempre recorre los estados segun el orden de la cola
     * @param state : el estado sobre el cual se realiza la búsqueda : {@code EvalState}
     * @return true sii se encuentra un estado exitoso : {@code boolean}
     */
	private boolean performSearch(State state) {
        if (!this.visited.contains(state)) {
            this.visited.add(state);
            this.visitedNodes++;
        }
		if (state.success()) {
			path.add(state);
			return true;
		} else {
			boolean found = false;
            for (State succesor:this.searchProblem.getSuccessors(state)) {
                if (!this.visited.contains(succesor) && !queue.contains(succesor)) {
                    queue.add(succesor);
                }
            }
            //queue.addAll(this.searchProblem.getSuccessors(state));
			while (!found && !queue.isEmpty()) {
				State current = queue.poll();
                if (!this.visited.contains(current)) {
                    this.visited.add(current);
                    this.visitedNodes++;
                    if (performSearch(current)) {
                        path.add(state);
                        found = true;
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
