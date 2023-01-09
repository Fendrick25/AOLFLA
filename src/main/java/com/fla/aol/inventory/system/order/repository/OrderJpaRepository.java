package com.fla.aol.inventory.system.order.repository;

import com.fla.aol.inventory.system.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {

}
