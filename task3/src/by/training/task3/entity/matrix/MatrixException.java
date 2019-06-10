package by.training.task3.entity.matrix;


/**
 * Thrown to indicate that a matrix has been accessed with an
 * illegal index. The index is either negative or greater than or
 * equal to the size of the array.
 */
public class MatrixException extends RuntimeException {
    /**
     * Constructs an {@code MatrixException} with no
     * detail message.
     */
    public MatrixException() {
        super();
    }
     /**
      * Constructs an {@code MatrixException} class
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MatrixException(String msg) {
        super(msg);
    }
}
