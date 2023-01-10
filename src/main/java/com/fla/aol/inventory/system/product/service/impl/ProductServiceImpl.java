package com.fla.aol.inventory.system.product.service.impl;

import com.fla.aol.inventory.system.order.entity.OrderItem;
import com.fla.aol.inventory.system.product.dto.request.CreateProduct;
import com.fla.aol.inventory.system.product.dto.response.CreateProductResponse;
import com.fla.aol.inventory.system.product.dto.response.GetProductResponse;
import com.fla.aol.inventory.system.product.entity.Product;
import com.fla.aol.inventory.system.product.entity.ProductDetail;
import com.fla.aol.inventory.system.product.mapper.ProductDataMapper;
import com.fla.aol.inventory.system.product.repository.ProductRepository;
import com.fla.aol.inventory.system.product.service.ProductService;
import com.fla.aol.inventory.system.product.valueobject.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDataMapper productDataMapper;
    private final ApplicationContext applicationContext;

    @Override
    public CreateProductResponse createProduct(CreateProduct createProduct) {
        Product product = createProductByType(createProduct.getType());
        product.setName(createProduct.getName());
        product.setPrice(createProduct.getPrice());
        product.setQuantity(createProduct.getQuantity());
        product.setProductDetail(ProductDetail.builder()
                .weight(createProduct.getProductDetail().getWeight())
                .description(createProduct.getProductDetail().getDescription())
                .product(product)
                .build());

        Product savedProduct = productRepository.saveProduct(product);
        return productDataMapper.productToCreateProductResponse(savedProduct);
    }

    @Override
    public void reduceProductStock(List<OrderItem> orderItems) {
        List<Product> updatedProducts = orderItems.stream().map(orderItem -> {
            Product product = productRepository.findProduct(orderItem.getProduct().getId());
            product.setQuantity(product.getQuantity() - orderItem.getQuantity());
            return product;
        }).toList();

        productRepository.saveProducts(updatedProducts);
    }

    @Override
    public void rollbackProductStock(List<OrderItem> orderItems) {
        List<Product> updatedProducts = orderItems.stream().map(orderItem -> {
            Product product = productRepository.findProduct(orderItem.getProduct().getId());
            product.setQuantity(product.getQuantity() + orderItem.getQuantity());
            return product;
        }).toList();

        productRepository.saveProducts(updatedProducts);
    }

    @Override
    public GetProductResponse getProduct(Integer productID) {
        return productDataMapper.productToGetProductResponse(productRepository.findProduct(productID));
    }

    @Override
    public void deleteProduct(Integer productID) {
        productRepository.deleteProduct(productID);
    }

    private Product createProductByType(ProductType productType) {
        if (productType.equals(ProductType.BASIC_MATERIAL))
            return applicationContext.getBean("productBasicMaterial", Product.class);

        if (productType.equals(ProductType.ELECTRONICS))
            return applicationContext.getBean("productElectronics", Product.class);

        if (productType.equals(ProductType.BOOKS))
            return applicationContext.getBean("productBooks", Product.class);

        return null;
    }
}
