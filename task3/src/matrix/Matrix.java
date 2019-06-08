package matrix;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int cols) throws MatrixException {
        if (rows < 1 || cols < 1) {
            throw new MatrixException("Negative value for array size");
        }
        matrix = new int[rows][cols];
    }

    public Matrix(int size) {
        if (size < 1) {
            throw new MatrixException("Negative value for array size");
        }
        matrix = new int[size][size];
    }

    public int getNumberOfRows() {
        return matrix.length;
    }

    public int getNumberOfColumns() {
        return matrix[0].length;
    }

    public int getElement(int row, int col) {
        if (isValidIndexes(row, col)) {
            return matrix[row][col];
        }
        throw new MatrixException("Indexes out of range");
    }

    public void setElement(int row, int col, int value) {
        if (isValidIndexes(row, col)) {
            matrix[row][col] = value;
        } else {
            throw new MatrixException("Indexes out of range");
        }
    }

    public void fill (int value) {
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, value));
    }

    private boolean isValidIndexes(int row, int col) {
        return (row > -1 && col > -1 && row < getNumberOfRows() && col < getNumberOfColumns());
    }

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
