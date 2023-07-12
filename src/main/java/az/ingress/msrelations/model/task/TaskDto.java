package az.ingress.msrelations.model.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author caci
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

}
