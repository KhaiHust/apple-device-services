package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductDetailRequest {
    private Long productId;

    private Long colorId;

    private Long storageId;

    private Long price;

    private Long unitPrice;

    private List<String> images;

    private String bannerImg;
}
