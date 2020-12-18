package example.validator.model;

import lombok.Getter;

@Getter
public class MemberRequest {

    private String email;

    private String id;

    private String password;

    private String snsYn;
    private String name;
}
