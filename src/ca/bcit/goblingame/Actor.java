package ca.bcit.goblingame;

import java.util.Arrays;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * Actor Class, an abstract class
 *
 */
public abstract class Actor {

	public static final char ACTOR_SYMBOL = '?';
	
	protected char actorSymbol;
	protected int[] actorPosition;
	
	/**
	 * Zero_param Constructor
	 */
	public Actor() {
		actorSymbol = ACTOR_SYMBOL;
		actorPosition = new int[2];
	}
	
	/**
	 * Overloaded constructor
	 */
	public Actor(char actorSymbol, int actorPositionRow, int actorPositionColumn) {
		actorPosition = new int[2];
		this.actorSymbol = actorSymbol;
		this.actorPosition[0] = actorPositionRow;
		this.actorPosition[1] = actorPositionColumn;
	}
	
	/**
	 * @return the actorSymbol
	 */
	public char getActorSymbol() {
		return actorSymbol;
	}

	/**
	 * @param actorSymbol the actorSymbol to set
	 */
	public void setActorSymbol(char actorSymbol) {
		this.actorSymbol = actorSymbol;
	}

	/**
	 * @return the actorPosition
	 */
	public int[] getActorPosition() {
		return actorPosition;
	}

	/**
	 * @param actorPosition the actorPosition to set
	 */
	public void setActorPosition(int[] actorPosition) {
		setActorRowPosition(actorPosition[0]);
		setActorColumnPosition(actorPosition[1]);
	}
	
	/**
	 * Return the actor's row position
	 * 
	 * return the int value of actor's row position
	 */
	public int getActorRowPosition() {
		return actorPosition[0];
	}

	/**
	 * Return the actor's column position
	 * 
	 * return the int value of actor's column position
	 */
	public int getActorColumnPosition() {
		return actorPosition[1];
	}
	
	/**
	 * Sets the actor's row position
	 * 
	 * @param actorRowPosition actor's row position to be set after validation
	 */
	public void setActorRowPosition(int actorRowPosition) {
		if(actorRowPosition >= 0 && actorRowPosition < Dungeon.ROWS) {
			actorPosition[0] = actorRowPosition;
		}
	}

	/**
	 * Sets the actor's row position
	 * 
	 * @param actorRowPosition actor's row position to be set after validation
	 */
	public void setActorColumnPosition(int actorColumnPosition) {
		if(actorColumnPosition >= 0 && actorColumnPosition < Dungeon.ROWS) {
			actorPosition[1] = actorColumnPosition;
		}
	}

	/**
	 * Abstract method which is overridden by it's subclasses
	 */
	abstract void act(char[][] dungeon);

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor [actorSymbol=" + actorSymbol + ", actorPosition=" + Arrays.toString(actorPosition) + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(actorPosition);
		result = prime * result + actorSymbol;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Actor)) {
			return false;
		}
		Actor other = (Actor) obj;
		if (!Arrays.equals(actorPosition, other.actorPosition)) {
			return false;
		}
		if (actorSymbol != other.actorSymbol) {
			return false;
		}
		return true;
	}
}
