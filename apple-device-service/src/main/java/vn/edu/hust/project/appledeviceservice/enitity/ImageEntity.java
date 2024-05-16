package vn.edu.hust.project.appledeviceservice.enitity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageEntity extends BaseEntity {

    private Long entity_id;

    private String img;

    private String type;
}
