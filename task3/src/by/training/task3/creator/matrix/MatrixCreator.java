package by.training.task3.creator.matrix;

import by.training.task3.reader.FileException;
import by.training.task3.entity.matrix.Matrix;
import by.training.task3.reader.matrix.MatrixReader;

import java.nio.file.Path;
import java.util.List;

public class MatrixCreator {

    public void fillFromFile(Matrix matrix, Path path) throws FileException {
        int N = matrix.getNumberOfRows();
        List<List<String>> stringMatrix = new MatrixReader().readFromFile(path, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix.setElement(i, j, Integer.parseInt(stringMatrix.get(i).get(j)));
            }
        }
    }
}
