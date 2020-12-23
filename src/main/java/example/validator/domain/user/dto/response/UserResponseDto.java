package example.validator.domain.user.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {
    private String username;

    @Builder
    public static UserResponseDto createUserResponseDto(String username) {

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(username);
        return userResponseDto;
    }
}
