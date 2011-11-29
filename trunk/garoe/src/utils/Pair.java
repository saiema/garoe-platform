/**
 * 
 */
package utils;

/**
 * Un par homogeneo, util para trabajar con dos elementos sin recurrir a arreglos, listas, etc
 * 
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 1.1
 *
 */
public class Pair<T1, T2>{
	
	/**
	 * el primer elemento del par : {@code T}
	 */
	private T1 firstElem;
	
	/**
	 * el segundo elemento del par : {@code T}
	 */
	private T2 secondElem;
	
	/**
	 * Constructor sin parametros
	 */
	public Pair() {
		this.firstElem = null;
		this.secondElem = null;
	}
	
	/**
	 * constructor de la clase
	 * @param firstElem : el primer elemento del par : {@code T}
	 * @param secondElem : el segundo elemento del par : {@code T}
	 */
	public Pair(T1 firstElem, T2 secondElem) {
		this.firstElem = firstElem;
		this.secondElem = secondElem;
	}

	/**
	 * @return el primer elemento del par : {@code T}
	 */
	public T1 getFirstElem() {
		return firstElem;
	}

	/**
	 * Cambia el valor del primer elemento del par
	 * @param firstElem : el nuevo valor del primer elemento : {@code T}
	 */
	public void setFirstElem(T1 firstElem) {
		this.firstElem = firstElem;
	}

	/**
	 * @return el segundo elemento del par : {@code T}
	 */
	public T2 getSecondElem() {
		return secondElem;
	}

	/**
	 * Cambia el valor del segundo elemento del par
	 * @param secondElem : el nuevo valor del segundo elemento : {@code T}
	 */
	public void setSecondElem(T2 secondElem) {
		this.secondElem = secondElem;
	}
	
	/**
	 * @returns la representacion del par tal que si el par es (a,b) se retorna (a.toString,b.toString) : {@code String}
	 */
	public String toString () {
		String res = "";
		if ((firstElem == null) & (secondElem == null)) {
			res = "(null,null)";
		} else if ((firstElem == null) & (secondElem != null)) {
			res = "(null," + secondElem.toString() + ")";
		} else if ((firstElem != null) & (secondElem == null)) {
			res = "(" + firstElem.toString() + ",null)";
		} else {
			res = "(" + firstElem.toString() + "," + secondElem.toString() + ")";
		}
		return res;  
	}

	
	
}
