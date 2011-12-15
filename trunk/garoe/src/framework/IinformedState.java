/**
 * 
 */
package framework;

import utils.IComparable;

/**
 * Presenta la interfaz para estados utilizados en busqueda informada
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IBasicState
 */
public interface IinformedState extends IBasicState{
	
	
	/**
	 * Evalua este estado segun un rango definido en la implementacion, el valor indica cuan cerca esta de ser solucion del problema
	 * @return el valor asociado a este estado dependiendo de cuan cerca esta de ser solucion : {@code IComparable}
     * @see IComparable
	 */
	public IComparable evaluate();
	
	/**
	 * @return el valor minimo al que puede evaluar un determinado estado : {@code IComparable}
     * @see IComparable
	 */
	public IComparable minVal();
	
	/**
	 * @return el valor maximo al que puede evaluar un determinado estado : {@code IComparable}
     * @see IComparable
	 */
	public IComparable maxVal();
	
}
