package az.ingress.msrelations.service.task;

import az.ingress.msrelations.model.task.TaskDto;
import java.util.List;


/**
 * @author caci
 */

public interface TaskService {

    List<TaskDto> getAll();

    void add(TaskDto taskDto);

}
