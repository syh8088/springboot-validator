package example.validator.service;

import example.validator.common.CommonResponse;
import example.validator.error.errorCode.MemberErrorCode;
import example.validator.model.MemberRequest;
import example.validator.util.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberValidator memberValidator;

    public CommonResponse originSaveMember(MemberRequest memberRequest) {

        if (memberRequest.getPassword().length() < 10) {
            return CommonResponse.builder()
                    .errorCode(MemberErrorCode.NOT_VALID_PASSWORD_LENGTH.getCode())
                    .message("패스워드 길이 오류")
                    .build();
        }

        /*
            비지니스 로직
         */
        return null;
    }

    public String saveMember(MemberRequest memberRequest) {
        memberValidator.saveMember(memberRequest);

        /*
            비지니스 로직
         */


        return "ok";
    }

}
