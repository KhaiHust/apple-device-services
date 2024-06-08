package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.ICartService;
import vn.edu.hust.project.appledeviceservice.service.IUserSecurityService;

@RestController
@RequestMapping("/web/api/v1/carts")
@RequiredArgsConstructor
public class CartWebController {

    private final IUserSecurityService userSecurityService;
    private final ICartService cartService;

    @PostMapping
    public ResponseEntity<Resource> createCart(
            @RequestBody CreateCartRequest request
    ) {
        var userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(cartService.createCart(request, userId)));
    }

}
