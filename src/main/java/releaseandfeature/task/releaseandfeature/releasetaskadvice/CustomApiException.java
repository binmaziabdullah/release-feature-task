package releaseandfeature.task.releaseandfeature.releasetaskadvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import releaseandfeature.task.releaseandfeature.custom_exception.PropertyNotFoundException;

@ControllerAdvice
public class CustomApiException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<String> idNotFoundException(PropertyNotFoundException e){
        return new ResponseEntity(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
    }
}
