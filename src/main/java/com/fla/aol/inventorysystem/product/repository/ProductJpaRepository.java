package com.fla.aol.inventorysystem.product.repository;

import com.fla.aol.inventorysystem.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
