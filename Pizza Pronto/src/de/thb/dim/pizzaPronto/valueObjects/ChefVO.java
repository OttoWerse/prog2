package de.thb.dim.pizzaPronto.valueObjects;

import java.awt.Color;

/**
 * @author Otto Werse
 *
 */
public class ChefVO extends EmployeeVO {
	// start of attributes

	private Color colorApron;

	// end of attributes

	// start of constructors
	public ChefVO() {
		this(null, null, null);
	}

	/**
	 * @param lastName
	 * @param firstName
	 */
	public ChefVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName, firstName);
		this.setColorApron(new Color(255, 255, 255));
	}

	// end of constructors

	// start of methods

	/**
	 * @param colorApron the colorApron to set
	 */
	public void setColorApron(Color colorApron) {
		// TODO error handling
		this.colorApron = colorApron;
	}

	/**
	 * @return the colorApron
	 */
	public Color getColorApron() {
		return this.colorApron;
	}

	@Override
	public String toString() {
		String s = "";
		s += super.toString() + System.lineSeparator();
		s += "Rolle: Koch" + System.lineSeparator();
		s += "Schürze: " + this.colorApron;
		return s;
	}
	// end of methods
}
