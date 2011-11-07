/**
 * 
 */
package example_floodit;

import java.util.LinkedList;
import java.util.List;

import engine_framework.IRule;

/**
 * La regla de cambio de estado del flood it
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public class FlooditMoveRule implements IRule<FlooditState> {

	@Override
	public boolean isApplicable(FlooditState state) {
		return !state.isFinal();
	}

	@Override
	public List<FlooditState> apply(FlooditState state) {
		List<FlooditState> succesors = new LinkedList<FlooditState>();
		for (int color = 0; color < state.getColors(); color++) {
			FlooditState newState = state.clone();
			if (color != newState.getColorOfToken(0, 0)) {
				newState.changeColor(color);
				succesors.add(newState);
			}
		}
		return succesors;
	}

}
