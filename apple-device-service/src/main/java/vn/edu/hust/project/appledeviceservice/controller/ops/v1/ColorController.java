package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.mapper.ColorResourceMapper;
import vn.edu.hust.project.appledeviceservice.service.IColorService;

@RestController
@RequestMapping("/ops/api/v1/colors")
@RequiredArgsConstructor
public class ColorController {
    public static final String COLOR_PREFIX_API = "/ops/v1/colors";

    private final IColorService colorService;

    @PostMapping
    public ResponseEntity<Resource> createColor(
            @RequestBody CreateColorRequest request
            ){
        var color = colorService.createColorEntity(ColorResourceMapper.INSTANCE.toEntity(request));
        return ResponseEntity.ok(new Resource(color));
    }



}
