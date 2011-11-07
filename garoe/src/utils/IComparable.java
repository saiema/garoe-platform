/**
 * 
 */
package utils;

/**
 * Interfaz para elementos comparables
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public interface IComparable {
	
	public int compareTo(IComparable other) throws NullPointerException;
	
	public IComparable clone();
	
}
