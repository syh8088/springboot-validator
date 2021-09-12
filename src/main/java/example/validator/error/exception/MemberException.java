package example.validator.error.exception;

import example.validator.config.handler.CustomMessageHandler;
import example.validator.error.errorCode.ErrorCode;
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

    public MemberException(ErrorCode errorCode, Object[] errorMessages) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode(), errorMessages);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode.getCode();
    }
}
