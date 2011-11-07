package example_reversi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import engine_framework.SimpleGame;
import engines.MinMaxABSearchEngine;

public class MediadorGUI implements ActionListener {
	
	private ReversiGUI gui;
	private ReversiState gameState;
//	private boolean played = false;
	SimpleGame<ReversiState, MinMaxABSearchEngine<ReversiState>> game;
	
	public MediadorGUI (ReversiState state, SimpleGame<ReversiState, MinMaxABSearchEngine<ReversiState>> game) {
		gameState = state;
		gui = new ReversiGUI();
		gui.changeBoard(gameState);
		this.game = game;
		gui.setListenerButtons(this);
		if (game.getCurrentPlayer() == 1 && game.getPlayer1().startsWith("pc") || game.getCurrentPlayer() == 2 && game.getPlayer2().startsWith("pc")) {
			nextMove();
		}
	}
	
	
	public void start() {
		show();
		while (!gameState.isFinal()) {
			if ((gameState.isMax() && gameState.whiteAvailableMoves.isEmpty()) || (gameState.isMin() && gameState.blackAvailableMoves.isEmpty())) {
				nextMove();
			}
		}
		if (gameState.success()) {
			System.out.println("***Game : el jugador " + (gameState.minWins()?"2":"1") + " gano la partida\n");
		} else {
			System.out.println("***Game : el juego fue empatado\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (game.getCurrentPlayer() == 1 && game.getPlayer1().startsWith("human") || game.getCurrentPlayer() == 2 && game.getPlayer2().startsWith("human")) {
			JButton source = (JButton)arg0.getSource();
			int r = 0;
			int c = 0;
			boolean found = false;
			while (!found && r < 8) {
				if (c == 8) {
					c = 0;
				}
				while(!found && c < 8) {
					found = gui.buttons[r][c] == source;
					if (!found) {
						c++;
					}
				}
				if (!found) {
					r++;
				}
			}
			/*for (r = 0; r < 8 && !found; r++) {
				for (c = 0; c < 8 && !found; c++) {
					found = gui.buttons[r][c] == source;
				}
			}*/
			if (found) {
				gameState.set(c, r, source.getIcon() == gui.blackToken?ReversiToken.BLACK:ReversiToken.WHITE, false);
				setState(gameState);
				gameState = game.move(gameState);
				setState(gameState);
			}
		} else if ((gameState.isMax() && gameState.whiteAvailableMoves.isEmpty()) || (gameState.isMin() && gameState.blackAvailableMoves.isEmpty())) {
			nextMove();
		} else {
			nextMove();
		}
		/*if (gameState.isFinal()) {
			if (gameState.success()) {
			System.out.println("***Game : el jugador " + (gameState.minWins()?"2":"1") + " gano la partida\n");
			} else {
				System.out.println("***Game : el juego fue empatado\n");
			}
		}*/
		//
		// TODO Auto-generated method stub
	}
	
	private void nextMove() {
		if (game.getPlayer1().startsWith("pc")) {
			gameState = game.move(gameState);
			this.setState(gameState);
			if (game.getPlayer2().startsWith("pc")) {
				nextMove();
			}
		}
		if (game.getPlayer2().startsWith("pc")) {
			gameState = game.move(gameState);
			this.setState(gameState);
			if (game.getPlayer1().startsWith("pc")) {
				nextMove();
			}
		}
		if ((gameState.isMax() && gameState.whiteAvailableMoves.isEmpty()) || (gameState.isMin() && gameState.blackAvailableMoves.isEmpty())) {
			nextMove();
		}
	}
	
	public ReversiState getGameState() {
		return gameState;
	}
	
	public void setState(ReversiState state) {
		this.gameState = state;
		this.gui.changeBoard(state);
	}
	
	public void show() {
		gui.setVisible(true);
	}

}
