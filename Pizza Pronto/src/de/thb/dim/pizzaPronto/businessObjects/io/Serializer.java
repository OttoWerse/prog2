/**
 * 
 */
package de.thb.dim.pizzaPronto.businessObjects.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import de.thb.dim.pizzaPronto.valueObjects.OrderVO;

/**
 * @author Otto Werse
 *
 */
public class Serializer {
	// start of attributes

	ObjectOutputStream os;
	ObjectInputStream is;

	// end of attributes

	// start of constructors

	/**
	 * @param datei
	 */
	public Serializer(String datei) throws java.io.FileNotFoundException, NullPointerException {
		super();
		// TODO
	}

	// end of constructors

	// start of methods

	public void serializeOrder(OrderVO order) {
		try {
			os.writeObject(order);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeOutput() {
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OrderVO deserializeOrder() {
		OrderVO order = null;
		try {
			order = (OrderVO) is.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	public void closeInput() {
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// end of methods
}
