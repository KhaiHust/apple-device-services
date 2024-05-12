package vn.edu.hust.project.appledeviceservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateColorRequest {

    @NotNull(message = "Color name must not be null")
    private String name;

    @NotNull(message = "Color code must not be null")
    private String code;

    private String description;
}
