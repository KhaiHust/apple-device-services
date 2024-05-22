package vn.edu.hust.project.appledeviceservice.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailEntity {

    private String name;

    private String bannerImg;

    private Long productId;

    private Long colorId;

    private Long storageId;

    private Long unitPrice;

    private Long price;

    private List<ImageEntity> images;
}
