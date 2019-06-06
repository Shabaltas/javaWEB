package by.training.task2.utility;

public class FileWriteException extends Exception {
    FileWriteException() {
        super();
    }

    FileWriteException(String msg) {
        super(msg);
    }

    FileWriteException(Throwable throwable) {
        super(throwable);
    }

    FileWriteException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
