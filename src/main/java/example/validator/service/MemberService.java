package example.validator.service;

import example.validator.model.MemberRequest;
import example.validator.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final Validator validator;


    public String saveMember(MemberRequest memberRequest) {
        validator.saveMember(memberRequest);

        return "ok";
    }
}
