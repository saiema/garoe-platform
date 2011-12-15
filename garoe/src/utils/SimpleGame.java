package utils;

import framework.AdversarySearchEngine;
import framework.IStateAdversary;
import framework.SearchProblem;

/**
 * <p>Esta clase es solo un ejemplo de como se podría utilizar la plataforma en la implementación de un juego,
 * muestra como debería ser la comunicación con el motor de búsqueda utilizado.</p>
 * <p>En la práctica es mucho mas eficiente y comodo crearse uno mismo las clases necesarias para manejar a la aplicación que utilice
 * a esta plataforma, por dar un ejemplo, en el caso de los juegos utilizar el patrón mvc resulta mucho mas simple, eficiente y rapido
 * de implementar</p>
 * <p>Define una estructura basica para crear un nuevo juego
 * La responsabilidad de cualquier clase que herede de esta, es la de hacer de intermediario entre
 * el motor de busqueda y cualquier interfaz por la que se hacen las jugadas.</p>
 * <b>Si el juego usa un reloj, entonces se debera controlar mediante esta clase y no en el motor</b>
 * <p>Esta clase esta pensada para funcionar con cualquier estado que herede de {@code IStateAdversary}</p>
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1b
 * @see BasicSearchEngine
 * @see SearchProblem
 * @see IRule
 * @see IStateAdversary
 */
public class SimpleGame<AdversaryState extends IStateAdversary, Engine extends AdversarySearchEngine<AdversaryState>> {
	/**
	 * El motor que utilizara el juego
	 */
	protected AdversarySearchEngine<AdversaryState> engine;
	/**
	 * El "juego" con sus reglas y estado inicial
	 */
	protected SearchProblem<AdversaryState> searchProblem;
	protected int difficulty;
	/**
	 * Indica a quien le toca jugar
	 */
	protected int turn; //dos valores 0 y 1, 1 : max, 0 : min
	/**
	 * indica el nombre del jugador min
	 * @see #setMinPlayer(String)
	 */
	protected String player1;
	/**
	 * indica el nombre del jugador max
	 * @see #setMaxPlayer(String)
	 */
	protected String player2;
	/**
	 * indica si se esta jugando
	 */
	protected boolean playing;
	/**
	 * el ultimo estado en el que jugo el jugador min
	 */
	protected AdversaryState last1;
	/**
	 * el ultimo estado en el que jugo el jugador max
	 */
	protected AdversaryState last2;
	
	/**
	 * Constructor de la clase, necesita el "juego" sobre el cual operar y el motor a utilizar
	 * @param searchProblem : representa el juego con sus reglas y estado inicial : {@code SearchProblem<? extends AdversaryState>}
	 * @param engine : representa el motor de busqueda a utilizar : {@code AdversarySearchEngine<? extends IStateAdversary>}
	 */
	public SimpleGame(SearchProblem<AdversaryState> searchProblem, Engine engine) {
		this.searchProblem = searchProblem;
		this.playing = false;
		this.engine = engine;
	}
	
	/**
	 * Indica quien es el jugador Max
	 * @param playerMax : definicion del jugador max : {@code String}
	 * <hr><p><b>la definicion debe ser de la forma {@code <"human"|"pc"><espacio><nombre>} <p>donde pc define que la maquina juega con ese jugador</p></b></p>
	 */
	public void setPlayer2(String player2) {
		if (!playing) this.player2 = player2;
	}
	
	/**
	 * Indica quien es el jugador Min
	 * @param playerMin : definicion del jugador min : {@code String}
	 * <hr><p><b>la definicion debe ser de la forma {@code <"human"|"pc"><espacio><nombre>} <p>donde pc define que la maquina juega con ese jugador</p></b></p>
	 */
	public void setPlayer1(String player1) {
		if (!playing) this.player1 = player1;
	}
	
	/**
	 * @return el nombre del jugador Max en la forma <b>{@code <"human"|"pc">" : "<nombre>}</b> : {@code String}
	 */
	public String getPlayer2() {
		return this.player2;
	}
	
	/**
	 * @return el nombre del jugador Min en la forma <b>{@code <"human"|"pc">" : "<nombre>}</b> : {@code String}
	 */
	public String getPlayer1() {
		return this.player1;
	}
	
	/**
	 * indica que el jugador Max es el que inicia la partida
	 */
	final public void player2Starts() {
		if (!playing) this.turn = 1;
	}
	
	/**
	 * indica que el jugador Min es el que inicia la partida
	 */
	final public void player1Starts() {
		if (!playing) this.turn = 0;
	}
	
	/**
	 * Comienza el juego
	 */
	public void start() {
		this.playing = true;
	}
	
	/**
	 * Realiza una jugada
	 * @param state : la jugada (el nuevo estado luego del movimiento) : {@code AdversaryState extends AdversaryState}
	 * @return {@code state} si la jugada fue valida, {@code null} caso contrario : {@code AdversaryState extends AdversaryState}
	 * <hr><b>utilizar {@code reportLastMove} para conocer cual fue el problema en caso de que este metodo devuelva {@code null}</b>
	 * @see SimpleGame#reportLastMove
	 */
	public AdversaryState move(AdversaryState state) {
		this.searchProblem.setInitialState(state);
		turn = 1 - turn;
		state.changeLevel();
		if ((turn == 0 && this.player1.startsWith("pc")) || (turn == 1 && this.player2.startsWith("pc"))) {
			turn = 1 - turn;
			System.out.println("I'm thinking...");
			AdversaryState nextMove = this.engine.nextMove(state);
			if (nextMove == null) {
				System.out.println("I couldn't think any move =(");
				nextMove = state;
				state.changeLevel();
			}
			return nextMove;
		} else {
			return state;
		}
	}
	
	/**
	 * Realiza una jugada
	 * @param state : la jugada (el nuevo estado luego del movimiento) : {@code AdversaryState extends AdversaryState}
	 * @param needHelp : permite a un jugador humano pedir una movida al motor : {@code boolean}
	 * @return {@code state} si la jugada fue valida, {@code null} caso contrario : {@code AdversaryState extends AdversaryState}
	 * <hr><b>utilizar {@code reportLastMove} para conocer cual fue el problema en caso de que este metodo devuelva {@code null}</b>
	 * @see SimpleGame#reportLastMove
	 * <p><b>se cumple que move(state, false) == move(state)</b></p>
	 */
	public AdversaryState move(AdversaryState state, boolean needHelp) {
		this.searchProblem.setInitialState(state);
		turn = 1 - turn;
		//if (turn == 0) state.setMin(); else state.setMax();
		state.changeLevel();
		if ((turn == 0 && (this.player1.startsWith("pc") || needHelp)) || (turn == 1 && (this.player2.startsWith("pc") || needHelp))) {
			turn = 1 - turn;
			AdversaryState nextMove = this.engine.nextMove(state);
			if (nextMove == null) {
				nextMove = state;
				//if (turn == 0) nextMove.setMin(); else nextMove.setMax();
				state.changeLevel();
			}
			return nextMove;
		} else {
			return state;
		}
	}
	
	/**
	 * Deshace la ultima jugada
	 * @return el estado anterior a que el ultimo jugador hiciera su jugada : {@code AdversaryState extends AdversaryState}
	 * <hr><b>ejemplo : A juega (estado 1), B juega (estado 2), A realiza undo, A debe jugar desde estado 1</b>
	 * <p><b>si no se quiere implementar esta funcion, entonces {@code undo} debe devolver el estado actual y no cambiar nada (turno, tiempo, etc)</b></p>
	 */
	public AdversaryState undo() {
		if (this.turn == 0 && this.last1 != null) {
			this.turn = 1;
			return this.last1;
		} else if (this.turn == 1 && this.last2 != null) {
			this.turn = 0;
			return this.last2;
		} else {
			return null; //TODO PREGUNTAR NAZA
		}
	}
	
	
	/**
	 * Este metodo puede entenderse como un "cambiar de juego"
	 * @param searchProblem : el nuevo "juego" : {@code SearchProblem<? extends AdversaryState>}
	 * <hr><b>este metodo deberia reiniciar todo para comentar con el nuevo juego</b>
	 */
	public void setSearchProblem(SearchProblem<AdversaryState> searchProblem) {
		this.searchProblem = searchProblem;
	}
	
	/**
	 * Setea la dificultad del juego, el motor deberia tratar con dificultades incorrectas
	 * @param difficulty : la dificultad del juego : {@code int}
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
		this.engine.setMaxTreeLevel(difficulty);
	}
	
	/**
	 * @return la dificultad del juego : {@code int}
	 */
	public int getDifficulty() {
		return this.difficulty;
	}
	
	public int getCurrentPlayer() {
		return turn+1;
	}
	
}
