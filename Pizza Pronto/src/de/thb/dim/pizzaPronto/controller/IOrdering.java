package de.thb.dim.pizzaPronto.controller;
/**
 * 
 */

import java.util.List;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

/**
 * @author Otto Werse
 *
 */
public interface IOrdering {
	public OrderVO startNewOrder(CustomerVO customer);

	public void addDish(DishVO dish) throws NoOrderException, IllegalStateException;

	public void deleteDish(DishVO dish) throws NoOrderException, IllegalStateException;

	public float calculateTotalPrice() throws NoOrderException;

	public void confirmOrder()
			throws NullPointerException, IllegalStateException, NoOrderException, NoCustomerException;

	public List<DishVO> sortShoppingBasket() throws NoOrderException;

	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException;

	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException;
}
