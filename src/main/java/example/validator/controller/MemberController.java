package example.validator.controller;

import example.validator.model.MemberRequest;
import example.validator.service.MemberService;
import example.validator.util.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final Validator validator;

    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody MemberRequest memberRequest) {

        validator.saveMember(memberRequest);
        return ResponseEntity.ok().body(memberService.saveMember(memberRequest));
    }


}
