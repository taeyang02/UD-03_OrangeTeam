package com.orange.services;

import com.orange.domain.dto.ProductContainProductDetailDTO;
import com.orange.domain.dto.ProductDTO;

public interface IProductService extends BaseService<ProductDTO, Long>{


    ProductContainProductDetailDTO fillOneProductContainProductDetail(Long aLong);
}

