package by.training.task3.entity.resource;

import by.training.task3.entity.matrix.Matrix;
import by.training.task3.entity.thread.MatrixThread;

/**
 * Common resource that stores a {@link Matrix}
 * to share between threads.
 */
public class MatrixResource extends CommonResource<Matrix> {
    /**
     * Defines the element on the main diagonal of the matrix
     * with indexes [{@code currIndex}, {@code currIndex}].
     * All elements on the main diagonal have the same number of row
     * as the number of column, where it is.
     * It is used by {@link MatrixThread} to change a defined element.
     */
    private int currIndex;

    /**
     * Constructor, that initializes this {@code value} and
     * {@code currIndex} with the smallest value of index
     * of the elements on th main diagonal.
     * <p>For example, if matrix is 7x10, than elements on the main diagonal
     * are accessed by indexes [0,0], [1,1], ..., [6, 6].</p>
     * @param object {@code Matrix} to be stored and shared
     */
    public MatrixResource(final Matrix object) {
        super(object);
        currIndex = Math.min(
                object.getNumberOfRows(),
                object.getNumberOfColumns()
        ) - 1;
    }

    /**
     * Returns the value of current index.
     * @return {@code currIndex}
     */
    public int getCurrIndex() {
        return currIndex;
    }

    /**
     * Sets a current index.
     * @param index value to set
     */
    public void setCurrIndex(int index) {
        this.currIndex = index;
    }
}
