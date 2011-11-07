package utils;

public class ComparableFloat implements IComparable {
	protected Float value;
	
	public ComparableFloat(Float value) {
		this.value = value;
	}
	
	public void add(ComparableFloat other) {
		this.value += other.value;
	}
	
	public void negative() {
		this.value *= -1;
	}
	
	public void multiply(ComparableFloat other) {
		this.value *= other.value;
	}

	@Override
	public int compareTo(IComparable other) throws NullPointerException {
		return (int) (this.value - ((ComparableFloat)other).value);
	}
	
	public ComparableFloat clone() {
		return new ComparableFloat(this.value);
	}

}
