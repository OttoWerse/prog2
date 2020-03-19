package de.thb.dim.pizzaPronto.valueObjects;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author Otto Werse
 *
 */
public class OrderVO implements Serializable {

	// start of attributes

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderNo;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private List<DishVO> shoppingBasket;
	private CustomerVO customer;
	private StateOfOrderVO state;

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public OrderVO() {
		this(0, null, null, null);
	}

	/**
	 * @param timestampStartedOrder
	 */
	public OrderVO(int orderNo, StateOfOrderVO state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
		super();
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		this.setOrderNo(orderNo);
		this.setShoppingBasket(new LinkedList<DishVO>());
		this.setState(state);
	}

	// end of constructors

	// start of methods

	/**
	 * @return the timestampStartedOrder
	 */
	public LocalDateTime getTimestampStartedOrder() {
		return this.timestampStartedOrder;
	}

	/**
	 * @return the timestampDeliveredOrder
	 */
	public LocalDateTime getTimestampDeliveredOrder() {
		return this.timestampDeliveredOrder;
	}

	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return this.orderNo;
	}

	/**
	 * @return the customer
	 */
	public CustomerVO getCustomer() {
		return customer;
	}

	/**
	 * @return the state
	 */
	public StateOfOrderVO getState() {
		return state;
	}

	/**
	 * @param index the index of the PizzaVO to get from shoppingBasket
	 * @returns a DishVO object form shoppingBasket
	 */
	public DishVO getDish(int index) {
		if (index < this.shoppingBasket.size()) {
			return this.shoppingBasket.get(index);
		} else {
			return null;
		}
	}

	/**
	 * @returns the number of dishes in shoppingBasket
	 */
	public int getNumberOfDishes() {
		return this.shoppingBasket.size();
	}

	/**
	 * @return the shoppingBasket
	 */
	public List<DishVO> getShoppingBasket() {
		return shoppingBasket;
	}

	/**
	 * @param shoppingBasket the shoppingBasket to set
	 */
	public void setShoppingBasket(List<DishVO> shoppingBasket) {
		// TODO error handling
		this.shoppingBasket = shoppingBasket;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(int orderNo) {
		// TODO error handling
		this.orderNo = orderNo;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(StateOfOrderVO state) {
		// TODO error handling
		this.state = state;
	}

	/**
	 * @param timestampStartedOrder the timestampStartedOrder to set
	 */
	public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {
		// TODO error handling
		this.timestampStartedOrder = timestampStartedOrder;
	}

	/**
	 * @param timestampDeliveredOrder the timestampDeliveredOrder to set
	 */
	public void setTimestampDeliveredOrder(LocalDateTime timestampDeliveredOrder) {
		// TODO error handling
		this.timestampDeliveredOrder = timestampDeliveredOrder;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(CustomerVO customer) {
		// TODO error handling
		this.customer = customer;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				OrderVO p = (OrderVO) o;
				b = (this.orderNo == p.orderNo);
			}
		}
		return b;
	}

	@Override
	public int hashCode() {
		int m = 59;
		int result = 1;
		result = result * m + this.orderNo;
//		result = result * m + ((this.timestampDeliveredOrder == null) ? 0 : this.timestampDeliveredOrder.hashCode());
//		result = result * m + ((this.timestampStartedOrder == null) ? 0 : this.timestampStartedOrder.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String shoppingBasket = "no dishes";
		if (this.shoppingBasket != null) {
			shoppingBasket = "";
			for (int i = 0; i < this.shoppingBasket.size(); i++) {
				if (this.shoppingBasket.get(i) != null) {
					shoppingBasket += this.shoppingBasket.get(i) + System.lineSeparator();
				}
			}
		}
		return "Bestellung " + this.orderNo + " von Kunde (" + System.lineSeparator() + this.customer + ")"
				+ System.lineSeparator() + "Gestatret : " + this.timestampStartedOrder + " Ausgeliefert: "
				+ this.timestampDeliveredOrder + System.lineSeparator() + "Beinhaltet: " + System.lineSeparator()
				+ shoppingBasket + ")";
	}

	/**
	 * @param dish the DishVO to add to shoppingBasket
	 */
	public void addDish(DishVO dish) {
		this.shoppingBasket.add(dish);
	}

	// TODO deleteDish: add useful Javadoc
	public void deleteDish(int index) {
		this.shoppingBasket.remove(index);
	}

	// TODO deleteDish: add useful Javadoc
	public void deleteDish(DishVO dish) {
		this.shoppingBasket.remove(dish);
	}

	/**
	 * @returns the price of all dishes in shoppingBasket
	 */
	public float calculatePriceDishes() {
		float f = 0.0f;
		for (int j = 0; j < this.shoppingBasket.size(); j++) {
			f += shoppingBasket.get(j).getPrice();
		}
		return f;
	}

	// end of methods
}
