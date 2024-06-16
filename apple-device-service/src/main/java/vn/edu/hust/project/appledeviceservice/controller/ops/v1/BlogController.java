package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IBlogService;
import vn.edu.hust.project.appledeviceservice.service.IUserSecurityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ops/api/v1/blogs")
public class BlogController {

    private final IBlogService blogService;
    private final IUserSecurityService userSecurityService;

    @PostMapping
    public ResponseEntity<Resource> createBlog(
            @RequestBody CreateBlogRequest request
            ) {
        var userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(blogService.createBlog(request, userId)));
    }
}
