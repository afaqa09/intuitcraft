package craftintuit.intuitservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerFoundException extends RuntimeException {
	public CustomerFoundException(String message) {
        super(message);
 }
}
