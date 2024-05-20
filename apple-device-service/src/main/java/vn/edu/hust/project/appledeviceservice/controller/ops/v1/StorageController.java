package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.mapper.StorageResourceMapper;
import vn.edu.hust.project.appledeviceservice.service.IStorageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ops/api/v1/storages")
public class StorageController {
    private final IStorageService storageService;

    @PostMapping
    public ResponseEntity<Resource> createStorage(
            @RequestBody CreateStorageRequest createStorageRequest
            ){
        return ResponseEntity.ok(
                new Resource(storageService.
                        createStorage(StorageResourceMapper.INSTANCE.toStorageEntityFromRequest(createStorageRequest)))
        );
    }
}
