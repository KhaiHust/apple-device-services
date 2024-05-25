package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IInventoryService;

@RestController
@RequestMapping("/ops/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final IInventoryService inventoryService;

    @PostMapping
    ResponseEntity<Resource> createInventory(
            @RequestBody CreateInventoryRequest request
    ) {
        return ResponseEntity.ok(new Resource(
                inventoryService.createInventory(request)
        ));
    }
}
