package ca.bcit.util;

import java.util.Random;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * Goblin Class
 *
 */
public class NextRandom {

	/**
	 * Zero-Parameter Constructor
	 */
	public NextRandom() {}

	Random random = new Random();
	
	/**
	 * Generates an int random number
	 * 
	 * @param upperBound the upper bound of the random number to be created
	 * @return a random number
	 */
	public int randomGenerator(int upperBound) {
		return random.nextInt(upperBound);
	}

	/**
	 * Generates a boolean result for a random move
	 * 
	 * @return a random result as boolean
	 *
	public boolean randomMove() {
		return ((random.nextInt(2) == 0) ? false : true);
	}*/
}
