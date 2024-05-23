package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IProductDetailService;

@RestController
@RequestMapping("/ops/api/v1/product_details")
@RequiredArgsConstructor
public class ProductDetailController {
    private final IProductDetailService productDetailService;

    @PostMapping
    public ResponseEntity<Resource> create(
            @RequestBody CreateProductDetailRequest request
            ){
        return ResponseEntity.ok(
                new Resource(productDetailService.createProductDetail(request))
        );
    }
}
