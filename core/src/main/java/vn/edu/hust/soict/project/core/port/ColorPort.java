package vn.edu.hust.soict.project.core.port;

import org.springframework.stereotype.Service;
import vn.edu.hust.soict.project.core.entity.ColorEntity;

@Service
public interface ColorPort {
    void save(ColorEntity colorEntity);
}
