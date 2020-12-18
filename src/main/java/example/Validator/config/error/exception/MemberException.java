package example.Validator.config.error.exception;

import example.Validator.config.error.errorCode.ErrorCode;
import example.Validator.config.handler.CustomMessageHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MemberException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public MemberException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
    }

    @Override
    public String getMessage() {
        return message;
    }
}
