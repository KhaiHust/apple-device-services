package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductUseCase {
    private final IProductPort productPort;

    public Pair<PageInfo, List<ProductEntity>> getAllProducts(GetProductRequest filter) {
        return productPort.getAllProducts(filter);
    }
}
