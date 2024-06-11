package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderLineModel;

import java.util.List;

@Mapper
public abstract class OrderLineModelMapper {
    public static final OrderLineModelMapper INSTANCE = Mappers.getMapper(OrderLineModelMapper.class);

    public abstract OrderLineModel toModel(OrderLineEntity entity);

    public abstract OrderLineEntity toEntity(OrderLineModel model);

    public abstract List<OrderLineModel> toModels(List<OrderLineEntity> entities);

    public abstract List<OrderLineEntity> toEntities(List<OrderLineModel> models);
}
