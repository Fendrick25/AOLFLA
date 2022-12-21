package com.fla.aol.inventorysystem.entity;

import com.fla.aol.inventorysystem.valueobject.OrderStatus;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Order {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID orderID;
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private OrderAddress orderAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> items;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private OrderDetail orderDetail;
    public void initializeOrder(){
        orderID = UUID.randomUUID();
        orderDetail.setPurchaseDate(ZonedDateTime.now(ZoneId.of("UTC")));
        orderStatus = OrderStatus.WAITING_FOR_PAYMENT;
        initializeOrderItems();
    }

    private void initializeOrderItems(){
        int num = 1;
        total = BigDecimal.valueOf(0.0);
        for(OrderItem orderItem : items){
            orderItem.setOrder(Order.builder()
                            .orderID(orderID)
                    .build());
            orderItem.initializeOrderItem(orderID.toString().concat(Integer.toString(num++)));
            total = total.add(orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        }

    }


}
