package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderApiController {
    private final OrderRepository orderRepository;

    @GetMapping("api/v1/orders")
    public List<Order> orderV1(){
        List<Order> list = orderRepository.findAllByString(new OrderSearch());
        for(Order or : list){
            or.getMember().getName();
            or.getDelivery().getAddress();
            List<OrderItem> orderItems = or.getOrderItems();
            orderItems.stream().forEach(o->o.getItem().getName());
        }
        return list;
    }
}
