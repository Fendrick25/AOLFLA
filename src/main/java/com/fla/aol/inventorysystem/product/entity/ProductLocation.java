package com.fla.aol.inventorysystem.product.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity(name = "product_location")
public class ProductLocation {

    @Id
    @Column(name = "product_id")
    private Integer id;

    private Integer warehouseID;
    private Integer section;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLocation that = (ProductLocation) o;
        return id.equals(that.id) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product);
    }
}
