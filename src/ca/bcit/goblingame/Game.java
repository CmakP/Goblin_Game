package ca.bcit.goblingame;

import java.util.Arrays;

import ca.bcit.entity.IllegalStateException;
import ca.bcit.util.InputReader;
import ca.bcit.util.NextRandom;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * Game Class, the game logic.
 *
 */
public class Game {

	public static final int MAX_NUM_OF_GLIMS = 11;
	public static final int MAX_NUM_OF_GOBLINS = 6;
	public static final int MAX_NUM_OF_GLIMSTACK = 6;
	public static final int CHANCE_OF_APPEARING_GLIMCASHE = 10;  // 10% chance(using random method) of appearing a GlimCashe every time player takes a step)
	
	private static Dungeon dungeon;
	private static NextRandom random;
	private static Player player;
	private static GlimCashe stackOfCandles;
	
	private int numOfGoblins;
	
	/**
	 * Zero-Parameter Constructor
	 */
	public Game() {
	    dungeon = new Dungeon();
		random = new NextRandom();
		stackOfCandles = new GlimCashe();
	}
	
	/**
	 * Logic of the game
	 * @throws IllegalStateException 
	 */
	public void start() throws IllegalStateException {
		char landedOnActor;
		boolean winner;
		
        player = new Player('@',random.randomGenerator(Dungeon.ROWS), random.randomGenerator(Dungeon.COLUMNS), random.randomGenerator(MAX_NUM_OF_GLIMS) + 40);
		
	    numOfGoblins = random.randomGenerator(MAX_NUM_OF_GOBLINS) + 5;
	    greeting(player.getNumOfGlims());
	 
	    dungeon.createGoblins(numOfGoblins, player.getPlayerPosition());
	    System.out.println();
 	    player.printSmallTable();
 	    dungeon.printSmallTable();
	    System.out.println();
	    dungeon.loadDungeon(player.getPlayerPosition());
        dungeon.showGameMap();
	     
	    do {
	    	winner = false;
	    	player.act(inputReader());
	        if(stackOfCandles != null && stackOfCandles.getNumOfGlimStack() == 0 && createGlimCashe()) {
                System.out.println("\nA GlimCashe has appeard in the dungeon.");
            }
	        dungeon.actorsTakeStep(player.getPlayerPosition());
	        landedOnActor = dungeon.loadDungeon(player.getPlayerPosition());
	        if(landedOnActor == '#') {
		        playerLandedOnGlimCashe();
	        }
	        else if(landedOnActor == 'G') {
	        	dungeon.removeActor(player.getPlayerPosition());
	        	dungeon.loadDungeon(player.getPlayerPosition());
		        System.out.println("You got a Goblin");
	        	if(--numOfGoblins == 0) {
	        	    winner = true;
	        	    player.setNumOfGlims(0);
	            }
	        }
	        
	        if(numOfGoblins != 0 ) {
	        	System.out.println();
	            player.printSmallTable();
	        }
		
	        dungeon.printSmallTable();
		    System.out.println();  
		    dungeon.showGameMap();
	            
	    } while(!(player.getNumOfGlims() == 0));
	    
	    if(winner) {
	    	System.out.println("\nYOU WIN");
	    }
	    else {
	    	System.out.println("\nYOU LOSE");
	    }
    }	
	
	/**
	 * Reads the user input and verifies if it's a valid input
	 * 
	 * @return valid command as String
	 */
	public String inputReader() throws IllegalStateException {
		boolean invalidInput;
		String direction = "?";

		do {
			invalidInput = false;
			InputReader reader = new InputReader();
		    try {
	     	    System.out.println();
				System.out.print("> ");
	            direction = reader.getCommand();
	        }
	    	catch (IllegalStateException e) {
	    		System.out.println(e.getMessage());
		        invalidInput = true;	
		    }
		} while(invalidInput);
		return direction;
	}
	
	/**
	 * Prints the greetings to the game player.
	 * 
	 * @param numOfGlims number of glims the player has
	 */
	public void greeting(int numOfGlims) {
		System.out.println("Greetings, brave adventurer! Welcom to Glims and Goblins.\n" +
	                       "You have " + numOfGlims + " glims and there are " + numOfGoblins + "\n" +
	                       "deranged goblins in the \ndungeon. May the Schwartz be with you!");
	}
	
	/**
	 * Creates a GlimCashe based on 10% chance every time the player moves
	 * 
	 * @return true if a GlimCashe was appeared and false otherwise
	 */
	public boolean createGlimCashe() {
		int[] position = new int[2];
		boolean searching;
		if(random.randomGenerator(CHANCE_OF_APPEARING_GLIMCASHE) == 0) {
			do {
				searching = false;
				position = dungeon.getNextPosition();
		   	    if(Arrays.equals(position, player.getPlayerPosition())) {
					searching = true;
		        }
			}while(searching);
			stackOfCandles = new GlimCashe('#', position[0], position[1], random.randomGenerator(MAX_NUM_OF_GLIMSTACK) + 5);
	        dungeon.addActor(stackOfCandles);
	        return true;
		}
		return false;
	}
	
	/**
	 * Adds the GlimCashe to the player's stash and removes it
	 */
    public void playerLandedOnGlimCashe() {
		    player.setNumOfGlims(player.getNumOfGlims() + stackOfCandles.getNumOfGlimStack());
        	System.out.println("\nYou got a Glimcashe of " + stackOfCandles.getNumOfGlimStack() + " glims.");
        	System.out.println("You now have " + player.getNumOfGlims() + " glims left.");
            dungeon.removeActor(stackOfCandles.getActorPosition());
            dungeon.loadDungeon(player.getPlayerPosition());
            stackOfCandles = null;
	}	
}