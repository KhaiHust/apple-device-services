package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IProductService;

@RestController
@RequestMapping("/ops/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<Resource> createProduct(
            @RequestBody CreateProductRequest request
            ){
        return ResponseEntity.ok(
                new Resource(productService.createProduct(request))
        );
    }
}
