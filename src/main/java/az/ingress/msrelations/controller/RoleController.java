package az.ingress.msrelations.controller;

import az.ingress.msrelations.model.role.RoleDto;
import az.ingress.msrelations.service.role.RoleService;
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
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
@Tag(name = "Role", description = "the Role api")
public class RoleController {

    private final RoleService service;

    @GetMapping
    @Operation(summary = "get all", description = "get all", tags = {"Role"})
    public List<RoleDto> getAll(){
        return service.getAll();
    }

    @PostMapping
    @Operation(summary = "add", description = "add", tags = {"Role"})
    @ResponseStatus(CREATED)
    public void add(@RequestBody @Valid @NotNull RoleDto dto){
        service.add(dto);
    }

}
