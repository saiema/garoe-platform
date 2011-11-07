package engine_framework;

import utils.IComparable;

/**
 * Extiende a {@code SearchEngine} para agregar la funcionalidad de un motor de busqueda con adversario
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see BasicSearchEngine
 */
public abstract class AdversarySearchEngine<AdversaryState extends IStateAdversary> extends BasicSearchEngine<AdversaryState> {
	
	/**
	 * Computa la valorarion de un estado dado
	 * @param state : el estado a evaluar : {@code AdversaryState}
	 * @return la valoracion del estado : {@code int}
	 * <hr>
	 * <p><b>si {@code state} es un estado "hoja" entonces esta funcion devuelve state.evaluate()</b></p>
	 */
	abstract public IComparable computeValue(AdversaryState state);
	
	public AdversarySearchEngine(SearchProblem<AdversaryState> problem) {
		super(problem);
	}
	
	/**
	 * Busca el siguiente movimiento dado un estado
	 * @param state : el estado actual : {@code AdversaryState}
	 * @return el estado original con el movimiento hecho : {@code AdversaryState}
	 */
	abstract public AdversaryState nextMove(AdversaryState state);/* {
		this.searchProblem.setInitialState(state);
		this.current = null;
		performSearch();
		return this.getSolution();
	}*/
	
	/**
	 * Setea la maxima profundidad del arbol de busqueda
	 * @param k : la profundidad maxima del arbol de busqueda (0 significa sin limites) : {@code int}
	 */
	abstract public void setMaxTreeLevel(int k);
	
	/** 
	 * @return la maxima profundidad del arbol de busqueda
	 */
	abstract public int getMaxTreeLevel();
	
}
