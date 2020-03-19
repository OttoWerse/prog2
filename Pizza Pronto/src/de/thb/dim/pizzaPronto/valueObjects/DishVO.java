package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Otto Werse
 *
 */
public abstract class DishVO implements Comparable<DishVO>, Cloneable, Serializable {
	// start of attributes

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int number;
	protected String name;
	protected ArrayList<String> ingredients;
	protected float price;

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public DishVO() {
		this(0, null, 0.0f);
	}

	/**
	 * @param number
	 * @param name
	 * @param price
	 */
	public DishVO(int number, String name, float price) {
		this(number, name, null, price);
	}

	/**
	 * @param number
	 * @param name
	 * @param ingredients
	 * @param price
	 */
	public DishVO(int number, String name, ArrayList<String> ingredients, float price) {
		super();
		this.setNumber(number);
		this.setName(name);
		this.setIngredients(ingredients);
		this.setPrice(price);
	}

	// end of constructors

	// start of methods

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the ingredients
	 */
	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		// TODO error handling
		this.number = number;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		// TODO error handling
		this.name = name;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(ArrayList<String> ingredients) {
		// TODO error handling
		this.ingredients = ingredients;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		// TODO error handling
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				DishVO p = (DishVO) o;
				b = (this.number == p.number);
				b &= (this.ingredients.equals(p.ingredients));
				if (this.name != null) {
					b &= ((this.name.equals(p.name)));
				}
				b &= ((this.price == p.price));
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
		return result;
	}

	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
		return o;
	}

	@Override
	public String toString() {
		String s = "";
		int i = this.getNumberOfDish();
		if (i < 10) {
			s += "  " + i;
		} else if (i < 100) {
			s += " " + i;
		} else if (i < 1000) {
			s += i;
		}
		s += " - " + this.getNameOfDish() + ", " + this.getPrice() + " Euro" + System.lineSeparator();
		s += "      " + this.ingredientsToString();
		return s;
	}

	public String ingredientsToString() {
		String ingredients = "no ingredients";
		if (this.ingredients != null) {
			ingredients = "";
			for (int i = 0; i < this.ingredients.size() - 1; i++) {
				ingredients += this.ingredients.get(i) + ", ";
			}
			ingredients += this.ingredients.get(this.ingredients.size() - 1);
		}
		return ingredients;
	}

	public abstract String getNameOfDish();

	public abstract int getNumberOfDish();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(DishVO dish) {
		return this.getNameOfDish().compareTo(dish.getNameOfDish());
	}

	// end of methods
}
