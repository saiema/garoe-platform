/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example_reversi;

import engine_framework.AdversarySearchEngine;

/**
 *
 * @author BigEma
 */
public class ReversiLogic {
    private AdversarySearchEngine<ReversiState> ai;
    private Model model;
    private int turn;
    private boolean playing;
    
    public ReversiLogic(Model model, AdversarySearchEngine<ReversiState> ai) {
        this.model = model;
        this.ai = ai;
        this.turn = 0;
        this.playing = false;
    }
    
    public void startGame() {
        this.model.startGUI();
    }
    
    
}
