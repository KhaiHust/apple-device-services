package vn.edu.hust.project.appledeviceservice.enitity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity extends BaseEntity{
    private Long userId;
    private String code;
    private String state;
    private String paymentMethod;
    private String paymentState;
    private Long totalPrice;
    private Long shippingInfoId;
}
