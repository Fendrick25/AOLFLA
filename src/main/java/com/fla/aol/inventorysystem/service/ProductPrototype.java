package com.fla.aol.inventorysystem.service;

import com.fla.aol.inventorysystem.entity.Product;
import com.fla.aol.inventorysystem.valueobject.ProductLocation;
import com.fla.aol.inventorysystem.valueobject.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
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
