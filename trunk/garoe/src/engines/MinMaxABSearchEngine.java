/**
 *
 */
package engines;

import java.util.LinkedList;
import java.util.List;

import utils.IComparable;

import framework.AdversarySearchEngine;
import framework.IStateAdversary;
import framework.SearchProblem;

/**
 * Motor de busqueda con adversario usando minMax con poda alfa-beta
 * @param <AdversaryState> : El estado sobre el cual va a operar el motor de búsqueda : {@code IStateAdversary}
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * @see IStateAdversary
 * @see AdversarySearchEngine
 */
public class MinMaxABSearchEngine<AdversaryState extends IStateAdversary> extends AdversarySearchEngine<AdversaryState> {
	final private int DEFAULT_MAX_TREE_LEVEL = 5; //altura maxima del arbol por defecto
	/**
	 * Altura maxima del arbol de busqueda : {@code int}
	 */
	protected int maxTreeLevel;
	/**
	 * Registro del motor de busqueda : {@code List<String>}
	 */
	protected List<String> log;
	
	
	/**
	 * Constructor de la clase
	 * @param p : el problema de busqueda : {@code SearchProblem<AdversaryState>}
	 */
	public MinMaxABSearchEngine(SearchProblem<AdversaryState> p) {
		super(p);
		this.current = null;
		this.maxTreeLevel = DEFAULT_MAX_TREE_LEVEL;
		this.log = new LinkedList<String>();
	}
	
	/**
	 * Constructor que incorpora altura maxima del arbol 
	 * @param p : el problema de busqueda : {@code SearchProblem<AdversaryState>}
	 * @param maxTreeLevel : altura maxima del arbol de busqueda : {@code int}
	 */
	public MinMaxABSearchEngine(SearchProblem<AdversaryState> p, int maxTreeLevel) {
		super(p);
		this.current = null;
		this.setMaxTreeLevel(maxTreeLevel);
		this.log = new LinkedList<String>();
	}

	/**
	 * Intermediario entre {@code computeValue} y {@code minMax(AdversaryState, int, int, int)} para disminuir los parametros de llamada
	 * @param state : el estado al cual calcular minMax : {@code AdversaryState}
	 * @return la evaluacion de {@code state} mediante minMaxAB : {@code int}
	 */
	private IComparable minMax(AdversaryState state) {
		return minMax(state,state.minVal(),state.maxVal(),this.maxTreeLevel);
	}
	
	/**
	 * minMax con poda alfa beta
	 * @param state : el estado al cual evaluar : {@code AdversaryState}
	 * @param alfa : {@code int}
	 * @param beta : {@code int}
	 * @param depth : profundidad del arbol actual : {@code int}
	 * @return la evaluacion de {@code state} mediante minMaxAB : {@code int}
	 */
	private int stateCount = 0;
	private int lookedCount = 0;
	private IComparable minMax(AdversaryState state, IComparable alfa, IComparable beta, int depth) {
		IComparable currAlfa = alfa.clone();
		IComparable currBeta = beta.clone();
		if (state.isFinal() || depth == 0) {				
			return state.evaluate();		
		} else {
			List<AdversaryState> succesors = this.searchProblem.getSuccessors(state);
			stateCount+=succesors.size();
			int currentSuccesor = 0;
			if (depth == this.maxTreeLevel) this.current = (succesors.isEmpty())?null:succesors.get(0);
			while (currentSuccesor < succesors.size() && currAlfa.compareTo(currBeta) < 0) {
				lookedCount++;
				AdversaryState curr = succesors.get(currentSuccesor);
				IComparable mm = minMax(curr, currAlfa, currBeta, depth - 1);
				if (state.isMax()) {
					if (mm.compareTo(currAlfa) > 0) {			
						currAlfa = mm.clone();					
						if (depth == this.maxTreeLevel) {		
							this.current = curr;				
						}										
					}											
				} else { //state.isMin()
					if (mm.compareTo(currBeta) < 0) {			
						currBeta = mm.clone();					
						if (depth == this.maxTreeLevel) {		
							this.current = curr;				
						}										
					}	
				}
				currentSuccesor++;
			}
			if (state.isMax()) {
				return currAlfa;
			} else { //state.isMin();
				return currBeta;
			}
		}
	}

	@Override
	public void setMaxTreeLevel(int k) {
		this.maxTreeLevel = k > 0? k:this.DEFAULT_MAX_TREE_LEVEL;
	}
	
	@Override
	public int getMaxTreeLevel() {
		return maxTreeLevel;
	}

    @Override
	public AdversaryState nextMove(AdversaryState state) {
		this.searchProblem.setInitialState(state);
		stateCount = 0;
		lookedCount = 0;
		AdversaryState initialState = this.searchProblem.getInitialState();
		computeValue(initialState);
//		System.out.println("Total states: " + stateCount);
//		System.out.println("I looked " + lookedCount +  " states");
		return this.getSolution();
	}
	

	@Override
	public String getReport() {
		String report = "";
		for (String event : this.log) {
			report += event + '\n';
		}
		return report;
	}

	@Override
	public String status() {
		return "aca se informaria el status";
	}

	@Override
	public IComparable computeValue(AdversaryState state) {
		return this.minMax(state);
	}


}
