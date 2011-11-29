package utils;

/**
 * Implementacion de {@code IComparable} para {@code Integer}
 * @author Carla Noelia Fiori, Simón Emmanuel Gutiérrez Brida
 * @version 0.1
 * @see IComparable
 */
public class ComparableInt implements IComparable {
	protected Integer value;
	
	public ComparableInt(Integer value) {
		this.value = value;
	}
	
	public void add(ComparableInt other) {
		this.value += other.value;
	}
	
	public void negative() {
		this.value *= -1;
	}
	
	public void multiply(ComparableInt other) {
		this.value *= other.value;
	}

	@Override
	public int compareTo(IComparable other) throws NullPointerException {
		if (this.value < ((ComparableInt)other).value) {
			return -1;
		} else if (this.value > ((ComparableInt)other).value) {
			return 1;
		} else {
			return 0;
		}
		//return this.value - ((ComparableInt)other).value;
	}
	
	public String toString() {
		String res = Integer.toString(this.value);
		return res;
	}
	
	public IComparable clone() {
		return new ComparableInt(this.value);
	}

}
