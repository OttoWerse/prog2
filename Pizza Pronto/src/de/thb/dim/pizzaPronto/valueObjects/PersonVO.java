package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */


/**
 * @author Otto Werse
 *
 */
public abstract class PersonVO {
	// start of attributes

	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;

	// end of attributes

	// start of constructors

	public PersonVO() {
		this(null, null);
	}

	/**
	 * @param lastName
	 * @param firstName
	 */
	public PersonVO(String lastName, String firstName) {
		this(lastName, firstName, null, 0);
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param street
	 * @param houseNumber
	 */
	public PersonVO(String lastName, String firstName, String street, int houseNumber) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.setStreet(street);
		this.setHouseNumber(houseNumber);
	}

	// end of constructors

	// start of methods

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		// TODO error handling
		this.lastName = lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		// TODO error handling
		this.firstName = firstName;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		// TODO error handling
		this.street = street;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		// TODO error handling
		this.houseNumber = houseNumber;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				PersonVO p = (PersonVO) o;
				b = (this.firstName == p.firstName);
				b &= (this.lastName == p.lastName);
				b &= (this.street == p.street);
				b &= (this.houseNumber == p.houseNumber);
			}
		}
		return b;
	}

	@Override
	public int hashCode() {
		int m = 59;
		int result = 0;
		result = result * m + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = result * m + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = result * m + ((this.street == null) ? 0 : this.street.hashCode());
		result = result * m + ((this.houseNumber == 0) ? 0 : this.houseNumber);
		return result;

	}

	@Override
	public String toString() {
		// TODO toString: String format
		String s = "";
		s += "Name: " + this.firstName + " " + this.lastName + System.lineSeparator();
		s += "Adresse: " + this.street + " " + this.houseNumber;
		return s;
	}

	// end of methods
}
