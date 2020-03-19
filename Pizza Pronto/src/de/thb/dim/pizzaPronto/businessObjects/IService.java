package de.thb.dim.pizzaPronto.businessObjects;
/**
 * 
 */

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.*;

/**
 * @author Otto Werse
 *
 */
public interface IService {
	public String startService(OrderVO order)
			throws NoOrderException, NoCustomerException, NullPointerException, IllegalStateException;
}
