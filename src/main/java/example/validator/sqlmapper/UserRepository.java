package example.validator.sqlmapper;

import example.validator.domain.user.dto.transfer.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDto, Long> {
    List<UserDto> findAllByUsernameLike(String username);
}
