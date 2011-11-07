package example_reversi;

import java.util.List;

import utils.Pair;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("termine");
		ReversiState s = new ReversiState();
		/*s.set(4, 2, ReversiToken.WHITE, true);
		s.set(3, 2, ReversiToken.BLACK, true);
		s.set(2, 1, ReversiToken.WHITE, true);
		s.set(5, 2, ReversiToken.BLACK, true);*/
		for (int m = 0; m < 12; m++) {
			List<Pair<Integer,Integer>> moves = s.isMax()?s.whiteAvailableMoves:s.blackAvailableMoves;
			s.set(moves.get(moves.size()-1).getSecondElem(), moves.get(moves.size()-1).getFirstElem(), s.isMax()?ReversiToken.WHITE:ReversiToken.BLACK, true);
		}
		System.out.println(s.toString());
		System.out.println("EVALUACION DEL ESTADO : " + s.evaluate().toString());
	}

}
