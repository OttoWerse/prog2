package de.thb.dim.pizzaPronto.businessObjects;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoCustomerException;
import de.thb.dim.pizzaPronto.businessObjects.exceptions.NoOrderException;
import de.thb.dim.pizzaPronto.controller.IOrdering;
import de.thb.dim.pizzaPronto.valueObjects.CustomerVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.OrderVO;
import de.thb.dim.pizzaPronto.valueObjects.StateOfOrderVO;

/**
 * @author Otto Werse
 *
 */
public class Ordering implements IOrdering, Comparator<DishVO> {

	// start of attributes

	private static MenuVO menu;
	private static int nextId = 0;
	private OrderVO currentOrder;
	private CustomerVO currentCustomer;
	private IService kitchen;
	private IService delivery;

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public Ordering() {
		super();
		Ordering.menu = new MenuVO();
		this.kitchen = new Kitchen();
		this.delivery = new Delivery();
	}

	// end of constructors

	// start of methods

	/**
	 * @return the menu
	 */
	public static MenuVO getMenu() {
		return menu;
	}

	/**
	 * @return the nextId
	 */
	public static int getNextId() {
		return Ordering.nextId;
	}

	/**
	 * @return the currentOrder
	 */
	public OrderVO getCurrentOrder() {
		return currentOrder;
	}

	/**
	 * @return the currentCustomer
	 */
	public CustomerVO getCurrentCustomer() {
		return currentCustomer;
	}

	/**
	 * @return the kitchen
	 */
	public IService getKitchen() {
		return kitchen;
	}

	/**
	 * @return the delivery
	 */
	public IService getDelivery() {
		return delivery;
	}

	/**
	 * @param kitchen the kitchen to set
	 */
	public void setKitchen(IService kitchen) {
		// TODO error handling
		this.kitchen = kitchen;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(IService delivery) {
		// TODO error handling
		this.delivery = delivery;
	}

	/**
	 * @param currentOrder the currentOrder to set
	 */
	public void setCurrentOrder(OrderVO currentOrder) {
		// TODO error handling
		this.currentOrder = currentOrder;
	}

	/**
	 * @param currentCustomer the currentCustomer to set
	 */
	public void setCurrentCustomer(CustomerVO currentCustomer) {
		// TODO error handling
		this.currentCustomer = currentCustomer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.IOrdering#startNewOrder(valueObjects.CustomerVO)
	 */
	@Override
	public OrderVO startNewOrder(CustomerVO customer) throws NullPointerException {
		Ordering.menu = new MenuVO();
		if (customer != null) {
			this.currentCustomer = customer;

			LocalDateTime now = LocalDateTime.now();
			if (now.getYear() > (Ordering.nextId / 100000)) {
				Ordering.nextId = now.getYear() * 100000;
			}
			Ordering.nextId++;

			this.currentOrder = new OrderVO(Ordering.getNextId(), StateOfOrderVO.STARTED, now, customer);

			customer.setOrder(this.currentOrder);
		} else {
			Objects.requireNonNull(customer, "customer must not be null");
		}
		return currentOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.IOrdering#addDish(valueObjects.DishVO)
	 */
	@Override
	public void addDish(DishVO dish) throws NoOrderException, IllegalStateException {
		if (this.currentOrder != null) {
			if (this.currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
				this.currentOrder.addDish(dish);
			} else {
				throw new IllegalStateException("Your order is complete, you can not add any dishes.");
//				System.out.println("Your order is complete, you can not add any dishes. ");
			}
		} else {
			throw new NoOrderException("There is no order.");
//			System.out.println("Error: There is no order. ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.IOrdering#deleteDish()
	 */
	@Override
	public void deleteDish(DishVO dish) throws NoOrderException, IllegalStateException {
		if (this.currentOrder != null) {
			if (this.currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
				this.currentOrder.deleteDish(dish);
			} else {
				throw new IllegalStateException("Your order is complete, you can not delete any dishes.");
//				System.out.println("Your order is complete, you can not delete any dishes. ");
			}
		} else {
			throw new NoOrderException("There is no order.");
//			System.out.println("Error: There is no order. ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.IOrdering#calculateTotalPrice()
	 */
	@Override
	public float calculateTotalPrice() throws NoOrderException {
		float f = 0.0f;
		if (this.currentOrder != null) {
			f = this.currentOrder.calculatePriceDishes();
		} else {
			throw new NoOrderException("There is no order");
//			System.out.println("Error: There is no order. ");
		}
		return f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.IOrdering#confirmOrder()
	 */
	@Override
	public void confirmOrder() throws IllegalStateException, NoOrderException, NoCustomerException {
		try {
			if (this.currentOrder != null) {
				if (this.currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
					this.currentOrder.setState(StateOfOrderVO.CONFIRMED);
					this.startService();
				} else {
					throw new IllegalStateException("Your order can not be confirmed.");
//					System.out.println("Your order can not be confirmed. ");
				}
			} else {
				throw new NoOrderException("There is no order.");
//				System.out.println("Error: There is no order. ");
			}
		} catch (Exception e) {
			// TODO: Ist das so richtig?
			System.err.println("Internal error by processing an order: " + e.getMessage());
		}
	}

	public void startService() throws IllegalStateException, NoOrderException, NoCustomerException {
		if (this.currentOrder != null) {
			if (this.currentOrder.getState().equals(StateOfOrderVO.STARTED)) {
				throw new IllegalStateException("Your order can not be processed.");
//				System.out.println("Your order can not be processed. ");
			} else {
				if (this.currentOrder.getState().equals(StateOfOrderVO.CONFIRMED)) {
					System.out.println(this.kitchen.startService(currentOrder));
					this.startService();
				} else if (this.currentOrder.getState().equals(StateOfOrderVO.READY)) {
					System.out.println(this.delivery.startService(currentOrder));
					this.startService();
				} else if (this.currentOrder.getState().equals(StateOfOrderVO.DELIVERED)) {
					this.currentOrder.setTimestampDeliveredOrder(LocalDateTime.now());
					this.currentOrder.setState(StateOfOrderVO.FINISHED);
					System.out.println("Order completed: " + System.lineSeparator() + this.currentOrder);
					this.currentCustomer.setOrder(null);
				}
			}
		} else {
			throw new NoOrderException("There is no order.");
//			System.out.println("Error: There is no order. ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.thb.dim.pizzaPronto.controller.IOrdering#sortShoppingBasket()
	 */
	@Override
	public List<DishVO> sortShoppingBasket() throws NoOrderException {
		if (this.currentOrder != null) {
			List<DishVO> list = this.currentOrder.getShoppingBasket();
			Collections.sort(list);
			return list;
		} else {
			throw new NoOrderException("There is no order.");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.thb.dim.pizzaPronto.controller.IOrdering#sortShoppingBasketByNumber()
	 */
	@Override
	public List<DishVO> sortShoppingBasketByNumber() throws NoOrderException {
		if (this.currentOrder != null) {
			List<DishVO> list = this.currentOrder.getShoppingBasket();
			Comparator<DishVO> comp = ((DishVO d1, DishVO d2) -> Integer.compare(d1.getNumberOfDish(),
					d2.getNumberOfDish()));
			Collections.sort(list, comp);
			return list;
		} else {
			throw new NoOrderException("There is no order.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.thb.dim.pizzaPronto.controller.IOrdering#sortShoppingBasketByPrice()
	 */
	@Override
	public List<DishVO> sortShoppingBasketByPrice() throws NoOrderException {
		if (this.currentOrder != null) {
			List<DishVO> list = this.currentOrder.getShoppingBasket();
			Comparator<DishVO> comp = (DishVO d1, DishVO d2) -> Float.compare(d1.getPrice(), d2.getPrice());
			Collections.sort(list, comp);
			return list;
		} else {
			throw new NoOrderException("There is no order.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(DishVO o1, DishVO o2) {
		return o1.compareTo(o2);
	}

	// end of methods
}
