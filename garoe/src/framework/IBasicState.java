package framework;


/**
 * Interfaz que define las operaciones basicas para los estados utilizados en problemas de busqueda
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.2
 */
public interface IBasicState {
	
	/**
     * Indica cual es el estado del cual deriva este estado
     * @return el estado del cual este estado deriva : {@code IBasicState}
     * <hr>
     * <b>Solo la raíz tiene {@code parent == null}</b>
     */
    public IBasicState getParent();
    
    /**
     * Define el estado del cual este deriva
     * @param parent : el estado del cual este deriva : {@code IBasicState}
     * <hr>
     * <b>Solo la raíz tiene {@code parent == null}</b>
     */
    public void setParent(IBasicState parent);
    
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
    
    /**
     * Crea un clon del objeto
     * @return un nuevo objeto con toda la estructura interna clonada de este : {@code IBasicState}
     */
    public IBasicState clone();
	
}
