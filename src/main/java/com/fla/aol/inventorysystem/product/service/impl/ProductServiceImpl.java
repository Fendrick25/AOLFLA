package com.fla.aol.inventorysystem.product.service.impl;

import com.fla.aol.inventorysystem.common.exception.ResourceNotFoundException;
import com.fla.aol.inventorysystem.product.dto.request.*;
import com.fla.aol.inventorysystem.product.dto.response.*;
import com.fla.aol.inventorysystem.product.entity.Category;
import com.fla.aol.inventorysystem.product.entity.Product;
import com.fla.aol.inventorysystem.product.mapper.ProductDataMapper;
import com.fla.aol.inventorysystem.product.repository.CategoryJpaRepository;
import com.fla.aol.inventorysystem.product.repository.ProductJpaRepository;
import com.fla.aol.inventorysystem.product.service.ProductService;
import com.fla.aol.inventorysystem.warehouse.entity.Warehouse;
import com.fla.aol.inventorysystem.warehouse.repository.WarehouseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


@Service
@Validated
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductJpaRepository productJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;
    private final WarehouseJpaRepository warehouseJpaRepository;
    private final ProductDataMapper productDataMapper;

    @Override
    public CreateProductResponse createProduct(CreateProduct createProduct) {
        findCategory(createProduct.getCategory());
        findWarehouse(createProduct.getLocation().getWarehouseID());
        Product product = productDataMapper.createProductToProduct(createProduct);
        product.getProductDetail().setProduct(product);
        product.getLocation().setProduct(product);
        return productDataMapper.productToCreateProductResponse(productJpaRepository.save(product));
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProduct updateProduct) {
        Product product = findProduct(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setPrice(updateProduct.getPrice());
        product.setQuantity(updateProduct.getQuantity());
        return productDataMapper.productToUpdateProductResponse(productJpaRepository.save(product));
    }

    @Override
    @Transactional
    public UpdateProductDetailResponse updateProductDetail(UpdateProductDetail updateProductDetail) {
        Product product = findProduct(updateProductDetail.getId());
        product.getProductDetail().setDescription(updateProductDetail.getDescription());
        product.getProductDetail().setWeight(updateProductDetail.getWeight());
        return productDataMapper.productToUpdateProductDetailResponse(productJpaRepository.save(product));
    }

    @Override
    public UpdateProductLocationResponse updateProductLocation(UpdateProductLocation updateProductLocation) {
        findWarehouse(updateProductLocation.getLocation().getWarehouseID());
        Product product = findProduct(updateProductLocation.getId());
        product.getLocation().setSection(updateProductLocation.getLocation().getSection());
        product.getLocation().setWarehouseID(updateProductLocation.getLocation().getWarehouseID());
        return productDataMapper.productToUpdateProductLocationResponse(productJpaRepository.save(product));
    }

    @Override
    @Transactional
    public UpdateProductCategoryResponse updateProductCategory(UpdateProductCategory updateProductCategory) {
        Category category = findCategory(updateProductCategory.getCategory());
        Product product = findProduct(updateProductCategory.getId());
        product.setCategory(category);
        return productDataMapper.productToUpdateProductCategoryResponse(productJpaRepository.save(product));
    }

    @Override
    @Transactional(readOnly = true)
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

    private Category findCategory(String category){
        return categoryJpaRepository.findById(category).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    private Warehouse findWarehouse(Integer warehouse){
        return warehouseJpaRepository.findById(warehouse).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));
    }
}
