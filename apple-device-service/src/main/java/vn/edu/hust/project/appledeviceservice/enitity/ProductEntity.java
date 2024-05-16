package vn.edu.hust.project.appledeviceservice.enitity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity extends BaseEntity{

    private String name;

    private String code;

    private String description;

    private String bannerImg;

    private String status;

    private String warrantyDuration;

    private Long typeId;

    private List<ImageEntity> descriptionImages;

    private List<ImageEntity> images;
}
