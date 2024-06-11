package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IOrderLineRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.OrderLineModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IOrderLineAdapter implements IOrderLinePort {
    private final IOrderLineRepository orderLineRepository;

    @Override
    public List<OrderLineEntity> getOrderLineByOrderIds(List<Long> orderIds) {
        return OrderLineModelMapper.INSTANCE.toEntities(orderLineRepository.findByOrderIdIn(orderIds));
    }
}
