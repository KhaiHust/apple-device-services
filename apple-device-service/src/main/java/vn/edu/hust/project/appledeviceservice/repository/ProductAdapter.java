package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.ProductPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IProductRepository;

@Service
@RequiredArgsConstructor
public class ProductAdapter implements ProductPort {

    private final IProductRepository productRepository;


}
