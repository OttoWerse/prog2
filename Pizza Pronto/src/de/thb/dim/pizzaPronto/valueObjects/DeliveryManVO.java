package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */


/**
 * @author Otto Werse
 *
 */
public class DeliveryManVO extends EmployeeVO {
	// start of attributes

	private String driverLicence;

	// end of attributes

	// start of constructors

	/**
	 * @param driverLicence
	 */
	public DeliveryManVO() {
		super();
	}

	/**
	 * @param driverLicence
	 */
	public DeliveryManVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName, firstName);
	}

	// end of constructors

	// start of methods

	/**
	 * @return the driverLicence
	 */
	public String getDriverLicence() {
		return driverLicence;
	}

	/**
	 * @param driverLicence the driverLicence to set
	 */
	public void setDriverLicence(String driverLicence) {
		// TODO error handling
		this.driverLicence = driverLicence;
	}

	@Override
	public String toString() {
		String s = "";
		s += super.toString() + System.lineSeparator();
		s += "Rolle: Lieferrant" + System.lineSeparator();
		s += "Führerschein: " + this.driverLicence;
		return s;
	}

	// end of methods
}
