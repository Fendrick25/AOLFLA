package com.fla.aol.inventorysystem.repository;

import com.fla.aol.inventorysystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {

}
