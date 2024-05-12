package vn.edu.hust.project.appledeviceservice.usecase;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateColorException;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;

@Service
@RequiredArgsConstructor
public class CreateColorUseCase {
    private final IColorPort colorPort;

    @Transactional(rollbackOn = CreateColorException.class)
    public ColorEntity createColor(ColorEntity color){
        return colorPort.save(color);

    }
}
