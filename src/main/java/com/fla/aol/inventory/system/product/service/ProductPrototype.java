package com.fla.aol.inventory.system.product.service;

import com.fla.aol.inventory.system.product.entity.Product;
import com.fla.aol.inventory.system.product.valueobject.ProductLocation;
import com.fla.aol.inventory.system.product.valueobject.ProductType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProductPrototype {

    @Bean
    @Scope("prototype")
    public Product productBasicMaterial(){
        return Product.builder()
                .productType(ProductType.BASIC_MATERIAL)
                .location(ProductLocation.SECTION_100)
                .build();
    }

    @Bean
    @Scope("prototype")
    public Product productElectronics(){
        return Product.builder()
                .productType(ProductType.ELECTRONICS)
                .location(ProductLocation.SECTION_200)
                .build();
    }

    @Bean
    @Scope("prototype")
    public Product productBooks(){
        return Product.builder()
                .productType(ProductType.BOOKS)
                .location(ProductLocation.SECTION_300)
                .build();
    }
}
