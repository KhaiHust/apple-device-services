package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.exception.ApplicationException;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IColorRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ColorModelMapper;

@Service
@RequiredArgsConstructor
public class ColorAdapter implements IColorPort {

    private final IColorRepository colorRepository;

    @Override
    public ColorEntity save(ColorEntity colorEntity) {
//        try {
            var colorModel = colorRepository.save(ColorModelMapper.INSTANCE.toModel(colorEntity));

            return ColorModelMapper.INSTANCE.toEntity(colorModel);
//        }
//        catch (Exception ex){
//            throw new ApplicationException(ex.getMessage());
//        }

    }
}
