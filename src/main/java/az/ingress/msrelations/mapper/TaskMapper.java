package az.ingress.msrelations.mapper;

import az.ingress.msrelations.dao.entity.TaskEntity;
import az.ingress.msrelations.model.task.TaskDto;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * @author caci
 */

@Mapper(componentModel = "spring")
public abstract class TaskMapper {

    public abstract TaskEntity dtoToEntity(TaskDto dto);
    public abstract TaskDto entityToDto(TaskEntity entity);

    public abstract List<TaskEntity> dtosToEntities(List<TaskDto> dtos);
    public abstract List<TaskDto> entitiesToDtos(List<TaskEntity> entities);

}
