package com.fla.aol.inventorysystem.repository;

import com.fla.aol.inventorysystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
