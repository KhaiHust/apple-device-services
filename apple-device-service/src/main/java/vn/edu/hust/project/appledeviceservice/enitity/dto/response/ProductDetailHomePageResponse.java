package vn.edu.hust.project.appledeviceservice.enitity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailHomePageResponse {
    private String id;
    private String name;
    private String description;
    private String bannerImg;
    private Long unitPrice;
    private Long price;
    private String type;
    private String slug;
}
