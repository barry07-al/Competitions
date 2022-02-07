package util;

import java.util.Random;

/**
 * @author BARRY Alpha Oumar
 */
public class RandomU {

	/**
	 * the method which returns a random number between 0 and the number i passed as
	 * a parameter
	 * 
	 * @param i the int i
	 * @return the number i
	 */
	public int nbreAlea(int i) {
		Random random = new Random();
		return random.nextInt(i);
	}
}