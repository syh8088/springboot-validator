package example.validator.domain.user.service;

import example.validator.domain.user.dto.request.InsertUserRequestDto;
import example.validator.sqlmapper.UserRepository;
import example.validator.domain.user.dto.request.SelectUserRequestDto;
import example.validator.domain.user.dto.response.UserResponseDto;
import example.validator.domain.user.dto.transfer.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDto> selectUsers(SelectUserRequestDto selectUserRequestDto) {

        List<UserDto> userDtoList = userRepository.findAllByUsernameLike(selectUserRequestDto.getUsername());

        return userDtoList.stream()
                .map(userDto -> UserResponseDto.createUserResponseDto(userDto.getUsername()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void insertUser(InsertUserRequestDto insertUserRequestDto) {
        UserDto userDto = UserDto.createUserDto(insertUserRequestDto.getUsername());

        userRepository.save(userDto);
    }
}
