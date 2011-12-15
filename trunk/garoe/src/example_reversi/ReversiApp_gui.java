/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import framework.AdversarySearchEngine;
import framework.IRule;
import framework.SearchProblem;
import engines.MinMaxABSearchEngine;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author BigEma
 */
public class ReversiApp_gui {
    
    public static void main(String[] args) {
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
        gui.init();
        //logic.startGame();
    }
}
