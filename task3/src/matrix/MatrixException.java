package matrix;

public class MatrixException extends RuntimeException {
    public MatrixException() {
        super();
    }
    public MatrixException(String msg) {
        super(msg);
    }
    public MatrixException(Throwable throwable) {
        super(throwable);
    }
    public MatrixException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
