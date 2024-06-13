package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderModel;

import java.time.Instant;
import java.util.List;
import vn.edu.hust.project.appledeviceservice.utils.RandomStringUtils;

@Mapper
public abstract class OrderModelMapper {
    public static final OrderModelMapper INSTANCE = Mappers.getMapper(OrderModelMapper.class);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)

    public abstract OrderModel toModel(OrderEntity entity);

    @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "toUnixDate")
    @Mapping(target = "updatedAt", source = "updatedAt", qualifiedByName = "toUnixDate")
    @Mapping(target = "code", source = "code", qualifiedByName = "createOrderCode")
    public abstract OrderEntity toEntity(OrderModel model);

    public abstract List<OrderEntity> toEntities(List<OrderModel> models);

    @Named("toUnixDate")
    public Long toUnixDate(Instant time) {
        return time.toEpochMilli() / 1000;
    }

    @Named("createOrderCode")
    public String createOrderCode(String code){
        if(StringUtils.hasLength(code)){
            return code;
        }
        return RandomStringUtils.generateRandomString();
    }
}
