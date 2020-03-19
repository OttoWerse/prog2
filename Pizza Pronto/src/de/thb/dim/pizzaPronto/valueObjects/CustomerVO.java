package de.thb.dim.pizzaPronto.valueObjects;

import java.io.Serializable;

/**
 * 
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerNoDateOfBirthException;
import de.thb.dim.pizzaPronto.valueObjects.exceptions.CustomerTooYoungException;

/**
 * @author Otto Werse
 *
 */
public class CustomerVO extends PersonVO implements Serializable {

	// start of attributes

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gender Gender;
	private LocalDate dateOfBirth;
	private final int id;
	private static int nextID = 0;
	private OrderVO order;

	// end of attributes

	// start of constructors

	/**
	 * @param lastName
	 * @param firstName
	 * @param dateOfBirth
	 * @throws CustomerTooYoungException
	 * @throws NullPointerException
	 */
	public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth)
			throws NullPointerException, CustomerTooYoungException {
		this(lastName, firstName, null, dateOfBirth);
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param gender
	 * @param dateOfBirth
	 * @throws CustomerTooYoungException
	 * @throws NullPointerException
	 */
	public CustomerVO(String lastName, String firstName, Gender gender, LocalDate dateOfBirth)
			throws NullPointerException, CustomerTooYoungException {
		this(lastName, firstName, null, 0, gender, dateOfBirth);
	}

	/**
	 * @param lastName
	 * @param firstName
	 * @param gender
	 * @param dateOfBirth
	 * @param street
	 * @param houseNumber
	 * @throws CustomerTooYoungException
	 * @throws NullPointerException
	 */
	public CustomerVO(String lastName, String firstName, String street, int houseNumber, Gender gender,
			LocalDate dateOfBirth) throws NullPointerException, CustomerTooYoungException {
		super(lastName, firstName, street, houseNumber);
		this.setGender(gender);
		this.setDateOfBirth(dateOfBirth);
		this.id = CustomerVO.getNextId();
		this.increaseNextID();
	}

	// end of constructors

	// start of methods

	/**
	 * @return the order
	 */
	public OrderVO getOrder() {
		return order;
	}

	/**
	 * @return the nextID
	 */
	public static int getNextId() {
		return nextID;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return this.Gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(OrderVO order) {
		// TODO error handling
		this.order = order;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		// TODO error handling
		Gender = gender;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 * @throws CustomerTooYoungException
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) throws NullPointerException, CustomerTooYoungException {
		Objects.requireNonNull(dateOfBirth, "dob must not be null");
		if (Period.between(dateOfBirth, LocalDate.now()).getYears() > 17) {
			this.dateOfBirth = dateOfBirth;
		} else {
			throw new CustomerTooYoungException("Customer is not an adult. ");
		}
	}

	/**
	 * @return if the customer has an order
	 */
	public boolean hasOrder() {
		// TODO hasOrder: Test method
		return this.order.getCustomer().equals(this);
	}

	public void increaseNextID() {
		CustomerVO.nextID++;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				CustomerVO p = (CustomerVO) o;
				b = (this.id == p.id);
			}
		}
		return b;
	}

	@Override
	public int hashCode() {
		int m = 59;
		return this.id * m;
		/*
		 * return this.firstName.hashCode() * m + this.lastName.hashCode() * m +
		 * this.Gender.hashCode() * m + this.dateOfBirth.hashCode() * m;
		 */
	}

	@Override
	public String toString() {
		String s = "";
		s += "ID: " + this.id + System.lineSeparator();
		s += super.toString() + System.lineSeparator();
		try {
			s += "Alter: " + this.calculateAge() + "(Geb. " + this.dobToString() + ")" + System.lineSeparator();
		} catch (CustomerNoDateOfBirthException e) {
			System.err.println(e.getMessage());
		}
//		if (this.order != null) {
//			s += this.order;
//		} else {
//			s += "Keine Bestellung vorhanden";
//		}
		return s;
	}

	private String dobToString() throws CustomerNoDateOfBirthException {
		if (this.dateOfBirth != null) {
			return this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
		} else {
			throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
		}
	}

	public short calculateAge() throws CustomerNoDateOfBirthException {
		if (this.dateOfBirth != null) {
			return (short) Period.between(this.dateOfBirth, LocalDate.now()).getYears();
		} else {
			throw new CustomerNoDateOfBirthException("Internal error: No date of birth.");
		}
	}

	// end of methods
}
