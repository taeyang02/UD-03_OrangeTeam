package com.orange;

import com.orange.domain.model.Order;
import com.orange.repositories.IOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrangeShopBeApplicationTests {

    @Autowired
    private IOrderRepository orderRepository;

    @Test
    void contextLoads() {
        List<Order> list = orderRepository.findAll();
        list.forEach(order -> System.out.println(order.getConsigneePhone()));
    }

}
