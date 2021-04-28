package releaseandfeature.task.releaseandfeature.custom_exception;

public class  IdNotFoundException extends RuntimeException{

    public IdNotFoundException(String message) {
        super(message);
    }
}
