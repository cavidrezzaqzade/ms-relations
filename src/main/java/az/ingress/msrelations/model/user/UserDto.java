package az.ingress.msrelations.model.user;

import az.ingress.msrelations.model.userDetail.UserDetailDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

/**
 * @author caci
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank
    String name;

    UserDetailDto userDetail;

    List<Long> roleIds;

}
