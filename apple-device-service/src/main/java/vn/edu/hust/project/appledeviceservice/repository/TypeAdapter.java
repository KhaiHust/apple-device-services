package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.port.ITypePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.ITypeRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.TypeModelMapper;

@Service
@RequiredArgsConstructor
public class TypeAdapter implements ITypePort {

    private final ITypeRepository typeRepository;


    @Override
    public TypeEntity save(TypeEntity entity) {
        return TypeModelMapper.INSTANCE.toEntity(typeRepository.save(
                TypeModelMapper.INSTANCE.toModel(entity)
        ));
    }
}
