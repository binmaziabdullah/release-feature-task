package releaseandfeature.task.releaseandfeature.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class PropertyNotFoundException extends RuntimeException{

    public PropertyNotFoundException(String message) {
        super(message);
    }
}
