package com.fla.aol.inventory.system.order.entity;

import com.fla.aol.inventory.system.order.valueobject.OrderAddress;
import com.fla.aol.inventory.system.order.valueobject.OrderStatus;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
    private UUID id;
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
        id = UUID.randomUUID();
        orderDetail.setPurchaseDate(ZonedDateTime.now(ZoneId.of("UTC")));
        orderStatus = OrderStatus.WAITING_FOR_PAYMENT;
        initializeOrderItems();
    }

    public List<String> payOrder(BigDecimal amount){
        List<String> failureMessages = new ArrayList<>();
        if(!(orderStatus.equals(OrderStatus.WAITING_FOR_PAYMENT)))
            failureMessages.add("Order not in valid state for pay order");
        if(!(total.equals(amount)))
            failureMessages.add("Payment total: " + amount + " does not match order total: " + total);

        if(failureMessages.isEmpty())
            orderStatus = OrderStatus.PAID;

        return failureMessages;
    }

    public List<String> cancelOrder(){
        List<String> failureMessages = new ArrayList<>();
        if(!orderStatus.equals(OrderStatus.WAITING_FOR_PAYMENT))
            failureMessages.add("Order not in valid state for cancel order");

        if(failureMessages.isEmpty())
            orderStatus = OrderStatus.CANCELLED;

        return failureMessages;
    }

    private void initializeOrderItems(){
        int num = 1;
        total = BigDecimal.valueOf(0.0);
        for(OrderItem orderItem : items){
            orderItem.setOrder(Order.builder()
                            .id(id)
                    .build());
            orderItem.initializeOrderItem(id.toString().concat(Integer.toString(num++)));
            total = total.add(orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        }

    }



}
