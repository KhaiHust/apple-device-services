package vn.edu.hust.soict.project.ops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.soict.project.core.entity.response.Resource;
import vn.edu.hust.soict.project.core.usecase.CreateColorUseCase;
import vn.edu.hust.soict.project.ops.mapper.ColorResourceMapper;
import vn.edu.hust.soict.project.ops.resource.request.CreateColorRequest;

@RestController
@RequestMapping("/api/v1/colors")

public class ColorController {

    @Autowired
    private CreateColorUseCase createColorUseCase;
    @PostMapping
    public ResponseEntity<Resource> createColor(
            @RequestBody CreateColorRequest request
            ){
        var result = createColorUseCase.createColor(
                ColorResourceMapper.INSTANCE.toEntityFromRequest(request));
        return ResponseEntity.ok(
                new Resource(ColorResourceMapper.INSTANCE.toColorResource(result)));
    }
}
