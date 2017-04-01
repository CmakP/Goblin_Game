package ca.bcit.goblingame;

import java.util.Arrays;

import ca.bcit.util.NextRandom;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * Goblin Class
 *
 */
public class Goblin extends Actor implements Monster {
	
	/**
	 * Zero-Parameter Constructor
	 */
	public Goblin() {
	    super();
	}
	
	/**
	 * Overloaded Constructor
	 */
	public Goblin(char actorSymbol, int actorRowPosition, int actorColumnPosition) {
		super(actorSymbol, actorRowPosition, actorColumnPosition);
	}

	/* (non-Javadoc)
	 * @see ca.bcit.comp1451.assignment3.Actor#act()
	 */
	@Override
	public void act(char[][] dungeon) {
        NextRandom random = new NextRandom();

        int direction = random.randomGenerator(4); 
        int position[] = new int[2];
        
            //0:up 1:down 2:left 3:right
        switch (direction) {
            case 0 : position[0] = actorPosition[0] - 1;
                     position[1] = actorPosition[1];
                     break;
            case 1 : position[0] = actorPosition[0] +1;
                     position[1] = actorPosition[1];
                     break;
            case 2 : position[0] = actorPosition[0];
                     position[1] = actorPosition[1] - 1;
                     break;
            case 3 : position[0] = actorPosition[0];
                     position[1] = actorPosition[1] + 1;
                     break;
        }
        if(position[0] >= 0 && position[0] < Dungeon.ROWS && position[1] >= 0 && position[1] < Dungeon.COLUMNS) {
        	if(dungeon[position[0]][position[1]] == '.') { 
        		actorPosition[0] = position[0];
        	}
            if(dungeon[position[0]][position[1]] == '.') {
              	actorPosition[1] = position[1];
        	
            }
        }
    }

	/* (non-Javadoc)
	 * @see ca.bcit.comp1451.assignment3.Monster#teleport()
	 * 
	 * @param dungeon a reference to the dungeon to check available cells 
	 */
	@Override
	public void teleport(char[][] dungeon) {
        NextRandom random = new NextRandom();
        
        if(random.randomGenerator(20) == 0) {   // 5% chance of teleport to somewhere random in the dungeon
            int[] position = {random.randomGenerator(Dungeon.ROWS), random.randomGenerator(Dungeon.COLUMNS)};
                
	     	if(dungeon[position[0]][position[1]] == '.') {
	    	    actorPosition[0] = position[0];
	            actorPosition[1] = position[1];
		    }
        }
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Goblin [actorSymbol=" + actorSymbol + ", actorPosition=" + Arrays.toString(actorPosition) + "]";
	}
}
