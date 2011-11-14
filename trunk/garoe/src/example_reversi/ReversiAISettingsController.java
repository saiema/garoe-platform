/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

/**
 *
 * @author BigEma
 */
public class ReversiAISettingsController {
    private ReversiLogic logic;
    private AIgui aigui;
    
    public ReversiAISettingsController(ReversiLogic logic) {
        this.logic = logic;
        this.aigui = new AIgui();
        this.aigui.setController(this);
        this.aigui.getTreeLevelSpinner().setValue(this.logic.getAI().getMaxTreeLevel());
    }
    
    public void show() {
        this.aigui.setEnabled(true);
        this.aigui.setVisible(true);
    }
    
    public void save(String engine, int maxTreeLevel, int maxSearchTime, int maxSearchNodes) {
        //SE PUEDE AGREGAR CODIGO PARA CAMBIAR EL RESTO DE LOS VALORES
        this.logic.getAI().setMaxTreeLevel(maxTreeLevel);
        close();
    }
    
    public void close() {
        this.logic.getModel().getGui().setEnabled(true);
        this.logic.getModel().getGui().setFocusable(true);
        this.aigui.dispose();
    }
    
    
}
