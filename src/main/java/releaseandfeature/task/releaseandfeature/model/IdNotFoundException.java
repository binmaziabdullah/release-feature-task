package releaseandfeature.task.releaseandfeature.model;

import org.apache.logging.log4j.message.FormattedMessage;

import java.util.Formatter;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(String message) {
        super(message);
    }
}
