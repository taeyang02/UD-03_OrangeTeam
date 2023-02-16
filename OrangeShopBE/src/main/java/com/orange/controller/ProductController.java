package com.orange.controller;

import com.orange.exception.EntityIsEmptyException;
import com.orange.domain.dto.ProductContainProductDetailDTO;
import com.orange.services.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/test/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "20") int size){
        Page<?> pages = this.productService.fillAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(pages);
    }

    @GetMapping("/product-detail")
    public ResponseEntity<?> getProductById(@RequestParam(value = "id", defaultValue = "0") Optional<Long> id){
        if (!id.isPresent()){
            throw new EntityIsEmptyException("Id is empty!");
        }
        ProductContainProductDetailDTO result = this.productService.fillOneProductContainProductDetail(id.get());
        return ResponseEntity.ok().body(result);
    }
}
