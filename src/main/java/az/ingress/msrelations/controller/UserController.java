package az.ingress.msrelations.controller;

import az.ingress.msrelations.model.user.UserDto;
import az.ingress.msrelations.service.user.UserService;
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
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "the User api")
public class UserController {

    private final UserService service;

    @GetMapping
    @Operation(summary = "get all", description = "get all", tags = {"User"})
    public List<UserDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{user-id}")
    @Operation(summary = "get user by id", description = "get user by id", tags = {"User"})
    public UserDto getById(@PathVariable("user-id") Long id){
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "add", description = "add", tags = {"User"})
    @ResponseStatus(CREATED)
    public void savePost(@RequestBody @Valid @NotNull UserDto dto){
        service.add(dto);
    }

}
