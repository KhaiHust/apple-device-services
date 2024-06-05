package vn.edu.hust.project.appledeviceservice.enitity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RelatedColorWebResponse {
    private Long productDetailId;
    private String bannerImg;
    private ColorEntity color;
    private Long unitPrice;
    private Long price;
    private InventoryWebResponse inventory;
}
