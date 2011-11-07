package engine_framework;

import java.util.List;

/**
 * Interfaz que define las operaciones basica para las reglas de un problema de busqueda
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public interface IRule<State extends IBasicState> {

	/**
	 * Indica si esta regla es aplicable a un estado
	 * @param state : el estado a evaluar : {@code IState}
	 * @return true sii esta regla es aplicable a {@code state} : {@code boolean}
	 */
	public boolean isApplicable(State state);
	
	/**
	 * Aplica esta regla a un estado y devuelve todos los estados obtenidos
	 * @param state : el estado al cual se aplicara esta regla : {@code IState}
	 * @return una lista con todos los estados state' tal que state deriva por esta regla a state' : {@code List<IState>}
	 */
	public List<State> apply(State state);
	
}
