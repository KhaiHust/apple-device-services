package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IProductService;

@RestController
@RequestMapping("/ops/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<Resource> createProduct(
            @RequestBody CreateProductRequest request
    ) {
        return ResponseEntity.ok(
                new Resource(productService.createProduct(request))
        );
    }

    @GetMapping
    public ResponseEntity<Resource> getAll(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {

        var filter = new GetProductRequest();
        filter.setName(name);
        filter.setPage(page);
        filter.setPageSize(pageSize);

        var result = productService.getAllProducts(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);

    }
}
