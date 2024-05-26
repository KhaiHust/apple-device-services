package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateProductDetailException;
import vn.edu.hust.project.appledeviceservice.exception.GetProductDetailException;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IProductDetailRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ProductDetailModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.ProductDetailSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductDetailAdapter implements IProductDetailPort {
    private final IProductDetailRepository productDetailRepository;

    @Override
    public ProductDetailEntity save(ProductDetailEntity entity) {
        try {
            return ProductDetailModelMapper.INSTANCE.toEntity(
                    productDetailRepository.save(ProductDetailModelMapper.INSTANCE.toModel(entity))
            );
        } catch (Exception ex) {
            log.error("[ProductDetailAdapter] create product detail fail, err: " + ex.getMessage());
            throw new CreateProductDetailException();
        }
    }

    @Override
    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetails(GetProductDetailRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        Page<ProductDetailModel> result = productDetailRepository.findAll(new ProductDetailSpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, ProductDetailModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public ProductDetailEntity getProductDetail(Long id) {
        return ProductDetailModelMapper.INSTANCE.toEntity(
                productDetailRepository.findById(
                        id
                ).orElseThrow(GetProductDetailException::new)
        );
    }
}
