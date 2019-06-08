package matrix.creator;

import matrix.Matrix;
import matrix.reader.MatrixReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class MatrixCreator {

    public void fillFromFile(Matrix matrix, Path path, int size) throws IOException {
        List<List<String>> stringMatrix = new MatrixReader().readFromFile(path, size);
        int N = size;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix.setElement(i, j, Integer.valueOf(stringMatrix.get(i).get(j)));
            }
        }
    }
}
