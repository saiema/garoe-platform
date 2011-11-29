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
	
    /**
     * Este metodo compara este objeto con otro 
     * @param other : el objeto con el cual comparar : {@code IComparable}
     * @return <li>< 0 si {@code other} es mayor a este objeto</li><li>== 0 si ambos son iguales</li><li>> 0 si other es menor a este objeto</li>
     * @throws NullPointerException 
     */
	public int compareTo(IComparable other) throws NullPointerException;
	
    /**
     * Clona un objeto de tipo {@code IComparable}
     * @return un clon de este objeto : {@code IComparable}
     */
	public IComparable clone();
	
}
