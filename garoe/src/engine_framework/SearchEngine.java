/**
 * 
 */
package engine_framework;

import java.util.List;

/**
 * Extension de {@code BasicSearchEngine} para busqueda sin adversario
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public abstract class SearchEngine<State extends IBasicState> extends BasicSearchEngine<State> {
	
	/**
	 * El camino desde el estado inicial hasta el estado exitoso : {@code List<State extends IState>}
	 */
	protected List<State> path;
	
	
	/**
	 * Executa la busqueda
	 * @return existe s tal que {@code searchProblem.initialState =(0 o mas reglas)=> s && s.success()} : {@code boolean}
	 */
	abstract public boolean performSearch();
	
	/**
	 * @return el camino desde el estado inicial al estado exitoso : {@code List<IState>}
	 */
	final public List<State> getPath() {
		return this.path;
	}
	
}
