package vn.edu.hust.soict.project.core.usecase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.soict.project.core.entity.ColorEntity;
import vn.edu.hust.soict.project.core.exception.CreateColorException;
import vn.edu.hust.soict.project.core.port.ColorPort;

@Service
@RequiredArgsConstructor
public class CreateColorUseCase {
    private final ColorPort colorPort;

    @Transactional(rollbackOn = CreateColorException.class)
    public ColorEntity createColor(ColorEntity color){
        colorPort.save(color);
        return color;
    }
}
