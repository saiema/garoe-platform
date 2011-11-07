/**
 * 
 */
package example_reversi;

import java.util.LinkedList;
import java.util.List;

import utils.Pair;

import engine_framework.IRule;

/**
 * La unica regla del reversi, colocar una ficha en una casilla habilitada
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public class ReversiMoveRule implements IRule<ReversiState> {

	@Override
	public boolean isApplicable(ReversiState state) {
		return !state.isFinal();
	}

	@Override
	public List<ReversiState> apply(ReversiState state) {
		List<ReversiState> newStates = new LinkedList<ReversiState>();
		int color = state.iamMax? ReversiToken.WHITE:ReversiToken.BLACK;
		List<Pair<Integer,Integer>> moves = state.iamMax?state.whiteAvailableMoves:state.blackAvailableMoves;
		for (Pair<Integer,Integer> availableMove : moves) {
			ReversiState newState = state.clone();
			newState.set(availableMove.getSecondElem(), availableMove.getFirstElem(), color,true);
			newStates.add(newState);
		}
		return newStates;
	}

}
