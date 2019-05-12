package by.training.task1.exception;

public class InvalidCarDataException extends Exception {

    public InvalidCarDataException(){
        super();
    }

    public InvalidCarDataException(String message){
        super(message);
    }

    public InvalidCarDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCarDataException(Throwable cause) {
        super(cause);
    }
}
