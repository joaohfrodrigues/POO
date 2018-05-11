package path_simulation;
/**
 * Exception to throw when there are no moves available
 * @author Joao, Sara
 *
 */
public class NoPossibleMoves extends Exception{
	private static final long serialVersionUID = 3L;
	/**
	 * Throws message
	 * @param message Message to be thrown
	 */
	public NoPossibleMoves(String message) {
        super(message);
	}
}
