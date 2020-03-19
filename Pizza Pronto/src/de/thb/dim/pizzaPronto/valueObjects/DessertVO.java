package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */


/**
 * @author Otto Werse
 *
 */
public class DessertVO extends DishVO {
	// start of attributes

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public DessertVO() {
		super();
	}

	/**
	 * @param number
	 * @param name
	 * @param price
	 */
	public DessertVO(int number, String name, float price) {
		super(number, name, price);
	}

	// end of constructors

	// start of methods

//	@Override
//	public Object clone() {
//		return new DessertVO(this.number, this.name, this.price);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see objects.DishVO#getNameOfDish()
	 */
	@Override
	public String getNameOfDish() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see objects.DishVO#getNumberOfDish()
	 */
	@Override
	public int getNumberOfDish() {
		return this.number;
	}

	// end of methods
}
