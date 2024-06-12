package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;

public interface IShippingInfoPort {
    ShippingInfoEntity save(ShippingInfoEntity shippingInfoEntity);

    ShippingInfoEntity getInfoByUserIdAndId(Long userId, Long id);
}
