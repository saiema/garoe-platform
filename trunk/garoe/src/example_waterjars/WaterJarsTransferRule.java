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
public class WaterJarsTransferRule implements IRule<WaterJarsState>{

    @Override
    public boolean isApplicable(WaterJarsState state) {
        boolean canTransferToJar1 = state.getJar2Cont()==0?false:state.getJar1Cont() < state.getJar1Cap();
        boolean canTransferToJar2 = state.getJar1Cont()==0?false:state.getJar2Cont() < state.getJar2Cap();
        return canTransferToJar1 || canTransferToJar2;
    }

    @Override
    public List<WaterJarsState> apply(WaterJarsState state) {
        List<WaterJarsState> succesors = new LinkedList<WaterJarsState>();
        WaterJarsState newState;
        if (state.getJar2Cont()==0?false:state.getJar1Cont() < state.getJar1Cap()) {
            newState = state.clone();
            newState.transferToJar1();
            succesors.add(newState);
        }
        if (state.getJar1Cont()==0?false:state.getJar2Cont() < state.getJar2Cap()) {
            newState = state.clone();
            newState.transferToJar2();
            succesors.add(newState);
        }
        return succesors;
    }
    
}
