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
public class WaterJarsFillRule implements IRule<WaterJarsState>{

    @Override
    public boolean isApplicable(WaterJarsState state) {
        return (state.getJar1Cont() < state.getJar1Cap()) || (state.getJar2Cont() < state.getJar2Cap());
    }

    @Override
    public List<WaterJarsState> apply(WaterJarsState state) {
        List<WaterJarsState> succesors = new LinkedList<WaterJarsState>();
        WaterJarsState newState;
        if (state.getJar1Cont() < state.getJar1Cap()) {
            newState = state.clone();
            newState.fillJar1();
            succesors.add(newState);
        }
        if (state.getJar2Cont() < state.getJar2Cap()) {
            newState = state.clone();
            newState.fillJar2();
            succesors.add(newState);
        }
        return succesors;
    }
    
}
