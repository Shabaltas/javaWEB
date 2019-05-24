package by.training.task2.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {

    public String readFileToString(String fpath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fpath)));
    }
}
