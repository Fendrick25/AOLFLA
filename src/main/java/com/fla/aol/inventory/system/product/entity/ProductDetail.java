package com.fla.aol.inventory.system.product.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_detail")
public class ProductDetail {

    @Id
    @Column(name = "product_id")
    private Integer id;

    private Double weight;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;
}
