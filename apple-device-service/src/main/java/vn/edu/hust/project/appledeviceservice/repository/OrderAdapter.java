package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IOrderRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.OrderModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.OrderSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderAdapter implements IOrderPort {

    private final IOrderRepository orderRepository;

    @Override
    public Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        var result = orderRepository.findAll(new OrderSpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, OrderModelMapper.INSTANCE.toEntities(result.getContent()));
    }
}
