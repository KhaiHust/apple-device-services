package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetListProductDetailWebUseCase {
    private final IProductPort productPort;
    private final IProductDetailPort productDetailPort;

    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetailsWeb(
            GetProductDetailRequestWeb filter
    ) {
        return productDetailPort.getAllProductDetailsWeb(filter);
    }
}
