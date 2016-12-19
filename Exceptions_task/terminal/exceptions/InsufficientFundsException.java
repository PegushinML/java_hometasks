package Exceptions_task.terminal.exceptions;

/**
 * Created by Maxim on 11/13/2016.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {};

    public InsufficientFundsException(String message) {
        super(message);
    }
}
