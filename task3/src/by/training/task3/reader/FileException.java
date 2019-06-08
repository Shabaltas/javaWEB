package by.training.task3.reader;

import java.io.IOException;

public class FileException extends IOException {
    public FileException() {
        super();
    }
    public FileException(String msg) {
        super(msg);
    }
    public FileException(Throwable throwable) {
        super(throwable);
    }
    public FileException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
