package framework;


import java.util.LinkedList;
import java.util.List;

/**
 * Define la estructura basica de un problema de busqueda y sus operaciones
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
 * @see IBasicState
 */
public class SearchProblem<State extends IBasicState> {
	
	/**
	 * el estado inicial del problema : {@code State}
	 */
	private State initialState;
	
	/**
	 * las reglas asociadas a este problema : {@code List<IRule<State>>}
	 */
	protected List<IRule<State>> rules;
	
	/**
	 * Constructor basico de la clase, toma un estado inicial y las reglas
	 * @param initialState : el estado inicial del problema : {@code State}
	 * @param rules : las reglas asociadas al problema : {@code List<IRule<State>>}
	 */
	public SearchProblem(State initialState, List<IRule<State>> rules) {
		this.initialState = initialState;
		this.rules = rules;
	}
	
	/**
	 * Algoritmo basico para obtener sucesores de un estado
	 * @param s : estado del cual se obtendran los sucesores : {@code State}
	 * @return una lista de {@code s'} tal que existe una regla {@code r} en {@code rules} tal que {@code s'} pertenece a {@code r.apply(s)} : {@code List<State>}
	 */
	public List<State> getSuccessors(State s) {
		List<State> successors = new LinkedList<State>();
		for (IRule<State> rule : rules) {
			if (rule.isApplicable(s)) {
                List<State> rule_succesors = rule.apply(s);
                for (State child:rule_succesors) child.setParent(s);
				successors.addAll(rule_succesors);
			}
		}
		return successors;
	}
	
	/**
	 * @return el estado inicial del problema : {@code State}
	 */
	final public State getInitialState() {
		return this.initialState;
	}
	
	/**
	 * Define el estado inicial del problema
	 * @param s : el nuevo estado inicial : {@code State}
	 */
	final public void setInitialState(State s) {
		initialState = s;
	}
	
}
