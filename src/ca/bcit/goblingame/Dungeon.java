package ca.bcit.goblingame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import ca.bcit.util.NextRandom;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * Dungeon Class, Holds info about 10*10 dungeon
 *
 */
public class Dungeon implements Iterable<Actor> {

	public static final int ROWS = 10;
	public static final int COLUMNS = 10;
	
	private char[][] dungeon;
	
	private ArrayList<Actor> actors;
	
	/**
	 * Zero-Parameter Constructor
	 */
	public Dungeon() {
		dungeon = new char[ROWS][COLUMNS];
		actors = new ArrayList<Actor>();
	}
	
	/**
	 * @return the dungeon
	 */
	public char[][] getDungeon() {
		return dungeon;
	}

	/**
	 * @param dungeon the dungeon to set
	 */
	public void setDungeon(char[][] dungeon) {
		this.dungeon = dungeon;
	}

	/**
	 * @return the actors
	 */
	public ArrayList<Actor> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}

	/**
	 * Creates the specified number of goblins at random places
	 * 
	 * @param numOfGoblins number of actors to be created and randomly placed
	 * @param playerPosition the position of the player in the dungeon
	 */
	public void createGoblins(int numOfGoblins, int[] playerPosition) { 
		int[] position = new int[2];
		boolean searching;
		
		for(int i = 0; i < numOfGoblins; i++) {
			do {
				searching = false;
				position = getNextPosition();
		   	    if(Arrays.equals(position, playerPosition)) {
					searching = true;
		        }
			}while(searching);
			if(i % 2 == 0) {
	   	    	addActor(new Goblin('G', position[0], position[1]));
	   	    }
	   	    else {
	   	    	addActor(new FastGoblin('G', position[0], position[1]));
	   	    }
	   	}
	}
	
	/**
	 * Adds the actor to the list of actors.
	 * 
	 * @param actor to be added to the ArrayList
	 */
	public void addActor(Actor actor) {
		if(actor != null) {
			actors.add(actor);
		}
	}
	
	/**
	 * Removes the actor from the list of actors
	 * 
	 * @param actorPosition position of the actor to be removed from the ArrayList
	 */
	public void removeActor(int[] actorPosition) {
        dungeon[actorPosition[0]][actorPosition[1]] = '.';
		Actor actorToRemove;
        Iterator<Actor> it = iterator();
		boolean searching = true;
		while(it.hasNext() && searching) {
			actorToRemove = it.next();
			if(Arrays.equals(actorToRemove.getActorPosition(), actorPosition)) {
				it.remove();
				searching = false;
			}
		}
	}

	/**
	 * Prints the small table for the game
	 */
	public void printSmallTable() {
		int [] actorPosition = new int[2];
		for(Actor actor : actors) {
			if(actor.getActorSymbol() == 'G') {
				actorPosition = actor.getActorPosition();
		        System.out.println(actor.getActorSymbol() + " " + "(" + actorPosition[0] + ", " + actorPosition[1] + ")");
			}
		}
    }
	
	/**
	 * Loads the player and all the actors in the game map
	 * 
	 * @param playerPosition the position of the player in the dungeon
	 * @return returns what the player has landed on as a char
	 */
	public char loadDungeon(int[] playerPosition) {
		dungeon = new char[ROWS][COLUMNS];
		int [] actorPosition = new int[2];
		char playerLandedOn = '.';
		
		for(int i = 0; i < dungeon.length; i++) {
			for(int j = 0; j < dungeon[i].length; j++) {
		        dungeon[i][j] = '.';
			}
		}
		
		for(Actor actor : actors) {
			actorPosition = actor.getActorPosition();
			dungeon[actorPosition[0]][actorPosition[1]] = actor.getActorSymbol();
		}
		
		if(dungeon[playerPosition[0]][playerPosition[1]] == 'G') {
			playerLandedOn = 'G';
		}
		else if(dungeon[playerPosition[0]][playerPosition[1]] == '#') {
			playerLandedOn = '#';
		}
		dungeon[playerPosition[0]][playerPosition[1]] = '@';
		return playerLandedOn;
	}
	
	/**
	 * Prints the game map with all the goblins, player and GlimCashe
     */
	public void showGameMap() {
		for(int i = 0; i < dungeon.length; i++) {
			for(int j = 0; j < dungeon[i].length; j++) {
				System.out.print(dungeon[i][j] + " ");
			}
			System.out.println();
		}		
	}
	
	/**
	 * Executes the Act method on all actors
	 * 
	 * @param playerPosition player position
	 */
	public void actorsTakeStep(int[] playerPosition) {
		for(Actor actor : actors) {
			loadDungeon(playerPosition);
			if(actor instanceof FastGoblin) {
				((FastGoblin) actor).teleport(dungeon);
			}
			else {
				actor.act(dungeon);		
			}
		}
	}
	
	/**
	 * Randomly chooses a vacant position in the dungeon for a player
	 * 
	 * @return returns a vacant position in the dungeon as int[] 
	 */
     public int[] getNextPosition() {
    	 boolean searching;
         int[] position = new int[2]; 
         NextRandom random = new NextRandom();
         
 		 do {
 	         searching = false;
 		  	 position[0] = random.randomGenerator(ROWS);
 		     position[1] = random.randomGenerator(COLUMNS);
 		     for(Actor actor : actors) {
 		         if(Arrays.equals(actor.getActorPosition(), position)) {
 		       	     searching = true;
 		         }
 		     }
 	     } while(searching);
         return position;
     }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + Arrays.deepHashCode(dungeon);
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
		if (!(obj instanceof Dungeon)) {
			return false;
		}
		Dungeon other = (Dungeon) obj;
		if (actors == null) {
			if (other.actors != null) {
				return false;
			}
		} else if (!actors.equals(other.actors)) {
			return false;
		}
		if (!Arrays.deepEquals(dungeon, other.dungeon)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dungeon [dungeon=" + Arrays.toString(dungeon) + ", actors=" + actors + "]";
	}

	@Override
	public Iterator<Actor> iterator() {
		Iterator<Actor> it = actors.iterator();
		return it;
	}
}
