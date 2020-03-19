package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */

import java.util.ArrayList;

/**
 * @author Otto Werse
 *
 */
public class PastaVO extends DishVO {
	// start of attributes

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeOfPasta;

	// end of attributes

	// start of constructors

	public PastaVO() {
		this(0, null, null, 0.0f, 0);
	}

	/**
	 * @param number
	 * @param name
	 * @param ingredients
	 * @param price
	 * @param typeOfPasta
	 */
	public PastaVO(int number, String name, ArrayList<String> ingredients, float price, int typeOfPasta) {
		super(number, name, ingredients, price);
		this.typeOfPasta = typeOfPasta;
	}

	// end of constructors

	// start of methods

	/**
	 * @return the typeOfPasta
	 */
	public int getTypeOfPasta() {
		return typeOfPasta;
	}

	/**
	 * @param typeOfPasta the typeOfPasta to set
	 */
	public void setTypeOfPasta(int typeOfPasta) {
		// TODO error handling
		this.typeOfPasta = typeOfPasta;
	}

	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if (o != null) {
			if (this.getClass() == o.getClass()) {
				PastaVO p = (PastaVO) o;
				b = (this.number == p.number);
				b &= (this.ingredients.equals(p.ingredients));
				b &= ((this.name.equals(p.name)));
				b &= ((this.price == p.price));
				b &= ((this.typeOfPasta == p.typeOfPasta));
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
		result = result * m + this.typeOfPasta;
		return result;
	}

//	@Override
//	public Object clone() {
//		return new PastaVO(this.number, this.name, this.ingredients, this.price, this.typeOfPasta);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see objects.DishVO#getNameOfDish()
	 */
	@Override
	public String getNameOfDish() {
		String s = "";
		switch (this.typeOfPasta) {
		case 4:
			s = "Spaghetti";
			break;
		case 5:
			s = "Tortellini";
			break;
		case 6:
			s = "Gnocchi";
			break;
		default:
			s = "Fehler";
		}
		return "Pasta " + this.name + " - " + s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see objects.DishVO#getNumberOfDish()
	 */
	@Override
	public int getNumberOfDish() {
		return this.number + this.typeOfPasta * 100;
	}

	// end of methods
}
