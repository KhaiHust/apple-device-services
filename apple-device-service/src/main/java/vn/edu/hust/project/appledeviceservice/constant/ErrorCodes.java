package vn.edu.hust.project.appledeviceservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodes {
    CREATE_COLOR_FAIL(400001L, "Create color fail"),

    CREATE_STORAGE_FAIL(400002L, "Create storage fail"),

    CREATE_TYPE_FAIL(400003L, "Create type fail"),

    CREATE_IMAGE_FAIL(400004L, "Create image fail"),

    CREATE_PRODUCT_FAIL(400005L, "Create product fail"),

    GET_TYPE_NOT_FOUND(400006L, "Get type not found"),

    GET_COLOR_NOT_FOUND(400007L, "Get color not found"),

    GET_STORAGE_NOT_FOUND(400008L, "Get storage not found"),

    CREATE_PRODUCT_DETAIL_NOT_FOUND(400009L, "Create product detail fail"),

    CREATE_INVENTORY_FAIL(4000010L, "Create inventory fail"),

    GET_PRODUCT_NOT_FOUND(4000011L, "Get product not found")
    ;

    private final Long code;
    private final String message;

}
