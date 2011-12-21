/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_waterjars;

import framework.IBasicState;

/**
 *
 * @author simon
 */
public class WaterJarsState implements IBasicState{
    private int jar1Cap;
    private int jar2Cap;
    private int jar1Cont;
    private int jar2Cont;
    private boolean useJar1InGoal;
    private boolean useJar2InGoal;
    private boolean useAnyJarInGoal;
    private int jar1Goal;
    private int jar2Goal;
    private int goal;
    public String lastStepDone;
    
    public WaterJarsState() {
        this.jar1Cap = 4;
        this.jar2Cap = 3;
        this.jar1Cont = 0;
        this.jar2Cont = 0;
        this.useAnyJarInGoal = false;
        this.useJar1InGoal = true;
        this.useJar2InGoal = false;
        this.jar1Goal = 2;
    }
    
    public boolean setState(int jar1Cap, int jar2Cap, int jar1Cont, int jar2Cont) {
        this.jar1Cap = jar1Cap;
        this.jar2Cap = jar2Cap;
        this.jar1Cont = jar1Cont;
        this.jar2Cont = jar2Cont;
        return this.repOk();
    }
    
    public boolean setSpecificJarsGoal(boolean useJar1, boolean useJar2, int jar1Goal, int jar2Goal) {
        this.useJar1InGoal = useJar1;
        this.useJar2InGoal = useJar2;
        this.useAnyJarInGoal = false;
        this.jar1Goal = jar1Goal;
        this.jar2Goal = jar2Goal;
        return this.repOk();
    }
    
    public boolean setGeneralGoal(int goal) {
        this.goal = goal;
        this.useAnyJarInGoal = true;
        this.useJar1InGoal = false;
        this.useJar2InGoal = false;
        return this.repOk();
    }
    
    public void emptyJar1() {
        this.jar1Cont = 0;
        this.lastStepDone = "empty1";
    }
    
    public void emptyJar2() {
        this.jar2Cont = 0;
        this.lastStepDone = "empty2";
    }
    
    public void fillJar1() {
        this.jar1Cont = this.jar1Cap;
        this.lastStepDone = "fill1";
    }
    
    public void fillJar2() {
        this.jar2Cont = this.jar2Cap;
        this.lastStepDone = "fill2";
    }
    
    public void transferToJar2() {
        int jar2freeSpace = this.jar2Cap - this.jar2Cont;
        int availableWater = Math.min(this.jar1Cont, jar2freeSpace);
        this.jar1Cont -= availableWater;
        this.jar2Cont += availableWater;
        this.lastStepDone = "transfer2";
    }
    
    public void transferToJar1() {
        int jar1freeSpace = this.jar1Cap - this.jar1Cont;
        int availableWater = Math.min(this.jar2Cont, jar1freeSpace);
        this.jar2Cont -= availableWater;
        this.jar1Cont += availableWater;
        this.lastStepDone = "transfer1";
    }
    
    public boolean getJar1isUsed() {
        return this.useJar1InGoal;
    }
    
    public boolean getJar2isUsed() {
        return this.useJar2InGoal;
    }
    
    public boolean getAnyJarIsUsed() {
        return this.useAnyJarInGoal;
    }

    public int getJar1Cap() {
        return jar1Cap;
    }

    public int getJar1Cont() {
        return jar1Cont;
    }

    public int getJar1Goal() {
        return jar1Goal;
    }

    public int getJar2Cap() {
        return jar2Cap;
    }

    public int getJar2Cont() {
        return jar2Cont;
    }

    public int getJar2Goal() {
        return jar2Goal;
    }
    
    public int getGoal() {
        return this.goal;
    }

    @Override
    public boolean isFinal() {
        return this.success();
    }

    @Override
    public boolean success() {
        if (this.useAnyJarInGoal) {
            return (this.jar1Cont == this.goal) || (this.jar2Cont == this.goal);
        } else {
            boolean result = true;
            if (this.useJar1InGoal) {
                result &= this.jar1Cont == this.jar1Goal;
            }
            if (this.useJar2InGoal) {
                result &= this.jar2Cont == this.jar2Goal;
            }
            return result;
        }
    }

    @Override
    public boolean repOk() {
        boolean jar1Ok = this.jar1Cap > 0 && (this.jar1Cont >= 0 && this.jar1Cont <= this.jar1Cap);
        boolean jar2Ok = this.jar2Cap > 0 && (this.jar2Cont >= 0 && this.jar2Cont <= this.jar2Cap);
        boolean jar1GoalOk = this.useJar1InGoal?(this.jar1Goal >= 0 && this.jar1Goal <= this.jar1Cap):true;
        boolean jar2GoalOk = this.useJar2InGoal?(this.jar2Goal >= 0 && this.jar2Goal <= this.jar2Cap):true;
        boolean goalOk = this.useAnyJarInGoal?(this.goal >= 0 && ((this.goal <= this.jar1Cap)||(this.goal <= this.jar2Cap))):true;
        return jar1Ok && jar2Ok && jar1GoalOk && jar2GoalOk && goalOk && ((this.useJar1InGoal || this.useJar2InGoal) ^ this.useAnyJarInGoal);
    }
    
    
    @Override
    public WaterJarsState clone() {
        WaterJarsState newState = new WaterJarsState();
        newState.goal = this.goal;
        newState.jar1Cap = this.jar1Cap;
        newState.jar1Cont = this.jar1Cont;
        newState.jar1Goal = this.jar1Goal;
        newState.jar2Cap = this.jar2Cap;
        newState.jar2Cont = this.jar2Cont;
        newState.jar2Goal = this.jar2Goal;
        newState.useAnyJarInGoal = this.useAnyJarInGoal;
        newState.useJar1InGoal = this.useJar1InGoal;
        newState.useJar2InGoal = this.useJar2InGoal;
        return newState;
    }
    
    
    //SETTERS

    public void setJar1Cap(int jar1Cap) {
        this.jar1Cap = jar1Cap;
    }

    public void setJar1Cont(int jar1Cont) {
        this.jar1Cont = jar1Cont;
    }

    public void setJar1Goal(int jar1Goal) {
        this.jar1Goal = jar1Goal;
    }

    public void setJar2Cap(int jar2Cap) {
        this.jar2Cap = jar2Cap;
    }

    public void setJar2Cont(int jar2Cont) {
        this.jar2Cont = jar2Cont;
    }

    public void setJar2Goal(int jar2Goal) {
        this.jar2Goal = jar2Goal;
    }

    public void setUseAnyJarInGoal(boolean useAnyJarInGoal) {
        this.useAnyJarInGoal = useAnyJarInGoal;
    }

    public void setUseJar1InGoal(boolean useJar1InGoal) {
        this.useJar1InGoal = useJar1InGoal;
    }

    public void setUseJar2InGoal(boolean useJar2InGoal) {
        this.useJar2InGoal = useJar2InGoal;
    }
    
    @Override
    public boolean equals(Object o) {
        WaterJarsState other = (WaterJarsState)o;
        boolean jar1CapEquals = this.jar1Cap == other.jar1Cap;
        boolean jar2CapEquals = this.jar2Cap == other.jar2Cap;
        boolean jar1ContEquals = this.jar1Cont == other.jar1Cont;
        boolean jar2ContEquals = this.jar2Cont == other.jar2Cont;
        return jar1CapEquals && jar2CapEquals && jar1ContEquals && jar2ContEquals;
    }
    
}
