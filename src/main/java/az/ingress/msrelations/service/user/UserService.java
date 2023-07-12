package az.ingress.msrelations.service.user;

import az.ingress.msrelations.model.user.UserDto;
import java.util.List;


/**
 * @author caci
 */

public interface UserService {

    List<UserDto> getAll();

    void add(UserDto userDto);

}
