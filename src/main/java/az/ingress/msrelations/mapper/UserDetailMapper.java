package az.ingress.msrelations.mapper;

import az.ingress.msrelations.dao.entity.UserDetailEntity;
import az.ingress.msrelations.model.userDetail.UserDetailDto;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * @author caci
 */

@Mapper(componentModel = "spring")
public abstract class UserDetailMapper {

    public abstract UserDetailEntity dtoToEntity(UserDetailDto dto);
    public abstract UserDetailDto entityToDto(UserDetailEntity entity);

    public abstract List<UserDetailEntity> dtosToEntities(List<UserDetailDto> dtos);
    public abstract List<UserDetailDto> entitiesToDtos(List<UserDetailEntity> entities);


}
