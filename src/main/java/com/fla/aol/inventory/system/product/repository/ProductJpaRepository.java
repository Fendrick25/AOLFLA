package com.fla.aol.inventory.system.product.repository;

import com.fla.aol.inventory.system.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
