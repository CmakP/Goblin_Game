package ca.bcit.goblingame;

import java.util.Arrays;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * FastGoblin Class
 *
 */
public class FastGoblin extends Goblin implements Monster {
   
	/**
	 * Zero-Parameter Constructor
	 */
	public FastGoblin() {
	    super();
	}

	/**
	 * Overloaded Constructor
	 */
	public FastGoblin(char actorSymbol, int actorPositionRow, int actorPositionColumn) {
		super(actorSymbol, actorPositionRow, actorPositionColumn);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FastGoblin [actorSymbol=" + actorSymbol + ", actorPosition=" + Arrays.toString(actorPosition) + "]";
	}
}
