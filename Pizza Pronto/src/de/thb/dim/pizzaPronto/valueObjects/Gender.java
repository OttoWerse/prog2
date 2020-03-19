/**
 * 
 */
package de.thb.dim.pizzaPronto.valueObjects;

/**
 * @author Otto Werse
 *
 */
public enum Gender {
	M(1), F(2), I(3), U(4);

	// start of attributes

	private int number;

	// end of attributes

	// start of constructors

	private Gender(int i) {
		this.number = i;
	}

	// end of constructors

	// start of methods

	public int toNumber() {
		return this.number;
	}

	@Override
	public String toString() {
		String s = "";
		switch (this.number) {
		case 1:
			s = "male";
			break;
		case 2:
			s = "female";
			break;
		case 3:
			s = "intersex";
			break;
		case 4:
			s = "unknown";
			break;
		}
		return s;
	}

	// end of methods

}
