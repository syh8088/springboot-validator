package example.validator.service;

import example.validator.model.MemberRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public String saveMember(MemberRequest memberRequest) {


        return "ok";
    }
}
