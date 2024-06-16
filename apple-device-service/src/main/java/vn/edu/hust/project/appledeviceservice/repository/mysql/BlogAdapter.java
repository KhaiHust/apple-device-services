package vn.edu.hust.project.appledeviceservice.repository.mysql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateBlogException;
import vn.edu.hust.project.appledeviceservice.port.IBlogPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.BlogModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogAdapter implements IBlogPort {
    private final IBlogRepository blogRepository;


    @Override
    public BlogEntity save(BlogEntity entity) {
        try {
            var savedModel = blogRepository.save(BlogModelMapper.INSTANCE.toModel(entity));
            return BlogModelMapper.INSTANCE.toEntity(savedModel);
        } catch (Exception e) {
            log.error("[BlogAdapter] Create blog fail, err: " + e.getMessage());
            throw new CreateBlogException();
        }

    }
}
