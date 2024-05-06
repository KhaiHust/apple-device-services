package vn.edu.hust.soict.project.core.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resource {
    private Long code;
    private String message;
    private Object data;

}
