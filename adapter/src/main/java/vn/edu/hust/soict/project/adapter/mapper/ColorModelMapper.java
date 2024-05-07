package vn.edu.hust.soict.project.adapter.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.soict.project.adapter.repository.mysql.model.ColorModel;
import vn.edu.hust.soict.project.core.entity.ColorEntity;

import java.util.List;

@Mapper
public abstract class ColorModelMapper {
    public static final ColorModelMapper INSTANCE = Mappers.getMapper(ColorModelMapper.class);

    public abstract ColorModel toModel(ColorEntity entity);

    public abstract ColorEntity toEntity(ColorModel model);

    public abstract List<ColorModel> toModels(List<ColorEntity> entities);

    public abstract List<ColorEntity> toEntities(List<ColorModel> models);
}
