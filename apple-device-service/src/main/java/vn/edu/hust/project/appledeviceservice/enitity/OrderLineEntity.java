package vn.edu.hust.project.appledeviceservice.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineEntity extends BaseEntity{
    private Long orderId;
    private String code;
    private Long quantity;
    private Long productDetailId;
}
