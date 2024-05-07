package vn.edu.hust.soict.project.core.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Resource {
    private Long code;
    private String message;
    private Object data;

    public Resource(Object data) {
        this.code = (long) HttpStatus.OK.value();
        this.message = "Success";
        this.data = data;
    }

}
