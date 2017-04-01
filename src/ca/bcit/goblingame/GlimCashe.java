package ca.bcit.goblingame;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * GlimCashe Class.
 *
 */
public class GlimCashe extends Actor {

	private int numOfGlimStack;
	/**
	 * Zero-Parameter Constructor
	 */
	public GlimCashe() {
	    super();
	    numOfGlimStack = 0;
	}
	
	/**
	 * Overloaded Constructor
	 */
	public GlimCashe(char actorSymbol, int actorPositionRows, int actorPositionColumns, int numOfGlimStack) {
	    super(actorSymbol, actorPositionRows, actorPositionColumns);
	    this.numOfGlimStack = numOfGlimStack;
	}

	/**
	 * @return the numOfGlimStack
	 */
	public int getNumOfGlimStack() {
		return numOfGlimStack;
	}

	/**
	 * @param numOfGlimStack the numOfGlimStack to set
	 */
	public void setNumOfGlimStack(int numOfGlimStack) {
		this.numOfGlimStack = numOfGlimStack;
	}

	/* (non-Javadoc)
	 * @see ca.bcit.comp1451.assignment3.Actor#act()
	 */
	@Override
	public void act(char[][] dungeon) {}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GlimCashe [numOfGlimStack=" + numOfGlimStack + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numOfGlimStack;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof GlimCashe)) {
			return false;
		}
		GlimCashe other = (GlimCashe) obj;
		if (numOfGlimStack != other.numOfGlimStack) {
			return false;
		}
		return true;
	}
}
