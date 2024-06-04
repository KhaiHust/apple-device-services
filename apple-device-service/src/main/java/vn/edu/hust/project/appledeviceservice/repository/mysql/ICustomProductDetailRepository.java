package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.data.domain.Page;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

public interface ICustomProductDetailRepository {
    Page<ProductDetailModel> getAllProductDetails(
            GetProductDetailRequestWeb filter
    );
}
