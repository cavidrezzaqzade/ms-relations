package az.ingress.msrelations.model.userDetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author caci
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank
    String address;

    @NotBlank
    String phone;
}
