package de.thb.dim.pizzaPronto.businessObjects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.ChefVO;
import de.thb.dim.pizzaPronto.valueObjects.EmployeeVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

/**
 * 
 */

/**
 * @author Otto Werse
 *
 */
public class Kitchen implements IService {
	// start of attributes

	private EmployeeVO[] employees;

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public Kitchen() {
		this.employees = new EmployeeVO[1];
		this.employees[0] = new ChefVO("Chef 001", "Paul", "Paul");
	}

	// end of constructors

	// start of methods

	/**
	 * @return the employees
	 */
	public EmployeeVO[] getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(EmployeeVO[] employees) {
		// TODO error handling
		this.employees = employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.IService#startService(valueObjects.OrderVO)
	 */
	@Override
	public String startService(OrderVO order) throws NoOrderException, IllegalStateException {
		if (order != null) {
			if (order.getState().equals(StateOfOrderVO.CONFIRMED)) {
				order.setState(StateOfOrderVO.READY);
				return "Service of ChefVO " + this.employees[0] + ": Order is ready. ";
			} else {
				throw new IllegalStateException("No order for processing available.");
//				return "Service of ChefVO  " + this.employees[0] + ": No order for processing available. ";
			}
		} else {
			throw new NoOrderException("No order available.");
//			return "Service of ChefVO " + this.employees[0] + ": No order available. ";
		}
	}

	// end of methods
}
