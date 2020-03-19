/**
 * 
 */
package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import de.thb.dim.pizzaPronto.valueObjects.DessertVO;
import de.thb.dim.pizzaPronto.valueObjects.DishVO;
import de.thb.dim.pizzaPronto.valueObjects.MenuVO;
import de.thb.dim.pizzaPronto.valueObjects.PastaVO;
import de.thb.dim.pizzaPronto.valueObjects.PizzaVO;

/**
 * @author Otto Werse
 *
 */
public class MenuImporter {

	// start of attributes

	// end of attributes

	// start of constructors

	/**
	 * 
	 */
	public MenuImporter() {
		super();
		// TODO Auto-generated constructor stub
	}

	// end of constructors

	// start of methods

	public MenuVO readMenu(String fileName) {
		// TODO
		LinkedList<DishVO> dishes = new LinkedList<DishVO>();
		String line = null;
		String[] words = null;
		DishVO currentDish = null;
		ArrayList<String> ingredients = new ArrayList<String>();
		MenuVO menu = null;

		try {
			BufferedReader textFile = new BufferedReader(new FileReader(new File(fileName)));
			while ((line = textFile.readLine()) != null) {
				words = line.split(":");
				if (words[0].equals("dish.type")) {
					// Insert current DishVO prior to initialising a new one
					currentDish.setIngredients(ingredients);
					dishes.add(currentDish);
					// determine dish type
					switch (words[0]) {
					case "Pizza":
						currentDish = new PizzaVO();
						break;
					case "Pasta":
						currentDish = new PastaVO();
						break;
					case "Dessert":
						currentDish = new DessertVO();
						break;
					default:
						// TODO: Error
						break;
					}
				}
				if (words[0].equals("dish.nr")) {
					currentDish.setNumber(Integer.valueOf(words[1]));
				}
				if (words[0].equals("dish.name")) {
					currentDish.setName(words[1]);
				}
				if (words[0].equals("dish.size")) {
					((PizzaVO) currentDish).setSize(Integer.valueOf(words[1]));
				}
				if (words[0].equals("dish.typeOfPasta")) {
					((PastaVO) currentDish).setTypeOfPasta(Integer.valueOf(words[1]));
				}
				if (words[0].equals("dish.price")) {
					currentDish.setPrice(Float.valueOf(words[1]));
				}
				if (words[0].equals("dish.ingredient")) {
					ingredients.add(words[1]);
				}
			}
			// Insert last DishVO
			currentDish.setIngredients(ingredients);
			dishes.add(currentDish);

			// generate MenuVO
			menu = new MenuVO(dishes);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}

	// end of methods
}
