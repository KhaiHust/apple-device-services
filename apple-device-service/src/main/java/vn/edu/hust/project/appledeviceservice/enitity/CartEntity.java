package vn.edu.hust.project.appledeviceservice.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartEntity extends BaseEntity {
    private Long userId;
    private Long productDetailId;
    private Long quantity;
    private ProductDetailEntity productDetail;
}
