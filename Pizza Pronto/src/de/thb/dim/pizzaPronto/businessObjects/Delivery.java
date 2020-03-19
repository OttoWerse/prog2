package de.thb.dim.pizzaPronto.businessObjects;

import java.time.LocalDateTime;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DeliveryManVO;
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
public class Delivery implements IService {
	// start of attributes

	private EmployeeVO[] employees;

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public Delivery() {
		super();
		this.employees = new EmployeeVO[2];
		this.employees[0] = new DeliveryManVO();
		this.employees[1] = new DeliveryManVO();
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
	public String startService(OrderVO order) throws NoOrderException, NoCustomerException, IllegalStateException {
		EmployeeVO e = this.selectEmployee();
		if (order != null) {
			CustomerVO c = order.getCustomer();
			if (c != null) {
				if (order.getState().equals(StateOfOrderVO.READY)) {
					order.setState(StateOfOrderVO.DELIVERED);
					return ("Drive to customer" + System.lineSeparator() + "Service of DeliveryManVO " + e
							+ ": Order is delivered on " + LocalDateTime.now());
				} else {
					throw new IllegalStateException("No order is ready for processing.");
//					return ("Service of DeliveryManVO " + e + ": No order is ready for processing. ");
				}
			} else {
				throw new NoCustomerException("No customer available.");
//				return ("Service of DeliveryManVO " + e + ": No customer available. ");
			}
		} else {
			throw new NoOrderException("No order available.");
//			return ("Service of DeliveryManVO " + e + ": No order available. ");
		}
	}

	private EmployeeVO selectEmployee() {
		double d = Math.random();
		if (d < 0.5) {
			return employees[0];
		} else {
			return employees[1];
		}
	}

	// end of methods
}
