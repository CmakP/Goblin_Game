package ca.bcit.util;

import java.util.Scanner;

import ca.bcit.entity.IllegalStateException;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * InputReader Class
 *
 */
    public class InputReader {

        private Scanner scanner;

        /**
         * Constructor for objects of type InputReader.
         */
        public InputReader() {
            scanner = new Scanner(System.in);
        }

        /**
         * This method returns the command typed by the user. If the command is not a
         * valid command it throws a custom checked exception that will be caught by the
         * calling method.
         * 
         * @return command as String
         * @throws InputMismatchException,
         *             NatAnIntegerException
         */
        public String getCommand() throws IllegalStateException {
            String command = scanner.nextLine();
            
            if(!command.equals("w") && !command.equals("d") && !command.equals("s") && !command.equals("a")) {
                throw new IllegalStateException("That is not a valid choice. Try again!");
	        }
            return command;
        }
    }
