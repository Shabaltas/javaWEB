package by.training.task3.entity.matrix;

import java.util.Arrays;

/**
 * Class-entity representing two-dimensional array(matrix)
 * as an separate class.
 * <p>Provides method to work with two-dimensional array.
 */
public class Matrix {
    /**
     * Two-dimensional integer array.
     */
    private int[][] matrix;

    /**
     * Constructor.
     * @param rows number of new {@code Matrix}' rows
     * @param cols  number of new {@code Matrix}' columns
     */
    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new MatrixException("Negative value for array size");
        }
        matrix = new int[rows][cols];
    }

    /**
     * Constructor thar creates square matrix,
     * that means number of rows is the same as number of columns.
     * @param size number of new {@code Matrix}' rows and columns
     */
    public Matrix(int size) {
        this(size, size);
    }

    /**
     * Returns the number of this {@code Matrix}' rows.
     * @return the number of rows
     */
    public int getNumberOfRows() {
        return matrix.length;
    }

    /**
     * Returns the number of this {@code Matrix}' columns.
     * @return the number of columns
     */
    public int getNumberOfColumns() {
        return matrix[0].length;
    }

    /**
     * Returns this {@code Matrix}' element by indexes.
     * @param row the number of row,
     *            where necessary element is
     * @param col the number of column,
     *            where necessary element is
     * @return this {@code Matrix}' element
     * @throws MatrixException if {@code row} or {@code col}
     *                         is out of range
     */
    public int getElement(int row, int col) {
        if (isValidIndexes(row, col)) {
            return matrix[row][col];
        }
        throw new MatrixException("Indexes out of range");
    }

    /**
     * Initialize this {@code Matrix}' element,
     * located by the specified numbers of row and columns
     * with the integer value.
     * @param row the number of row
     * @param col the number of column
     * @param value assigned value
     * @throws MatrixException if {@code row} or {@code col}
     *                         is out of range
     */
    public void setElement(int row, int col, int value) {
        if (isValidIndexes(row, col)) {
            matrix[row][col] = value;
        } else {
            throw new MatrixException("Indexes out of range");
        }
    }

    /**
     * Assigns all the element of this {@code Matrix}
     * with specified value.
     * @param value assigned value
     */
    public void fill(int value) {
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, value));
    }

    /**
     * Check if the indexes are valid.
     * @param row the number of row
     * @param col the number of column
     * @return {@code true} if indexes are in the range,
     *          otherwise {@code false}
     */
    private boolean isValidIndexes(int row, int col) {
        return (row > -1
                && col > -1
                && row < getNumberOfRows()
                && col < getNumberOfColumns());
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * @return a string representation of the {@code Matrix}.
     */
    @Override
    public String toString() {
        StringBuilder matrixToString = new StringBuilder();
        for (int[] row : matrix) {
            for (int element : row) {
                matrixToString.append(element).append(" ");
            }
            matrixToString.append("\n");
        }
        return matrixToString.toString();
    }
}
