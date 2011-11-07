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
 * @version 0.1
 * @see SearchEngine
 *
 */
public class BestFirstSearchEngine<EvalState extends IinformedState> extends SearchEngine<EvalState> {
	private List<String> log;
	private Queue<EvalState> queue;
	
	
	public BestFirstSearchEngine(SearchProblem<EvalState> problem) {
		this.searchProblem = problem;
		this.path = new LinkedList<EvalState>();
		this.log = new LinkedList<String>();
		this.queue = new LinkedList<EvalState>();
	}
	
	@Override
	public boolean performSearch() {
		queue.clear();
		return performSearch(this.searchProblem.getInitialState());
	}
	
	private boolean performSearch(EvalState state) {
		System.out.println("Queue longitud: " + queue.size());
		if (state.success()) {
			path.add(state);
			return true;
		} else {
			for (EvalState child : this.searchProblem.getSuccessors(state)) {
				insert(queue, child);
				//queue.offer(child);
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

	private void insert(Queue<EvalState> queue, EvalState state) {
		List<EvalState> priorityQueue = (LinkedList<EvalState>) queue;
		boolean inserted = priorityQueue.isEmpty();
		int index = priorityQueue.size();//Math.max(priorityQueue.size() - 1,0);
		while (!inserted && index > 0) {
			if (state.evaluate().compareTo(priorityQueue.get(index-1).evaluate()) > 0) { //state es mas grande que el ultimo de la cola
				index--;
			} else {
				inserted = true;
			}
		}
		priorityQueue.add(index, state);
		if (priorityQueue.size() > 500) {
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
