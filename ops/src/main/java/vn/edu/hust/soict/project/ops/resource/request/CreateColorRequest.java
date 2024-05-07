package vn.edu.hust.soict.project.ops.resource.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateColorRequest {

    @NotNull(message = "Color name must not be null")
    private String name;

    @NotNull(message = "Color code must not be null")
    private String code;

    private String description;
}
