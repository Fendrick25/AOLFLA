package com.fla.aol.inventorysystem.service.impl;

import com.fla.aol.inventorysystem.entity.ProductDetail;
import com.fla.aol.inventorysystem.exception.ResourceNotFoundException;
import com.fla.aol.inventorysystem.dto.request.*;
import com.fla.aol.inventorysystem.dto.response.*;
import com.fla.aol.inventorysystem.entity.Product;
import com.fla.aol.inventorysystem.mapper.ProductDataMapper;
import com.fla.aol.inventorysystem.repository.ProductJpaRepository;
import com.fla.aol.inventorysystem.service.ProductService;
import com.fla.aol.inventorysystem.valueobject.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJpaRepository;
    private final ProductDataMapper productDataMapper;
    private final ApplicationContext applicationContext;

    @Override
    public CreateProductResponse createProduct(CreateProduct createProduct) {
        Product product = createProductByType(createProduct.getType());
        product.setName(createProduct.getName());
        product.setPrice(createProduct.getPrice());
        product.setQuantity(createProduct.getQuantity());
        product.setProductDetail(ProductDetail.builder()
                        .weight(createProduct.getProductDetail().getWeight())
                        .description(createProduct.getProductDetail().getDescription())
                        .product(product)
                .build());
        return productDataMapper.productToCreateProductResponse(productJpaRepository.save(product));
    }

    @Override
    @Transactional
    public UpdateProductResponse updateProduct(UpdateProduct updateProduct) {
        Product product = findProduct(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setQuantity(updateProduct.getQuantity());
        return productDataMapper.productToUpdateProductResponse(product);
    }

    @Override
    @Transactional
    public UpdateProductDetailResponse updateProductDetail(UpdateProductDetail updateProductDetail) {
        Product product = findProduct(updateProductDetail.getId());
        product.getProductDetail().setDescription(updateProductDetail.getDescription());
        product.getProductDetail().setWeight(updateProductDetail.getWeight());
        return productDataMapper.productToUpdateProductDetailResponse(product);
    }

    @Override
    public GetProductResponse getProduct(Integer productID) {
        return productDataMapper.productToGetProductResponse(findProduct(productID));
    }

    @Override
    public void deleteProduct(Integer productID) {
        findProduct(productID);
        productJpaRepository.deleteById(productID);
    }

    private Product findProduct(Integer productID){
        return productJpaRepository.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    private Product createProductByType(ProductType productType){
        if(productType.equals(ProductType.BASIC_MATERIAL))
            return applicationContext.getBean("productBasicMaterial", Product.class);

        if(productType.equals(ProductType.ELECTRONICS))
            return applicationContext.getBean("productElectronics", Product.class);

        if(productType.equals(ProductType.BOOKS))
            return applicationContext.getBean("productBooks", Product.class);

        return null;
    }
}
