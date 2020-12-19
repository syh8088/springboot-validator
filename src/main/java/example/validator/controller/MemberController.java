package example.validator.controller;

import example.validator.model.MemberRequest;
import example.validator.service.MemberService;
import example.validator.util.MemberValidator;
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
    private final MemberValidator memberValidator;

    @PostMapping("origin")
    public ResponseEntity<?> originSaveMember(@RequestBody MemberRequest memberRequest) {

        // validator.saveMember(memberRequest);
        return ResponseEntity.ok().body(memberService.originSaveMember(memberRequest));
    }


    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody MemberRequest memberRequest) {

       // validator.saveMember(memberRequest);
        return ResponseEntity.ok().body(memberService.saveMember(memberRequest));
    }


}
