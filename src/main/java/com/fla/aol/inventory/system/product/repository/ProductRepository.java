package com.fla.aol.inventory.system.product.repository;

import com.fla.aol.inventory.system.product.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product saveProduct(Product product);
    Product findProduct(Integer productID);
    void saveProducts(List<Product> products);
    void deleteProduct(Integer productID);
}
