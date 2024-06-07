package exceptions;

public class IncorrectUserOrPasswordException extends RuntimeException {

    public IncorrectUserOrPasswordException(String message) {
        super(message);
    }

}
