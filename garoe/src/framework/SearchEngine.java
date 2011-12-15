/**
 * 
 */
package framework;

import java.util.List;

/**
 * Extension de {@code BasicSearchEngine} para busqueda sin adversario
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IBasicState
 * @see BasicSearchEngine
 */
public abstract class SearchEngine<State extends IBasicState> extends BasicSearchEngine<State> {
	
	/**
	 * El camino desde el estado inicial hasta el estado exitoso : {@code List<State>}
	 */
	protected List<State> path;
	
	
    /**
     * Constructor de la clase
     * @param searchProblem : el problema sobre el cual opera el motor de búsqueda : {@code SearchProblem<State>}
     */
    public SearchEngine(SearchProblem<State> searchProblem) {
        super(searchProblem);
    }
    
	/**
	 * Executa la busqueda
	 * @return existe {@code s} tal que {@code searchProblem.initialState =(0 o mas reglas)=> s && s.success()} : {@code boolean}
	 */
	abstract public boolean performSearch();
	
	/**
	 * @return el camino desde el estado inicial al estado exitoso : {@code List<State>}
	 */
	final public List<State> getPath() {
		return this.path;
	}
	
}
