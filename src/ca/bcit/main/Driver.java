package ca.bcit.main;

import ca.bcit.entity.IllegalStateException;
import ca.bcit.goblingame.Game;

/** 
* @author Siamak Pourian
* @version Mar 27,2016
* 
* Driver Class, drives the program
*
*/
public class Driver {

	/**
	 * Zero-Parameter Constructor
	 */
	public Driver() {}

	/**
     * Drives the program.
     * 
     * @param args command line arguments
	 * @throws IllegalStateException 
     */
	public static void main(String[] args) throws IllegalStateException {
		Game game = new Game();
		game.start();
	}
}
