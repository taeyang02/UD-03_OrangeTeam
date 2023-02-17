package com.orange.repositories;

import com.orange.domain.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}