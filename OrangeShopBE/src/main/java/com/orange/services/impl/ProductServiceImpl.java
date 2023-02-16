package com.orange.services.impl;

import com.orange.domain.model.Product;
import com.orange.exception.EntityNotFoundException;
import com.orange.domain.mapper.IProductDetailMapper;
import com.orange.domain.mapper.IProductMapper;
import com.orange.domain.dto.ProductContainProductDetailDTO;
import com.orange.domain.dto.ProductDTO;
import com.orange.domain.dto.ProductDetailDTO;
import com.orange.repositories.IProductRepository;
import com.orange.services.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IProductMapper productMapper;
    private final IProductDetailMapper productDetailMapper;

    public ProductServiceImpl(IProductRepository productRepository, IProductMapper productMapper, IProductDetailMapper productDetailMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productDetailMapper = productDetailMapper;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product product = this.productMapper.toEntity(dto);

        return null;
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        return null;
    }

    @Override
    public ProductDTO delete(ProductDTO dto) {
        return null;
    }

    @Override
    public Page<ProductDTO> fillAll(Pageable pageable) {
        Page<Product> result = this.productRepository.findAll(pageable);
        int totalPages = result.getTotalPages();
        List<Product> productList = result.toList();
        List<ProductDTO> productDTOList = productMapper.toDtoList(productList);
        Page<ProductDTO> productDTOPage = new PageImpl<>(productDTOList, pageable, totalPages);
        return productDTOPage;
    }

    @Override
    public ProductDTO fillById(Long id) {
        Product product = this.productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new EntityNotFoundException("Product not found!");
        }
        return productMapper.toDto(product);
    }

    public ProductContainProductDetailDTO fillOneProductContainProductDetail(Long id) {
        Product product = this.productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new EntityNotFoundException("Product not found!");
        }
        Set<ProductDetailDTO> productDetailDTOSet = productDetailMapper.toDtoSet(product.getProductDetails());
        ProductContainProductDetailDTO productContainProductDetailDTO = new ProductContainProductDetailDTO();
        productContainProductDetailDTO.setProduct(this.productMapper.toDto(product));
        productContainProductDetailDTO.setProductDetails(productDetailDTOSet);
        return productContainProductDetailDTO;
    }
}
