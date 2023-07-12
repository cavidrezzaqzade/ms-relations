package az.ingress.msrelations.mapper;

import az.ingress.msrelations.dao.entity.RoleEntity;
import az.ingress.msrelations.dao.entity.UserEntity;
import az.ingress.msrelations.model.role.RoleDto;
import az.ingress.msrelations.model.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author caci
 */

@Mapper(componentModel = "spring")
public abstract class RoleMapper {

    public abstract RoleEntity dtoToEntity(RoleDto dto);
    public abstract RoleDto entityToDto(RoleEntity entity);

    public abstract List<RoleEntity> dtosToEntities(List<RoleDto> dtos);
    public abstract List<RoleDto> entitiesToDtos(List<RoleEntity> entities);


}
