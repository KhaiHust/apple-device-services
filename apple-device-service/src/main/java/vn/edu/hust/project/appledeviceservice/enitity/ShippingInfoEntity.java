package vn.edu.hust.project.appledeviceservice.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShippingInfoEntity extends BaseEntity{
    private String label;
    private String receivedName;
    private String phone;
    private String address;
    private String wardCode;
    private String districtCode;
    private String provinceCode;
    private String note;
    private String userId;
    private ProvinceEntity province;
    private DistrictEntity district;
    private WardEntity ward;
}
