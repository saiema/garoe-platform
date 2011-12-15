package framework;

import java.util.List;

/**
 * Interfaz que define las operaciones basicas para las reglas de un problema de busqueda
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IBasicState
 */
public interface IRule<State extends IBasicState> {

	/**
	 * Indica si esta regla es aplicable a un estado
	 * @param state : el estado a evaluar : {@code State}
	 * @return true sii esta regla es aplicable a {@code state} : {@code boolean}
	 */
	public boolean isApplicable(State state);
	
	/**
	 * Aplica esta regla a un estado y devuelve todos los estados obtenidos
	 * @param state : el estado al cual se aplicara esta regla : {@code State}
	 * @return una lista con todos los estados {@code state'} tal que {@code state} deriva por esta regla a {@code state'} : {@code List<State>}
	 */
	public List<State> apply(State state);
	
}
