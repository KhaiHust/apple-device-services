package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderModel;

import java.util.List;

@Mapper
public abstract class OrderModelMapper {
    public static final OrderModelMapper INSTANCE = Mappers.getMapper(OrderModelMapper.class);

    public abstract OrderModel toModel(OrderEntity entity);

    public abstract OrderEntity toEntity(OrderModel model);

    public abstract List<OrderEntity> toEntities(List<OrderModel> models);
}
