package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;

@Mapper
public abstract class ProductDetailResourceMapper {
    public static final ProductDetailResourceMapper INSTANCE = Mappers.getMapper(ProductDetailResourceMapper.class);

    @Mapping(target = "images", ignore = true)
    public abstract ProductDetailEntity toEntityFromRequest(CreateProductDetailRequest request);
}
