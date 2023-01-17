package com.fla.aol.inventory.system.product.repository.impl;

import com.fla.aol.inventory.system.common.exception.ResourceNotFoundException;
import com.fla.aol.inventory.system.product.entity.Product;
import com.fla.aol.inventory.system.product.repository.ProductJpaRepository;
import com.fla.aol.inventory.system.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product saveProduct(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public Product findProduct(Integer productId) {
        return productJpaRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public void saveProducts(List<Product> products) {
        productJpaRepository.saveAll(products);
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = findProduct(productId);
        productJpaRepository.delete(product);
    }
}
