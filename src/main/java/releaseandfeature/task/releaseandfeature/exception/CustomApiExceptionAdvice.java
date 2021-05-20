package releaseandfeature.task.releaseandfeature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import releaseandfeature.task.releaseandfeature.exception.PropertyNotFoundException;

@ControllerAdvice
public class CustomApiExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<String> idNotFoundException(PropertyNotFoundException e){
        return new ResponseEntity(e.getLocalizedMessage(),HttpStatus.NOT_FOUND);
    }
}
