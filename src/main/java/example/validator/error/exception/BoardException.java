package example.validator.error.exception;

import example.validator.config.handler.CustomMessageHandler;
import example.validator.error.errorCode.ErrorCode;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BoardException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;
    private int limitWrite;

    public BoardException(ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
    }

    public BoardException(ErrorCode errorCode, int limitWrite) {
        super(errorCode.getCode());
        this.limitWrite = limitWrite;
        this.errorCode = errorCode;
        this.message = CustomMessageHandler.getMessage(errorCode.getCode());
    }

    @Override
    public String getMessage() {
//        if(StringUtils.contains(message, "{:limitWrite:}")) {
//            message = StringUtils.replace(message, "{:limitWrite:}", String.valueOf(limitWrite));
//        }

        return message;
    }

}
