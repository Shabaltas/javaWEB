package by.training.task1.exception;

/**
 * Thrown when invalid data was gotten before creating {@code Car} object.
 *
 *  @author  Angelina Shabaltas
 *  @version 1.0
 *  @since   2019-05-12
 */
public class InvalidCarDataException extends Exception {
    /**
     * Constructs an {@code InvalidCarDataException} with {@code null}
     * as its error detail message.
     */
    public InvalidCarDataException(){
        super();
    }
    /**
     * Constructs an {@code InvalidCarDataException} with the specified detail message.
     *
     * @param message
     *        The detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method)
     */
    public InvalidCarDataException(String message){
        super(message);
    }
    /**
     * Constructs an {@code InvalidCarDataException} with the specified detail message
     * and cause.
     *
     * <p> Note that the detail message associated with {@code cause} is
     * <i>not</i> automatically incorporated into this exception's detail
     * message.
     *
     * @param message
     *        The detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method)
     *
     * @param cause
     *        The cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A null value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     */
    public InvalidCarDataException(String message, Throwable cause) {
        super(message, cause);
    }
    /**
     * Constructs an {@code InvalidCarDataException} with the specified cause and a
     * detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of {@code cause}).
     * This constructor is useful for IO exceptions that are little more
     * than wrappers for other throwables.
     *
     * @param cause
     *        The cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A null value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     */
    public InvalidCarDataException(Throwable cause) {
        super(cause);
    }
}
