package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */


/**
 * @author Otto Werse
 *
 */
public abstract  class EmployeeVO extends PersonVO {
	// start of attributes

	protected String personnelNo;
	protected int salary;
	protected int vacationDays;

	// end of attributes

	// start of constructors

	public EmployeeVO() {
		this(null, null, null);
	}

	/**
	 * @param personnelNo
	 * @param lastName
	 * @param firstName
	 */
	public EmployeeVO(String personnelNo, String lastName, String firstName) {
		super(lastName, firstName);
		this.setPersonnelNo(personnelNo);
	}

	// end of constructors

	// start of methods

	/**
	 * @return the personelNo
	 */
	public String getPersonnelNo() {
		return personnelNo;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @return the vacatonDays
	 */
	public int getVacatonDays() {
		return vacationDays;
	}

	/**
	 * @param personelNo the personelNo to set
	 */
	public void setPersonnelNo(String personnelNo) {
		// TODO error handling
		this.personnelNo = personnelNo;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		// TODO error handling
		if (salary >= 0) {

			this.salary = salary;
		} else {
			this.salary = -1;
		}
	}

	/**
	 * @param vacationDays the vacationDays to set
	 */
	public void setVacationDays(int vacationDays) {
		// TODO error handling
		if (vacationDays >= 0) {
			this.vacationDays = vacationDays;
		} else {
			this.vacationDays = -1;
		}
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				EmployeeVO p = (EmployeeVO) o;
				b = (this.personnelNo.equals(p.personnelNo));
			}
		}
		return b;
	}

	@Override
	public int hashCode() {
		int m = 59;
		return this.personnelNo.hashCode() * m;
	}

	@Override
	public String toString() {
		String s = "";
		s += "No: " + this.personnelNo + System.lineSeparator();
		s += super.toString() + System.lineSeparator();
		s += "Gehalt: " + this.salary + " €" + System.lineSeparator();
		s += "Urlaub: " + this.vacationDays + " Tage";
		return s;
	}

	// end of methods
}
