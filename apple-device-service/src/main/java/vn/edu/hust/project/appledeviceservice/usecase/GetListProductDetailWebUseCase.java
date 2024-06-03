package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;

@Service
@RequiredArgsConstructor
public class GetListProductDetailWebUseCase {
    private final IProductPort productPort;
    private final IProductDetailPort productDetailPort;


}
