package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductDetailUseCase {
    private final IProductDetailPort productDetailPort;

    private final IImagePort imagePort;

    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetails(
            GetProductDetailRequest filter
    ) {
        return productDetailPort.getAllProductDetails(filter);
    }

    public ProductDetailEntity getProductDetail(Long id) {
        var productDetail = productDetailPort.getProductDetail(id);

        var images = imagePort.getImagesByEntityIdAndType(
                productDetail.getId(), ImageTypeEnum.PRODUCT_DETAIL_IMAGE.name()
        );

        productDetail.setImages(images);

        return productDetail;
    }
}
