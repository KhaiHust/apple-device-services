package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.service.ITypeService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateTypeUseCase;

@Service
@RequiredArgsConstructor
public class TypeService implements ITypeService {

    private final CreateTypeUseCase createTypeUseCase;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TypeEntity createType(TypeEntity entity) {
        return createTypeUseCase.createType(entity);
    }
}
