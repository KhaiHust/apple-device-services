package vn.edu.hust.project.appledeviceservice.enitity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetailWebResponse {
    private Long id;
    private String name;
    private String bannerImg;
    private Long productId;
    private  Long colorId;
    private Long storageId;
    private Long unitPrice;
    private Long price;

    private List<ImageEntity> images;
    private ProductEntity product;

    private List<RelatedColorWebResponse> relatedColors;
    private List<RelatedStorageResponse> relatedStorages;

}
