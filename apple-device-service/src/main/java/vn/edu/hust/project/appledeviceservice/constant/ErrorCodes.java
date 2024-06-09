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

    GET_PRODUCT_NOT_FOUND(4000011L, "Get product not found"),

    GET_PRODUCT_DETAIL_NOT_FOUND(4000012L, "Get product detail not found"),

    CREATE_USER_FAIL(4000013L, "Create user fail"),

    GET_USER_NOT_FOUND(4000014L, "Get user not found"),

    GET_ROLE_NOT_FOUND(4000015L, "Get role not found"),

    EMAIL_IS_EXISTED(4000016L, "Email is existed"),

    INVALID_EMAIL_OR_PASSWORD(4000017L, "Invalid email or password"),

    UNEXPECTED_ERROR(4000018L, "Unexpected error"),

    REMOVE_COLOR_FAIL(4000019L, "Remove color fail"),

    REMOVE_STORAGE_FAIL(4000020L, "Remove storage fail"),

    REMOVE_TYPE_FAIL(4000021L, "Remove type fail"),

    CREATE_CART_FAIL(4000022L, "Create cart fail"),

    BAD_REQUEST(400L, "Bad request"),

    UPDATE_CART_FAIL(4000023L, "Update cart fail"),

    GET_CART_NOT_FOUND(4000024L, "Cart not found"),

    DELETE_CART_FAIL(4000025L, "Delete cart fail"),
    ;

    private final Long code;
    private final String message;

}
