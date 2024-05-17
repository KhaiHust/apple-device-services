package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateColorException;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IColorRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ColorModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ColorAdapter implements IColorPort {

    private final IColorRepository colorRepository;

    @Override
    public ColorEntity save(ColorEntity colorEntity) {
        try {
            var colorModel = colorRepository.save(ColorModelMapper.INSTANCE.toModel(colorEntity));

            return ColorModelMapper.INSTANCE.toEntity(colorModel);
        } catch (Exception ex) {
            log.error("[ColorAdapter] Create color fail, err: " + ex.getMessage());
            throw new CreateColorException();
        }

    }
}
