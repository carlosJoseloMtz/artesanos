package mx.nopal.commerce.customers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Item already exists")
public class ItemAlreadyExistsException extends Exception {
    public ItemAlreadyExistsException(final String message) {
        super(message);
    }
}
