package com.orange.controller;

import com.orange.exception.EntityIsEmptyException;
import com.orange.domain.dto.OrderDTO;
import com.orange.services.IOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/test/order")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllOrders(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "20") int size){
        Page<?> pages = this.orderService.fillAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(pages);
    }

    @GetMapping("/order-detail")
    public ResponseEntity<?> getOrderById(@RequestParam(value = "id", defaultValue = "0") Optional<Long> id){
        if (!id.isPresent()){
            throw new EntityIsEmptyException("Id is empty!");
        }
        OrderDTO orderDTO = this.orderService.fillById(id.get());
        return ResponseEntity.ok().body(orderDTO);
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
        OrderDTO result = this.orderService.create(orderDTO);
        return ResponseEntity.ok().body(result);
    }
}
