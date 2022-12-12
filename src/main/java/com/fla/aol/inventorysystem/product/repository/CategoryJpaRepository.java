package com.fla.aol.inventorysystem.product.repository;

import com.fla.aol.inventorysystem.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, String> {
}
