package engine_framework;


/**
 * Define la estructura basica de un motor de busqueda y sus operaciones
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
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
	//posible atributo : padre actual, el padre del cual se obtuvieron los succesores actualmente siendo analizados
	
	
	public BasicSearchEngine () {};
	
	public BasicSearchEngine (SearchProblem<State> searchProblem) {
		this.searchProblem = searchProblem;
	}
	
	/*
	 * Executa la busqueda
	 * @return existe s tal que {@code searchProblem.initialState =(0 o mas reglas)=> s && s.success()} : {@code boolean}
	 *
	abstract public boolean performSearch();*/
	
	/**
	 * @return s tal que {@code s.success()} o s es el mejor candidato hasta el momento : {@code State}
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
	protected SearchProblem<State> getSearchProblem() {
		return searchProblem;
	}

	/**
	 * @param searchProblem  : el problema sobre el cual trabaja el motor : {@code SearchProblem<State>}
	 */
	protected void setSearchProblem(SearchProblem<State> searchProblem) {
		this.searchProblem = searchProblem;
	}

	
	
}
