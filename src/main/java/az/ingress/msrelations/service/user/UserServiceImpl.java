package az.ingress.msrelations.service.user;

import az.ingress.msrelations.dao.entity.RoleEntity;
import az.ingress.msrelations.dao.entity.UserEntity;
import az.ingress.msrelations.dao.repository.UserRepository;
import az.ingress.msrelations.exception.ApplicationException;
import az.ingress.msrelations.exception.Errors;
import az.ingress.msrelations.mapper.UserMapper;
import az.ingress.msrelations.model.user.UserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> users = repository.findAll();
        return mapper.entitiesToDtos(users);
    }

    @Override
    public UserDto getById(Long id) {
        UserEntity user = repository.findById(id).orElseThrow(() ->
                new ApplicationException(Errors.DATA_NOT_FOUND, Map.of("id", id)));
        return mapper.entityToDto(user);
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void add(UserDto userDto) {
        UserEntity user = mapper.dtoToEntity(userDto);

        user.getUserDetail().setUser(user);

        userDto.getRoleIds().forEach(id -> user.addRole(new RoleEntity(id)));

        repository.save(user);
    }

}
