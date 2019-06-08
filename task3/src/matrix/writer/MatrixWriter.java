package matrix.writer;

import matrix.Matrix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class MatrixWriter {
    public void writeInFile (Matrix matrix, Path path) throws IOException {
        Files.write(path, matrix.toString().getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    }
}
