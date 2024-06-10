package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Order Model")
@Table(name = "orders")
public class OrderModel extends BaseModel {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "code")
    private String code;

    @Column(name = "state")
    private String state;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_state")
    private String paymentState;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "shipping_info_id")
    private Long shippingInfoId;
}
