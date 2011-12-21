/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_waterjars;

import framework.IRule;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author simon
 */
public class WaterJarsEmptyRule implements IRule<WaterJarsState>{

    @Override
    public boolean isApplicable(WaterJarsState state) {
        return (state.getJar1Cont() > 0) || (state.getJar2Cont() > 0);
    }

    @Override
    public List<WaterJarsState> apply(WaterJarsState state) {
        List<WaterJarsState> succesors = new LinkedList<WaterJarsState>();
        WaterJarsState newState;
        if (state.getJar1Cont() > 0) {
            newState = state.clone();
            newState.emptyJar1();
            succesors.add(newState);
        }
        if (state.getJar2Cont() > 0) {
            newState = state.clone();
            newState.emptyJar2();
            succesors.add(newState);
        }
        return succesors;
    }
    
}
