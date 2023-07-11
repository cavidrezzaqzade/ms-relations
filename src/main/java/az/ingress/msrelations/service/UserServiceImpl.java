package az.ingress.msrelations.service;

import az.ingress.msrelations.dao.entity.User;
import az.ingress.msrelations.dao.repository.UserRepository;
import az.ingress.msrelations.exception.ApplicationException;
import az.ingress.msrelations.mapper.UserMapper;
import az.ingress.msrelations.model.UserDetails;
import az.ingress.msrelations.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static az.ingress.msrelations.exception.Errors.DATA_NOT_FOUND;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;

    private static final Integer PAGE_DEFAULT = 1;
    private static final Integer COUNT_DEFAULT = 10;

    @SneakyThrows
    @Override
    public List<UserDto> getAll() {
        List<User> users = repository.findAll();
        return mapper.entitiesToDtos(users);
    }

    @Override
    public UserDto add(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        return mapper.entityToDto(repository.save(user));
    }

    @Override
    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ApplicationException(DATA_NOT_FOUND, Map.of("id", id)));
        repository.delete(user);
    }

    @Override
    public UserDto update(UserDto dto, Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ApplicationException(DATA_NOT_FOUND, Map.of("id", id)));
        User userNew = mapper.updateUser(user, dto);
        return mapper.entityToDto(repository.save(userNew));
    }

    @Override
    public UserDto update(UserDetails userDetails) {
        User user = repository.findById(userDetails.getId()).orElseThrow(() -> new ApplicationException(DATA_NOT_FOUND, Map.of("id", userDetails.getId())));

        user.setAge(userDetails.getAge());
        user.setName(userDetails.getName());

        return mapper.entityToDto(repository.save(user));
    }

}
