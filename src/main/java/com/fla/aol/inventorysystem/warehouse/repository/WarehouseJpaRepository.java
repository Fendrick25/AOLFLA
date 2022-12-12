package com.fla.aol.inventorysystem.warehouse.repository;

import com.fla.aol.inventorysystem.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseJpaRepository extends JpaRepository<Warehouse, Integer> {
}
