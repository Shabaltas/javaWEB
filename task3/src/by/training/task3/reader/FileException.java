package by.training.task3.reader;

import java.io.IOException;

/**
 * Signals that an I/O exception of some sort has occurred
 * while reading a file or writing in a file.
 */
public class FileException extends IOException {
    /**
     * Constructs an {@code FileException} with {@code null}
     * as its error detail message.
     */
    public FileException() {
        super();
    }
    /**
     * Constructs an {@code FileException} with the specified detail message.
     *
     * @param msg
     *        The detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method)
     */
    public FileException(String msg) {
        super(msg);
    }
    /**
     * Constructs an {@code FileException} with the specified cause and a
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

    public FileException(Throwable cause) {
        super(cause);
    }
    /**
     * Constructs an {@code IOException} with the specified detail message
     * and cause.
     * @param msg
     *        The detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method)
     *
     * @param cause
     *        The cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A null value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     */
    public FileException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
