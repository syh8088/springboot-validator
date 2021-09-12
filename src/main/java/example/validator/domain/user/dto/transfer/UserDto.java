package example.validator.domain.user.dto.transfer;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {
    @Id
    private Long id;
    private String username;

    @Builder
    public static UserDto createUserDto(String username) {

        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        return userDto;
    }
}
