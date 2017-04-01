package ca.bcit.entity;

/**
 * @author Siamak Pourian
 * @version Mar 27, 2016
 * 
 * IllegalStateException Class
 *
 */
@SuppressWarnings("serial")
public class IllegalStateException extends Exception {

	/**
	 * 
	 */
	public IllegalStateException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public IllegalStateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public IllegalStateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalStateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IllegalStateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
