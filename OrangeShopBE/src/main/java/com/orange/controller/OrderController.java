package com.orange.controller;

import com.orange.exception.EntityIsEmptyException;
import com.orange.payload.request.PaginationOption;
import com.orange.payload.response.OrderDTO;
import com.orange.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllOrders(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "20") int size){
        Page<?> pages = this.orderService.getAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(pages);
    }

    @GetMapping("/order-detail")
    public ResponseEntity<?> getOrderById(@RequestParam(value = "id", defaultValue = "0") Optional<Long> id){
        if (!id.isPresent()){
            throw new EntityIsEmptyException("Id is empty!");
        }
        OrderDTO orderDTO = this.orderService.fillOne(id.get());
        return ResponseEntity.ok().body(orderDTO);
    }
}
