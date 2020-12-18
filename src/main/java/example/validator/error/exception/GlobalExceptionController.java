package example.validator.error.exception;

import example.validator.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MemberException.class) // 클래스 단위로도 사용 가능(필요한 컨트롤러 내에 선언)
    @ResponseBody
    public CommonResponse handleBaseException(MemberException e) {
        System.out.println(e.getMessage());
        System.out.println(e.getErrorCode());
        /*
            여기서 원하는 형태로 response 하면 됩니다!!!!
         */
        return CommonResponse.builder()
                .errorCode(e.getErrorCode())
                .message(e.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BoardException.class) // 클래스 단위로도 사용 가능(필요한 컨트롤러 내에 선언)
    @ResponseBody
    public String handleBaseException(BoardException e) {
        return e.getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException() {
        return "error";
    }

}
