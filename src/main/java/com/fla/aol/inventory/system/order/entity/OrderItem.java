package com.fla.aol.inventory.system.order.entity;

import com.fla.aol.inventory.system.product.entity.Product;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
    private int quantity;
    private BigDecimal subTotal;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    void initializeOrderItem(String id){
        this.id = id;
        subTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
