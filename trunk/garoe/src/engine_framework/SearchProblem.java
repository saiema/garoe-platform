package engine_framework;


import java.util.LinkedList;
import java.util.List;

/**
 * Define la estructura basica de un problema de busqueda y sus operaciones
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
 */
public class SearchProblem<State extends IBasicState> {
	
	/**
	 * el estado inicial del problema : {@code IState}
	 */
	private State initialState;
	
	/**
	 * las reglas asociadas a este problema : {@code List<IRule>}
	 */
	protected List<IRule<State>> rules;
	
	/**
	 * Constructor basico de la clase, toma un estado inicial y las reglas
	 * @param initialState : el estado inicial del problema : {@code IState}
	 * @param rules : las reglas asociadas al problema : {@code List<IRule>}
	 */
	public SearchProblem(State initialState, List<IRule<State>> rules) {
		this.initialState = initialState;
		this.rules = rules;
	}
	
	/**
	 * Algoritmo basico para obtener sucesores de un estado
	 * @param s : estado del cual se obtendran los sucesores : {@code IState}
	 * @return una lista de s' tal que existe una regla r en {@code rules} tal que s' pertenece a {@code r.apply(s)} : {@code List<IState>}
	 */
	public List<State> getSuccessors(State s) {
		List<State> successors = new LinkedList<State>();
		for (IRule<State> rule : rules) {
			if (rule.isApplicable(s)) {
				successors.addAll(rule.apply(s));
			}
		}
		return successors;
	}
	
	/**
	 * @return el estado inicial del problema : {@code IState}
	 */
	final public State getInitialState() {
		return this.initialState;
	}
	
	/**
	 * Setea un estado inicial al problema
	 * @param s : el nuevo estado inicial : {@code IState}
	 */
	final public void setInitialState(State s) {
		initialState = s;
	}
	
}
