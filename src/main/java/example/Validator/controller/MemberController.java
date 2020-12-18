package example.Validator.controller;

import example.Validator.model.MemberRequest;
import example.Validator.service.MemberService;
import example.Validator.util.validator.member.MemberValidator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("members")
public class MemberController {

    private final MemberService memberService;
    private final MemberValidator memberValidator;

    @Autowired
    public MemberController(MemberService memberService, MemberValidator memberValidator) {
        this.memberService = memberService;
        this.memberValidator = memberValidator;
    }

    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody MemberRequest memberRequest) {

        // 데이터 유효성 검증
        memberValidator.saveMember(memberRequest);

        return ResponseEntity.ok().body(memberService.saveMember(memberRequest));
    }
}
