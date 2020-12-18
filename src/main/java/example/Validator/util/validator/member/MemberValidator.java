package example.Validator.util.validator.member;


import example.Validator.config.error.errorCode.MemberErrorCode;
import example.Validator.config.error.exception.MemberException;
import example.Validator.model.MemberRequest;
import org.springframework.stereotype.Component;

@Component
public class MemberValidator {


    public void saveMember(MemberRequest memberRequest) {

        if (memberRequest.getPassword().length() < 10) {
            throw new MemberException(MemberErrorCode.NOT_VALID_PASSWORD_LENGTH);
        }
    }
}
