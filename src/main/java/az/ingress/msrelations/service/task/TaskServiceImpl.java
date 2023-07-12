package az.ingress.msrelations.service.task;

import az.ingress.msrelations.dao.entity.TaskEntity;
import az.ingress.msrelations.dao.repository.TaskRepository;
import az.ingress.msrelations.mapper.TaskMapper;
import az.ingress.msrelations.model.task.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author caci
 */

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Override
    public List<TaskDto> getAll() {
        return mapper.entitiesToDtos(repository.findAll());
    }

    @Override
    public void add(TaskDto taskDto) {
        TaskEntity task = mapper.dtoToEntity(taskDto);
        repository.save(task);
    }
}
