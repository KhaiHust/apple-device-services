package vn.edu.hust.project.appledeviceservice.enitity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RelatedStorageResponse {
    private Long productDetailId;
    private String bannerImg;
    private StorageEntity storage;
    private InventoryWebResponse inventory;
}
