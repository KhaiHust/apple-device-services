package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderModel;

import java.util.ArrayList;

@RequiredArgsConstructor
public class OrderSpecification implements Specification<OrderModel> {
    private final GetOrderRequest filter;
    @Override
    public Predicate toPredicate(Root<OrderModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = new ArrayList<Predicate>();

        if(filter.getUserId() != null) {
            predicates.add(cb.equal(root.get("userId"), filter.getUserId()));
        }

        if(filter.getState() != null) {
            predicates.add(cb.equal(root.get("state"), filter.getState()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
