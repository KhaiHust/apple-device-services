package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;
import vn.edu.hust.project.appledeviceservice.service.IBlogService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateBlogUseCase;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService {
    private final CreateBlogUseCase createBlogUseCase;

    @Override
    public BlogEntity createBlog(CreateBlogRequest request, Long userId) {
        return createBlogUseCase.createBlog(request, userId);
    }
}
