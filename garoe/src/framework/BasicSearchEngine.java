package framework;


/**
 * Define la estructura basica de un motor de busqueda y sus operaciones
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
 * @see IBasicState
 */
abstract public class BasicSearchEngine<State extends IBasicState> {
	
	/**
	 * El problema de busqueda sobre el cual opera el motor : {@code SearchProblem}
	 */
	protected SearchProblem<State> searchProblem;
	
	/**
	 * Indica el estado actual : {@code IState}
	 */
	protected State current;  //el estado actualmente analizado (la mejor opcion hasta el momento)
	
    /**
     * Constructor de la clase
     * @param searchProblem : el problema sobre el cual opera el motor : {SearchProblem<State>}
     */
	public BasicSearchEngine (SearchProblem<State> searchProblem) {
		this.searchProblem = searchProblem;
	}
	
	/**
     * Retorna la solución que encontró el algoritmo de búsqueda
	 * @return {@code s} tal que {@code s.success()} o {@code s} es el mejor candidato hasta el momento : {@code State}
	 * <hr>
	 * <p><b>s puede ser {@code null} si no existe solucion o si aun no se ejecuto {@code performSearch()}</b></p>
	 */
	public State getSolution() {
		return current;
	}
	
	/**
	 * @return reporte del motor, depende de la implementacion del metodo : {@code String}
	 */
	abstract public String getReport();
	
	/**
	 * @return el estado actual del motor, depende de la implementacion del metodo : {@code String}
	 */
	abstract public String status();

	/**
	 * @return el problema sobre el cual esta trabajando el motor : {@code SearchProblem<State>}
	 */
	public SearchProblem<State> getSearchProblem() {
		return searchProblem;
	}

	/**
	 * @param searchProblem  : el problema sobre el cual trabaja el motor : {@code SearchProblem<State>}
	 */
	public void setSearchProblem(SearchProblem<State> searchProblem) {
		this.searchProblem = searchProblem;
	}

	
	
}
