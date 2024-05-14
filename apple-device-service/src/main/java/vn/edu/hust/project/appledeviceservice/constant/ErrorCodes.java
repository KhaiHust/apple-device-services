package vn.edu.hust.project.appledeviceservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodes {
    CREATE_COLOR_FAIL(400001L, "Create color fail"),

    CREATE_STORAGE_FAIL(400002L, "Create storage fail"),

    CREATE_TYPE_FAIL(400003L, "Create type fail");

    private final Long code;
    private final String message;

}
