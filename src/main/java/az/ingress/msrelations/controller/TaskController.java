package az.ingress.msrelations.controller;

import az.ingress.msrelations.model.task.TaskDto;
import az.ingress.msrelations.service.task.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author caci
 */

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
@Tag(name = "Task", description = "the Task api")
public class TaskController {

    private final TaskService service;

    @GetMapping
    @Operation(summary = "get all", description = "get all", tags = {"Task"})
    public List<TaskDto> getAll(){
        return service.getAll();
    }

    @PostMapping
    @Operation(summary = "add", description = "add", tags = {"Task"})
    @ResponseStatus(CREATED)
    public void add(@RequestBody @Valid @NotNull TaskDto dto){
        service.add(dto);
    }

}
