package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.dto.request.CreateTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.response.Resource;
import vn.edu.hust.project.appledeviceservice.mapper.TypeResourceMapper;
import vn.edu.hust.project.appledeviceservice.service.ITypeService;

@RestController
@RequestMapping("/ops/api/v1/types")
@RequiredArgsConstructor
public class TypeController {

    private final ITypeService typeService;

    @PostMapping
    public ResponseEntity<Resource> createType(
            @RequestBody CreateTypeRequest request
            ){
        return ResponseEntity.ok(
                new Resource(typeService.createType(TypeResourceMapper.INSTANCE.fromRequest(request)))
        );
    }
}
