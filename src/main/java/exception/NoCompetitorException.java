/**
 * 
 */
package exception;

/**
 * @author amevigbe
 *
 */
public class NoCompetitorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1722090823628772464L;

	/**
	 * 
	 */
	public NoCompetitorException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NoCompetitorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NoCompetitorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NoCompetitorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NoCompetitorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
