package az.ingress.msrelations.service.role;

import az.ingress.msrelations.model.role.RoleDto;

import java.util.List;

/**
 * @author caci
 */

public interface RoleService {

    List<RoleDto> getAll();
    void add(RoleDto dto);

}
