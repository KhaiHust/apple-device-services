package vn.edu.hust.soict.project.core.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApplicationException extends RuntimeException {
    private String message;
    private Long code;
}
