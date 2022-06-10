package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.SimpleOrderQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/*
Order
Order -> Memeber
Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {
    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1(){
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        return all;
    }

    @GetMapping("api/v2/simple-orders")
    public List<SimpleOrderQueryDto.SimpleOrderDto> ordersV2(){
        return orderRepository.findAllByString(new OrderSearch()).stream()
                .map(o -> new SimpleOrderQueryDto.SimpleOrderDto(o))
                .collect(Collectors.toList());
    }

    @GetMapping("api/v3/simple-orders")
    public List<SimpleOrderQueryDto.SimpleOrderDto> ordersV3() {
        List<Order> orders = orderRepository.findAllwithMemberDelivery();

        return orders.stream()
                .map(SimpleOrderQueryDto.SimpleOrderDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("api/v4/simple-orders")
    public List<SimpleOrderQueryDto.SimpleOrderDto> ordersV4(){
        return orderRepository.findOrdersDtos();
    }

}
