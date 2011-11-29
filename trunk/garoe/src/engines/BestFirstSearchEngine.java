/**
 * 
 */
package engines;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import engine_framework.IinformedState;
import engine_framework.SearchEngine;
import engine_framework.SearchProblem;

/**
 * Motor de busqueda sin adversario usando best first search
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
 * @see IinformedState
 * @see SearchEngine
 */
public class BestFirstSearchEngine<EvalState extends IinformedState> extends SearchEngine<EvalState> {
	private List<String> log;
	private Queue<EvalState> queue;
    private Integer queueMaxCapacity = 0;
	
	
    /**
     * Constructor de la clase
     * @param problem : el problema sobre el cual opera el motor : {@code SearchProblem<EvalState>}
     */
	public BestFirstSearchEngine(SearchProblem<EvalState> problem) {
        super(problem);
		this.path = new LinkedList<EvalState>();
		this.log = new LinkedList<String>();
		this.queue = new LinkedList<EvalState>();
	}
	
	@Override
	public boolean performSearch() {
		queue.clear();
		return performSearch(this.searchProblem.getInitialState());
	}
    
    public void setQueueCapacity(int queueMaxCapacity) {
        this.queueMaxCapacity = queueMaxCapacity;
    }
	
    /**
     * Realiza el algoritmo de búsqueda "Best First Search"
     * Se utiliza una cola de prioridades para ordenar los estados sucesores y el algoritmo de búsqueda
     * siempre recorre los estados comenzando por el primero (el mejor)
     * @param state : el estado sobre el cual se realiza la búsqueda : {@code EvalState}
     * @return true sii se encuentra un estado exitoso : {@code boolean}
     */
	private boolean performSearch(EvalState state) {
		if (state.success()) {
			path.add(state);
			return true;
		} else {
			for (EvalState child : this.searchProblem.getSuccessors(state)) {
				insert(queue, child);
			}
			boolean found = false;
			while (!found && !queue.isEmpty()) {
				EvalState current = queue.poll();
				if (performSearch(current)) {
					path.add(current);
					found = true;
				}
			}
			return found;
		}
	}

    /**
     * Inserta un elemento a una cola tratando a la misma como cola de prioridad.
     * @param queue : la cola sobre la cual insertar : {@code Queue<EvalState>}
     * @param state : el estado a insertar : {@code EvalState}
     */
	private void insert(Queue<EvalState> queue, EvalState state) {
        /*
         * El elemento primero se inserta al final y se va corriendo hacia adelante
         * mientras se encuentren elementos peores por delante.
         */
		List<EvalState> priorityQueue = (LinkedList<EvalState>) queue;
		boolean inserted = priorityQueue.isEmpty();
		int index = priorityQueue.size();
		while (!inserted && index > 0) {
			if (state.evaluate().compareTo(priorityQueue.get(index-1).evaluate()) > 0) { //state es mas grande que el ultimo de la cola
				index--;
			} else {
				inserted = true;
			}
		}
		priorityQueue.add(index, state);
		if (queueMaxCapacity > 0 && (priorityQueue.size() > queueMaxCapacity)) {
			priorityQueue.remove(priorityQueue.size() - 1);
		}
	}
	
	@Override
	public String getReport() {
		String report = "";
		for (String event : this.log) {
			report += event + '\n';
		}
		return report;
	}

	@Override
	public String status() {
		return "aca se devolveria el estado actual del motor";
	}

}
