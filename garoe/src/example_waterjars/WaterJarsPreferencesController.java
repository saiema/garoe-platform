/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_waterjars;

/**
 *
 * @author simon
 */
public class WaterJarsPreferencesController {
    private WaterJarsMainController mainController;
    private StatePreferencesGUI gui;
    private WaterJarsState state;
    
    public WaterJarsPreferencesController(WaterJarsMainController mainController, StatePreferencesGUI gui) {
        this.mainController = mainController;
        this.gui = gui;
        this.state = this.mainController.getState();
    }
    
    public void show() {
        this.mainController.hide();
        this.gui.setEnabled(true);
        this.gui.setVisible(true);
        this.gui.update(state);
    }
    
    public void exit() {
        this.gui.setFocusable(false);
        this.gui.setVisible(false);
        this.gui.dispose();
        this.mainController.show();
    }
    
    public void save() {
        this.mainController.setNewState(this.state);
        exit();
    }
    
    
    public void changeJar1Cap(int newCap) {
        this.state.setJar1Cap(newCap);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar2Cap(int newCap) {
        this.state.setJar2Cap(newCap);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar1Cont(int newCont) {
        this.state.setJar1Cont(newCont);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar2Cont(int newCont) {
        this.state.setJar2Cont(newCont);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar1isUsed(boolean isUsed) {
        this.state.setUseJar1InGoal(isUsed);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar2isUsed(boolean isUsed) {
        this.state.setUseJar2InGoal(isUsed);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeAnyJarIsUsed(boolean isUsed) {
        this.state.setUseAnyJarInGoal(isUsed);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar1Goal(int newGoal) {
        this.state.setJar1Goal(newGoal);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeJar2Goal(int newGoal) {
        this.state.setJar2Goal(newGoal);
        this.gui.enableSave(state.repOk());
    }
    
    public void changeGeneralGoal(int newGoal) {
        this.state.setGeneralGoal(newGoal);
        this.gui.enableSave(state.repOk());
    }
    
    
    
    
    
}
