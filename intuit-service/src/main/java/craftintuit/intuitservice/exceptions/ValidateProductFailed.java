package craftintuit.intuitservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ValidateProductFailed extends RuntimeException {
	public ValidateProductFailed(String message) {
        super(message);
 }
}
