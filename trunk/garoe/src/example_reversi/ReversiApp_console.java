/**
 * 
 */
package example_reversi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


import utils.Pair;

import engine_framework.IRule;
import engine_framework.SearchProblem;
import engine_framework.SimpleGame;
import engines.MinMaxABSearchEngine;

/**
 * Aplicacion para jugar reversi
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 * <hr>
 * <p><b>parametros : <"pc"|"human":<nombre p1>> <"pc"|"human":<nombre p2>> <quien empieza 1 o 2> <dificultad></b></p>
 */
public class ReversiApp_console {
//	private static MediadorGUI gui;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReversiState gameState = new ReversiState();
		List<IRule<ReversiState>> reversiRules = new LinkedList<IRule<ReversiState>>();
		reversiRules.add(new ReversiMoveRule());
		SearchProblem<ReversiState> reversi = new SearchProblem<ReversiState>(gameState, reversiRules);
		SimpleGame<ReversiState, MinMaxABSearchEngine<ReversiState>> game = new SimpleGame<ReversiState, MinMaxABSearchEngine<ReversiState>>(reversi, new MinMaxABSearchEngine<ReversiState>(reversi));
		boolean name1Check = false;
		boolean name2Check = false;
		boolean startPlayerCheck = false;
		boolean dificultyCheck = false;
		if (args.length < 4) {
			System.err.println("***Error : uso esperado : ReversiApp <nombre jugador 1> <nombre jugador 2> <quien comienza (1|2)> <dificultad>\n");
			System.exit(1);
		} else {
			if (!args[0].matches("(human|pc):(.+)")) {
				System.err.println("***Error : nombre de jugador 1 no coincide con el formato esperado (<human|pc> : <nombre>)\n");
				System.exit(2);
			} else {
				name1Check = true;
			}
			if (name1Check && !args[1].matches("(human|pc)(' ')*:(' ')*.+")) {
				System.err.println("***Error : nombre de jugador 2 no coincide con el formato esperado (<human|pc> : <nombre>)\n");
				System.exit(2);
			} else {
				name2Check = true;
			}
			Integer startingPlayer = Integer.parseInt(args[2]);
			if (name1Check && name2Check && !(startingPlayer == 1 || startingPlayer == 2)) {
				System.err.println("***Error : el valor de quien empieza debe ser 1 o 2\n");
				System.exit(3);
			} else {
				startPlayerCheck = true;
			}
			Integer dificulty = Integer.parseInt(args[3]);
			if (name1Check && name2Check && startPlayerCheck && !(dificulty > 0)) {
				System.err.println("***Error : la dificultad debe ser positiva (>0)\n");
				System.exit(4);
			} else {
				dificultyCheck = true;
			}
		}
		if (name1Check && name2Check && startPlayerCheck && dificultyCheck) {
			game.setPlayer1(args[0]);
			game.setPlayer2(args[1]);
			game.setDifficulty(Integer.parseInt(args[3]));
			if (Integer.parseInt(args[2]) == 1) {
				game.player1Starts();
				gameState.setMax();
			} else {
				game.player2Starts();
				gameState.setMin();
			}
			game.start();
			while (!gameEnded(gameState)) {
				//ACA SE CONTROLA EL JUEGO
				//HACER UNA INTERFAZ (POR CONSOLA EN PRINCIPIO)
				showBoard(gameState);
				if (game.getCurrentPlayer() == 1) {
					if (game.getPlayer1().startsWith("pc")) {
						gameState = game.move(gameState);
					} else {
						//INTERFAZ PARA HACER EL SIGUIENTE MOVIMIENTO
						playerMoves(gameState);
						gameState = game.move(gameState);
					}
				} else {
					if (game.getPlayer2().startsWith("pc")) {
						gameState = game.move(gameState);
					} else {
						//INTERFAZ PARA HACER EL SIGUIENTE MOVIMIENTO
						playerMoves(gameState);
						gameState = game.move(gameState);
					}
				}
			}
			showBoard(gameState);
			if (gameState.success()) {
				System.out.println("***Game : el jugador " + (gameState.maxWins()?"1":"2") + " gano la partida\n");
			} else {
				System.out.println("***Game : el juego fue empatado\n");
			}
		}
	}
	
	
	static private boolean gameEnded(ReversiState gameState) {
		boolean gameEnded = false;
		if (gameState.blackAvailableMoves.isEmpty() && gameState.whiteAvailableMoves.isEmpty()) {
			gameEnded = true;
		}
		return gameEnded;
	}
	
	static private void showBoard(ReversiState gameState) {
		System.out.println(gameState.toString());
		System.out.println();
		for (Pair<Integer,Integer> move : (gameState.isMax()?gameState.whiteAvailableMoves:gameState.blackAvailableMoves)) {
			System.out.println(move.toString());
		}
	}
	
	static private void playerMoves(ReversiState gameState) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			boolean canMove = gameState.isMax()? !gameState.whiteAvailableMoves.isEmpty():!gameState.blackAvailableMoves.isEmpty();
			if (canMove) {
				String input = br.readLine();
				if (input.matches("[0-7],[0-7]")) {
					String[] values = input.split(",");
					Integer c = Integer.parseInt(values[0]);
					Integer r = Integer.parseInt(values[1]);
					Pair<Integer,Integer> move = new Pair<Integer,Integer>(c,r);
					if (gameState.isMax()) {
						if (validMove(move, gameState.whiteAvailableMoves)) {
							gameState.set(r, c, 1, false);
						} else {
							System.err.println("***Error : movida invalida\n");
							playerMoves(gameState);
						}
						
					} else { //MIN
						if (validMove(move, gameState.blackAvailableMoves)) {
							gameState.set(r, c, -1, false);
						} else {
							System.err.println("***Error : movida invalida\n");
							playerMoves(gameState);
						}
					}
				} else {
					System.err.println("***Error : coordenadas invalidad : <columna>,<fila>\n");
					playerMoves(gameState);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static private boolean validMove(Pair<Integer,Integer> move, List<Pair<Integer,Integer>> moves) {
		boolean found = false;
		for (int index = 0; index < moves.size() && !found; index++) {
			Pair<Integer,Integer> current = moves.get(index);
			found = (current.getFirstElem() == move.getFirstElem()) && (current.getSecondElem() == move.getSecondElem());
		}
		return found;
	}

}
