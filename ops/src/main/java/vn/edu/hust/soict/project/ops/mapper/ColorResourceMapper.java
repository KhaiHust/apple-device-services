package vn.edu.hust.soict.project.ops.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.soict.project.core.entity.ColorEntity;
import vn.edu.hust.soict.project.ops.resource.request.CreateColorRequest;
import vn.edu.hust.soict.project.ops.resource.response.ColorResource;

@Mapper
public abstract class ColorResourceMapper {
    public static final ColorResourceMapper INSTANCE = Mappers.getMapper(ColorResourceMapper.class);

    public abstract ColorResource toColorResource(ColorEntity entity);

    public abstract ColorEntity toEntityFromRequest(CreateColorRequest request);

}
