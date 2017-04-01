package ca.bcit.goblingame;

import java.util.Arrays;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * Player Class, Contains player information
 *
 */
public class Player {

	private int numOfGlims;
	
	private char playerSymbol;
	
	private int[] playerPosition;
	
	/**
	 * Zero-Parameter Constructor
	 */
	public Player() {
		playerSymbol = '@';
		numOfGlims = 0;
		playerPosition = new int[2];
	}
	
	/**
	 * Overloaded Constructor
	 */
	public Player(char playerSymbol, int row, int column,int numOfGlims) {
		playerPosition = new int[2];
		this.playerSymbol = playerSymbol;
		setNumOfGlims(numOfGlims);
		setPlayerRowPosition(row); 
		setPlayerColumnPosition(column);
	}

	/**
	 * @return the glimLeft
	 */
	public int getNumOfGlims() {
		return numOfGlims;
	}

	/**
	 * @param glimLeft the glimLeft to set
	 */
	public void setNumOfGlims(int numOfGlims) {
		if(numOfGlims >= 0) {
			this.numOfGlims = numOfGlims;
		}
	}

	/**
	 * @return the playerSymbol
	 */
	public char getPlayerSymbol() {
		return playerSymbol;
	}

	/**
	 * @param playerSymbol the playerSymbol to set
	 */
	public void setPlayerSymbol(char playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	/**
	 * @return the playerPosition
	 */
	public int[] getPlayerPosition() {
		return playerPosition;
	}

	/**
	 * @param playerPosition the playerPosition to set
	 */
	public void setPlayerPosition(int[] playerPosition) {
		setPlayerRowPosition(playerPosition[0]); 
		setPlayerColumnPosition(playerPosition[1]);
	}
	
	/**
	 * Prints the small table for the game
	 */
	public void printSmallTable() {
	    System.out.println(getNumOfGlims() + "\n");
		System.out.println(getPlayerSymbol() + " " + "(" + playerPosition[0] + ", " + playerPosition[1] + ")");
	}
	
	/**
	 * Return the player's row position
	 * 
	 * return the int value of player's row position
	 */
	public int getPlayerRowPosition() {
		return playerPosition[0];
	}

	/**
	 * Return the player's column position
	 * 
	 * return the int value of player's column position
	 */
	public int getPlayerColumnPosition() {
		return playerPosition[1];
	}
	
	/**
	 * Sets the player's row position
	 * 
	 * @param playerRowPosition player's row position to be set after validation
	 */
	public void setPlayerRowPosition(int playerRowPosition) {
		if(playerRowPosition >= 0 && playerRowPosition < Dungeon.ROWS) {
			playerPosition[0] = playerRowPosition;
		}
	}

	/**
	 * Sets the player's column position
	 * 
	 * @param playerRowPosition player's column position to be set after validation
	 */
	public void setPlayerColumnPosition(int playerColumnPosition) {
		if(playerColumnPosition >= 0 && playerColumnPosition < Dungeon.COLUMNS) {
        	playerPosition[1] = playerColumnPosition;
		}
	}
	
	/**
	 * Moves the player to the direction entered by user 
	 *
	 * @param playerCommand for the player to go to after validation
	 */
	public void act(String playerCommand) {
		if(playerCommand.equals("w")) {
			if(getPlayerRowPosition() - 1 >= 0) {
				setPlayerRowPosition(getPlayerRowPosition() - 1);
			}
			else {
				System.out.println("Can't go UP.");
			}
		}
		else if(playerCommand.equals("s")) {
			if(getPlayerRowPosition() + 1 < Dungeon.ROWS) {
				setPlayerRowPosition(getPlayerRowPosition() + 1);
			}
			else {
				System.out.println("Can't go DOWN.");
			}
		}
		else if(playerCommand.equals("a")) {
			if(getPlayerColumnPosition() - 1 >= 0) {
				setPlayerColumnPosition(getPlayerColumnPosition() - 1);
			}
			else {
				System.out.println("Can't go LEFT.");
			}
		}
		else if(playerCommand.equals("d")) {
			if(getPlayerColumnPosition() + 1 < Dungeon.COLUMNS) {
				setPlayerColumnPosition(getPlayerColumnPosition() + 1);
			}
			else {
				System.out.println("Can't go RIGHT.");
			}
		}
		numOfGlims--;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [numOfGlims=" + numOfGlims + ", playerSymbol=" + playerSymbol + ", playerPosition="
				+ Arrays.toString(playerPosition) + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numOfGlims;
		result = prime * result + Arrays.hashCode(playerPosition);
		result = prime * result + playerSymbol;
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
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		if (numOfGlims != other.numOfGlims) {
			return false;
		}
		if (!Arrays.equals(playerPosition, other.playerPosition)) {
			return false;
		}
		if (playerSymbol != other.playerSymbol) {
			return false;
		}
		return true;
	}
}
