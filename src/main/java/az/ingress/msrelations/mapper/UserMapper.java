package az.ingress.msrelations.mapper;

import az.ingress.msrelations.dao.entity.UserDetailEntity;
import az.ingress.msrelations.dao.entity.UserEntity;
import az.ingress.msrelations.model.user.UserDto;
import az.ingress.msrelations.model.userDetail.UserDetailDto;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author caci
 */

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Mapping(target = "userDetail", source = "userDetail", qualifiedByName = "userDetailDtoToUserDetailEntity")
    public abstract UserEntity dtoToEntity(UserDto dto);
    public abstract UserDto entityToDto(UserEntity entity);

    public abstract List<UserEntity> dtosToEntities(List<UserDto> dtos);
    public abstract List<UserDto> entitiesToDtos(List<UserEntity> entities);


    @Named("userDetailDtoToUserDetailEntity")
    public UserDetailEntity userDetailDtoToUserDetailEntity(UserDetailDto dto){
        return userDetailMapper.dtoToEntity(dto);
    }
}
