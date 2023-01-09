package com.fla.aol.inventory.system.product.entity;

import com.fla.aol.inventory.system.product.valueobject.ProductLocation;
import com.fla.aol.inventory.system.product.valueobject.ProductType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private BigDecimal price;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductDetail productDetail;

    @Enumerated(EnumType.STRING)
    private ProductLocation location;
}
