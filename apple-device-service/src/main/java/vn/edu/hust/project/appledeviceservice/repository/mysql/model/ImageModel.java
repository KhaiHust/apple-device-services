package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "images")
public class ImageModel extends BaseModel{

    @Column(name = "img")
    private String img;

    @Column(name = "type")
    private String type;

    @Column(name = "entity_id")
    private Long entityId;
}
