package com.orange.controller;

import com.orange.domain.model.Order;
import com.orange.payload.request.PaginationOption;
import com.orange.services.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllOrder(PaginationOption paginationOption){
        List<?> list = this.orderService.getAll(
                PageRequest.of(paginationOption.getPageNumber(),
                        paginationOption.getPageSize(),
                        paginationOption.getSort()));
        return ResponseEntity.ok().body(list);
    }
}
