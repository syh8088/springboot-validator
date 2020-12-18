package example.validator.common;

import example.validator.error.errorCode.ErrorCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponse {

    private String errorCode;
    private String message;
}
