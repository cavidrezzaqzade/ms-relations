package az.ingress.msrelations.service;

import az.ingress.msrelations.model.UserDetails;
import az.ingress.msrelations.model.UserDto;

import java.util.List;


/**
 * @author caci
 */

public interface UserService {

    List<UserDto> getAll();

    UserDto add(UserDto userDto);

    void delete(Long id);

    UserDto update(UserDto dto, Long id);

    UserDto update(UserDetails userDetails);

}
