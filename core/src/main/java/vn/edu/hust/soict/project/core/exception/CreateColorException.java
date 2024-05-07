package vn.edu.hust.soict.project.core.exception;

import vn.edu.hust.soict.project.core.constant.ErrorCodes;

public class CreateColorException extends ApplicationException{

    public CreateColorException() {
        super(ErrorCodes.CREATE_COLOR_FAIL.getMessage(), ErrorCodes.CREATE_COLOR_FAIL.getCode());
    }
}
