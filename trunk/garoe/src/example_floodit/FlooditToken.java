/**
 * 
 */
package example_floodit;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Un bloque del flood it
 * @author Carla Noelia Fiori, Simon Emmanuel Gutierrez Brida
 * @version 0.1
 */
public final class FlooditToken {
	private int color;
	private List<FlooditToken> neighbours;
	
	public FlooditToken(int color) {
		this.color = color;
		this.neighbours = new LinkedList<FlooditToken>();
	}
	
	public int changeColor(int color) {
		int tokensChanged = 0;
		if (this.color != color) {
			tokensChanged = 1;
			int oldColor = this.color;
			this.color = color;
			for (FlooditToken neighbour : neighbours) {
				if ((neighbour.getColor() == oldColor)) {
					tokensChanged += neighbour.changeColor(color);
				}
			}
		}
		return tokensChanged;
	}
	
	public int checkSameColors(Set<FlooditToken> visited) {
		int sameColors = 1;
		visited.add(this);
		for (FlooditToken neighbour : neighbours) {
			if ((neighbour.getColor() == this.color) && !visited.contains(neighbour)) {
				sameColors += neighbour.checkSameColors(visited);
			}
		}
		return sameColors;
	}
	
	public String toString() {
		String res = "Color: ";
		if (this.color == FlooditState.amarillo) {
			res += "amarillo";
		} else if (this.color == FlooditState.azul) {
			res += "azul";
		} else if (this.color == FlooditState.verde) {
			res += "verde";
		} else if (this.color == FlooditState.rosa) {
			res += "rosa";
		} else if (this.color == FlooditState.rojo) {
			res += "rojo";
		} else if (this.color == FlooditState.celeste) {
			res += "celeste";
		}
		res += " vecinos: " + this.neighbours.size();
		return res;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public void addNeighbour(FlooditToken token) {
		if (!this.neighbours.contains(token)) {
			this.neighbours.add(token);
		}
	}
	
	public int getColor() {
		return color;
	}
	
}
