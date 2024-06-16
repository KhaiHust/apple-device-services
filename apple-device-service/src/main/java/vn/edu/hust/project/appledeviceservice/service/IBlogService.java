package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;

public interface IBlogService {
    BlogEntity createBlog(CreateBlogRequest request, Long userId);
}
