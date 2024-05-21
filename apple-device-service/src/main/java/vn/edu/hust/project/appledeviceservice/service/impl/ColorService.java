package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IColorService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateColorUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetColorUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService implements IColorService {

    private final CreateColorUseCase createColorUseCase;

    private final GetColorUseCase getColorUseCase;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ColorEntity createColorEntity(ColorEntity colorEntity) {
        return createColorUseCase.createColor(colorEntity);
    }

    @Override
    public Pair<PageInfo, List<ColorEntity>> getAllColors(GetColorRequest filter) {
        return getColorUseCase.getAllColors(filter);
    }
}
