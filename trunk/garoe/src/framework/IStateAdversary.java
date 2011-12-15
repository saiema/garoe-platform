package framework;

/**
 * Extension de {@code IinformedState} para problemas de busqueda con adversarios
 * 
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IinformedState
 *
 */
public interface IStateAdversary extends IinformedState {
	
	/**
	 * @return true sii {@code this.evaluate() == MinVal && this.success()} : {@code boolean}
	 */
	public boolean minWins();
	
	/**
	 * @return true sii {@code this.evaluate() == MaxVal && this.success()} : {@code boolean}
	 */
	public boolean maxWins();
	
	/**
	 * @return true sii el estado es max : {@code boolean}
	 */
	public boolean isMax();
	
	/**
	 * @return true sii el estado es min : {@code boolean}
	 */
	public boolean isMin();
	
	/**
	 * cambia el estado a max
	 */
	public void setMax();
	
	/**
	 * cambia el estado a min
	 */
	public void setMin();
	
	/**
	 * cambia el estado al nivel opuesto (min -> max y viceversa)
	 */
	public void changeLevel();

}
