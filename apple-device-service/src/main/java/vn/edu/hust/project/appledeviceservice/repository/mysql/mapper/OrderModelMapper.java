package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderModel;

import java.time.Instant;
import java.util.List;

@Mapper
public abstract class OrderModelMapper {
    public static final OrderModelMapper INSTANCE = Mappers.getMapper(OrderModelMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract OrderModel toModel(OrderEntity entity);

    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "toUnixDate")
    @Mapping(target = "updatedAt", source = "updatedAt", qualifiedByName = "toUnixDate")
    public abstract OrderEntity toEntity(OrderModel model);

    public abstract List<OrderEntity> toEntities(List<OrderModel> models);

    @Named("toUnixDate")
    public Long toUnixDate(Instant time) {
        return time.toEpochMilli() / 1000;
    }
}
