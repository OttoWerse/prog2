package de.thb.dim.pizzaPronto.valueObjects;
/**
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Otto Werse
 *
 */
public class MenuVO {
	// start of attributes

	private List<DishVO> dishes;

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public MenuVO() {
		super();
		this.initMenu();
	}

	/**
	 * @param dishes
	 */
	public MenuVO(List<DishVO> dishes) {
		super();
		this.dishes = dishes;
	}

	// end of constructors

	// start of methods

	private void initMenu() {
		this.dishes = new ArrayList<DishVO>();

		// Pizza
		dishes.add(0,
				new PizzaVO(30, "Popeye",
						(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Spinat", "Champignon", "Ei" }),
						7.00f, 1));
		dishes.add(1,
				new PizzaVO(30, "Popeye",
						(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Spinat", "Champignon", "Ei" }),
						8.90f, 2));
		dishes.add(2, new PizzaVO(31, "Hawaii",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Ananas", "Curry" }), 5.80f, 1));
		dishes.add(3, new PizzaVO(31, "Hawaii",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Ananas", "Curry" }), 740f, 2));
		dishes.add(4, new PizzaVO(32, "Prima",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }), 7.00f, 1));
		dishes.add(5, new PizzaVO(32, "Prima",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }), 8.90f, 2));

		// Pasta
		dishes.add(6, new PastaVO(11, "Napoli", (ArrayList<String>) Arrays.asList(new String[] { "Tomatensauce" }),
				5.60f, 4));
		dishes.add(7, new PastaVO(11, "Napoli", (ArrayList<String>) Arrays.asList(new String[] { "Tomatensauce" }),
				5.60f, 5));
		dishes.add(8, new PastaVO(11, "Napoli", (ArrayList<String>) Arrays.asList(new String[] { "Tomatensauce" }),
				5.60f, 6));
		dishes.add(9, new PastaVO(12, "Bolognese",
				(ArrayList<String>) Arrays.asList(new String[] { "Hackfleischsauce" }), 6.40f, 4));
		dishes.add(10, new PastaVO(12, "Bolognese",
				(ArrayList<String>) Arrays.asList(new String[] { "Hackfleischsauce" }), 6.40f, 5));
		dishes.add(11, new PastaVO(12, "Bolognese",
				(ArrayList<String>) Arrays.asList(new String[] { "Hackfleischsauce" }), 6.40f, 6));
		dishes.add(12, new PastaVO(13, "alla Panna",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Sahne" }), 6.40f, 4));
		dishes.add(13, new PastaVO(13, "alla Panna",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Sahne" }), 6.40f, 5));
		dishes.add(14, new PastaVO(13, "alla Panna",
				(ArrayList<String>) Arrays.asList(new String[] { "Schinken", "Sahne" }), 6.40f, 6));

		// Dessert
		dishes.add(15, new DessertVO(21, "Hausgemachter Obstsalat", 2.30f));
		dishes.add(16, new DessertVO(22, "Hausgemachte Pannacotta", 2.60f));
		dishes.add(17, new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f));

	}

	@Override
	public String toString() {
		// TODO toString: String Format
		String s = "";
		s += "MENU PIZZA PRONTO" + System.lineSeparator();
		s += System.lineSeparator();
		for (DishVO dish : dishes) {
			s += dish + System.lineSeparator();
		}
		return s;
	}

	public DishVO getDish(int index) {
		if (index < this.dishes.size()) {
			return this.dishes.get(index);
		} else {
			return null;
		}
	}

	public int getNumberOfDishes() {
		return this.dishes.size();
//		int i = 0;
//		for (int j = 0; j < dishes.length; j++) {
//			if (dishes[j] != null) {
//				i++;
//			}
//		}
//		return i;
	}

	// end of methods
}
