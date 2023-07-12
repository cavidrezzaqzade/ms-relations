package az.ingress.msrelations.service.role;

import az.ingress.msrelations.dao.entity.RoleEntity;
import az.ingress.msrelations.dao.repository.RoleRepository;
import az.ingress.msrelations.mapper.RoleMapper;
import az.ingress.msrelations.model.role.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public void add(RoleDto roleDto) {
        RoleEntity role = mapper.dtoToEntity(roleDto);
        repository.save(role);
    }
}
