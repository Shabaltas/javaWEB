package by.training.task2.reader;

public class FileReaderException extends RuntimeException {
    FileReaderException() {
        super();
    }

    FileReaderException(String msg) {
        super(msg);
    }

    FileReaderException(Throwable throwable) {
        super(throwable);
    }

    FileReaderException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
