package engine_framework;


/**
 * Interfaz que define las operaciones basicas para los estados utilizados en problemas de busqueda
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
 */
public interface IBasicState {
	
	
	/**
	 * Indica que este estado no puede tener ningun estado sucesor, es decir que es una hoja
	 * @return true sii este estado es hoja : {@code boolean}
	 */
	public boolean isFinal();
	
	/**
	 * Indica que este estado resuelve el problema
	 * @return true sii este estado resuelve el problema : {@code boolean}
	 */
	public boolean success();
	
    /**
     * Comprueba que la representación del objeto es válida
     * @return true sii este objeto cumple con el invariante de lo que representa : {@code boolean}
     */
	public boolean repOk();
	
}
