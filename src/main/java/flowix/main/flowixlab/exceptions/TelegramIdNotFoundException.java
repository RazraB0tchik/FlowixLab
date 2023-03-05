package flowix.main.flowixlab.exceptions;

import org.springframework.security.core.AuthenticationException;

public class TelegramIdNotFoundException extends AuthenticationException {


    public TelegramIdNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public TelegramIdNotFoundException(String msg) {
        super(msg);
    }
}
