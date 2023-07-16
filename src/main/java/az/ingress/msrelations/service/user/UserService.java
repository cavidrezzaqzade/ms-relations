package az.ingress.msrelations.service.user;

import az.ingress.msrelations.dao.entity.UserEntity;
import az.ingress.msrelations.model.user.UserDto;
import java.util.List;
import java.util.Optional;


/**
 * @author caci
 */

public interface UserService {
    List<UserDto> getAll();
    UserDto getById(Long id);
    void add(UserDto userDto);
}
