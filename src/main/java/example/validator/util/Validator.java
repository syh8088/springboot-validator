package example.validator.util;

import example.validator.error.errorCode.MemberErrorCode;
import example.validator.error.exception.MemberException;
import example.validator.model.MemberRequest;
import org.springframework.stereotype.Component;

@Component
public class Validator {


    public void saveMember(MemberRequest memberRequest) {

        if (memberRequest.getPassword().length() < 10) {
            throw new MemberException(MemberErrorCode.NOT_VALID_PASSWORD_LENGTH);
        }
    }

}
