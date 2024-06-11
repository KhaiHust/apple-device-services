package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ShippingInfoModel;

@Mapper
public abstract class ShippingInfoModelMapper {
    public static final ShippingInfoModelMapper INSTANCE = Mappers.getMapper(ShippingInfoModelMapper.class);

    public abstract ShippingInfoModel toModel(ShippingInfoEntity entity);

    public abstract ShippingInfoEntity toEntity(ShippingInfoModel model);
}
