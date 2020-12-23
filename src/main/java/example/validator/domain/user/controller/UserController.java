package example.validator.domain.user.controller;

import example.validator.domain.user.dto.request.InsertUserRequestDto;
import example.validator.domain.user.dto.request.SelectUserRequestDto;
import example.validator.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> selectUsers(@RequestBody SelectUserRequestDto selectUserRequestDto) {

        return ResponseEntity.ok().body(userService.selectUsers(selectUserRequestDto));
    }

    @PostMapping
    public ResponseEntity<?> insertUser(@RequestBody InsertUserRequestDto insertUserRequestDto) {

        userService.insertUser(insertUserRequestDto);
        return ResponseEntity.noContent().build();
    }
}

