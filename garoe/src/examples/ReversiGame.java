/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import framework.AdversarySearchEngine;
import framework.IRule;
import framework.SearchProblem;
import engines.MinMaxABSearchEngine;
import example_reversi.Model;
import example_reversi.ReversiController;
import example_reversi.ReversiGUI;
import example_reversi.ReversiLogic;
import example_reversi.ReversiMoveRule;
import example_reversi.ReversiState;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author BigEma
 */
public class ReversiGame {
    private GaroePlaygroundController mainController;
    
    public ReversiGame(GaroePlaygroundController mainController) {
        this.mainController = mainController;
    }
    
    
    public void start() {
        ReversiGUI gui = new ReversiGUI();
        ReversiState gameState = new ReversiState();
        Model model = new Model(gameState, gui);
        List<IRule<ReversiState>> reversiRules = new LinkedList<IRule<ReversiState>>();
        reversiRules.add(new ReversiMoveRule());
        SearchProblem<ReversiState> reversiProblem = new SearchProblem<ReversiState>(gameState, reversiRules);
        AdversarySearchEngine<ReversiState> ai = new MinMaxABSearchEngine<ReversiState>(reversiProblem);
        ReversiLogic logic = new ReversiLogic(model,ai);
        ReversiController controller = new ReversiController(logic);
        gui.setController(controller);
        controller.setMainController(mainController);
        gui.init();
    }
}
