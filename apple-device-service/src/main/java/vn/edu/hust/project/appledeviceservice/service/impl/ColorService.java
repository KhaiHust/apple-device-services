package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.service.IColorService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateColorUseCase;

@Service
@RequiredArgsConstructor
public class ColorService implements IColorService {

    private final CreateColorUseCase createColorUseCase;
    @Override
    @Transactional
    public ColorEntity createColorEntity(ColorEntity colorEntity) {
        return createColorUseCase.createColor(colorEntity);
    }
}
