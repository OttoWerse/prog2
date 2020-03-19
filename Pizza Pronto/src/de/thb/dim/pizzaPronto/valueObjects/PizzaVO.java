package de.thb.dim.pizzaPronto.valueObjects;

import java.util.ArrayList;

/**
 * 
 */



/**
 * @author Otto Werse
 *
 */
public class PizzaVO extends DishVO {
	// start of attributes

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int size;

	// end of attributes

	// start of constructors

	public PizzaVO() {
		this(0, null, null, 0.0f);
	}

	/**
	 * @param number
	 * @param name
	 * @param ingrgedients
	 * @param price
	 */
	public PizzaVO(int number, String name, ArrayList<String> ingredients, float price) {
		this(number, name, ingredients, price, 0);
	}

	/**
	 * @param number
	 * @param name
	 * @param ingrgedients
	 * @param price
	 * @param size
	 */
	public PizzaVO(int number, String name, ArrayList<String> ingredients, float price, int size) {
		super(number, name, ingredients, price);
		this.setSize(size);
	}

	// end of constructors

	// start of methods

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		// TODO error handling
		this.size = size;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				PizzaVO p = (PizzaVO) o;
				b = (this.number == p.number);
				b &= (this.ingredients.equals(p.ingredients));
				b &= ((this.name.equals(p.name)));
				b &= ((this.price == p.price));
				b &= ((this.size == p.size));
			}
		}
		return b;
	}

	@Override
	public int hashCode() {
		int m = 59;
		int result = 0;
		result = result * m + this.number;
		result = result * m + ((this.name == null) ? 0 : this.name.hashCode());
		result = result * m + ((this.price == 0.0f) ? 0 : Float.floatToIntBits(this.price));
		result = result * m + ((this.ingredients == null) ? 0 : this.ingredients.hashCode());
		result = result * m + this.size;
		return result;
	}

//	@Override
//	public Object clone() {
//		return new PizzaVO(this.number, this.name, this.ingredients, this.price, this.size);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see objects.DishVO#getNameOfDish()
	 */
	@Override
	public String getNameOfDish() {
		String s = "";
		switch (this.size) {
		case 1:
			s = "Normal";
			break;
		case 2:
			s = "Grande";
			break;
		default:
			s = "Fehler";
		}
		return "Pizza " + this.name + " - " + s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see objects.DishVO#getNumberOfDish()
	 */
	@Override
	public int getNumberOfDish() {
		return this.number * 10 + this.size;
	}

	// end of methods
}
