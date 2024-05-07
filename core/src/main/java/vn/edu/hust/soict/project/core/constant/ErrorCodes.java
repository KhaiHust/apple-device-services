package vn.edu.hust.soict.project.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ErrorCodes {
    CREATE_COLOR_FAIL(400001L, "Create color fail");

    private final Long code;
    private final String message;

}
