package az.ingress.msrelations.service.user;

import az.ingress.msrelations.dao.entity.RoleEntity;
import az.ingress.msrelations.dao.entity.UserEntity;
import az.ingress.msrelations.dao.repository.UserRepository;
import az.ingress.msrelations.mapper.UserMapper;
import az.ingress.msrelations.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public void add(UserDto userDto) {
        UserEntity user = mapper.dtoToEntity(userDto);

//        user.getUserDetail().setUser(user);

        user.addRole(new RoleEntity(1L));

        repository.save(user);
    }

}
