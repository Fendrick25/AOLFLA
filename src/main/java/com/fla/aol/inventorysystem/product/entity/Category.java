package com.fla.aol.inventorysystem.product.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(length = 20)
    private String id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
