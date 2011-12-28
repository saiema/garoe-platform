/**
 * 
 */
package engines;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import framework.IinformedState;
import framework.SearchEngine;
import framework.SearchProblem;

/**
 * Motor de busqueda sin adversario usando best first search
 * @param <EvalState> : El estado sobre el cual va a operar el motor de búsqueda : {@Code IinformedState}
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
        boolean found = performSearch(this.searchProblem.getInitialState());
        if (!found)current = null;
        return found;
	}
    
    /**
     * Define la capacidad máxima de la cola de prioridades utilizada en el algoritmo de búsqueda
     * @param queueMaxCapacity : capacidad máxima de la cola de prioridades : {@code int}
     */
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
		boolean found = false;
        boolean stopSearch = false;
        found = state.success();
        current = state;
        while (!found && !stopSearch) {
            for (EvalState succesor:this.searchProblem.getSuccessors(current)) {
                if (!queue.contains(succesor)) {
                    insert(queue,succesor);
                }
            }
            if (queue.isEmpty()) {
                stopSearch = true;
            } else {
                current = queue.poll();
                found = current.success();
            }
		}
        if (!found) {
            current = null;
        }
        return found;
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
