package vn.edu.hust.soict.project.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.soict.project.adapter.mapper.ColorModelMapper;
import vn.edu.hust.soict.project.adapter.repository.mysql.ColorRepository;
import vn.edu.hust.soict.project.core.entity.ColorEntity;
import vn.edu.hust.soict.project.core.port.ColorPort;

@Service
@RequiredArgsConstructor
public class ColorAdapter implements ColorPort {
    private final ColorRepository colorRepository;

    @Override
    public void save(ColorEntity colorEntity) {
        colorRepository.save(ColorModelMapper.INSTANCE.toModel(colorEntity));
    }
}
