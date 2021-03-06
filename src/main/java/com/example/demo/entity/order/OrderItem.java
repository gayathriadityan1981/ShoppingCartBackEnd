package com.example.demo.entity.order;

import lombok.*;
import java.io.Serializable;
import java.util.*;
import java.math.*;
import javax.persistence.*;
import com.example.demo.entity.Product.*;
@Data
@Entity
@Table(name="order_items")
public class OrderItem{
   /* @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name="orderId",column = @Column(name="orderId")),
        @AttributeOverride(name="productId",column = @Column(name="productId"))
    })
    CompositeOrderProductKey orderItemKey;*/
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;

    private BigDecimal quantity;
    private BigDecimal unitPrice;
    private BigDecimal discount;
   // @ApiModelProperty(allowableValues = "On Order, Allocated, No Stock")
    private String orderItemStatus;
    private Date   dateAllocated;

    public OrderItem(){}

    //To Create orderitem by passing product_id and order_id as seperate variables
    public OrderItem(Product product, int productId, BigDecimal quantity, BigDecimal unitPrice, BigDecimal discount, String orderItemStatus, Date dateAllocated){
       // this(new CompositeOrderProductKey(orderId, productId), quantity, unitPrice, discount, orderItemStatus, dateAllocated);
       this(product, quantity, unitPrice, discount, orderItemStatus, dateAllocated);
    }
     //TO Create orderitem by passing Composite Key
  //   public OrderItem(CompositeOrderProductKey orderItemKey, BigDecimal quantity, BigDecimal unitPrice, BigDecimal discount, String orderItemStatus, Date dateAllocated){
    public OrderItem( Product product, BigDecimal quantity, BigDecimal unitPrice, BigDecimal discount, String orderItemStatus, Date dateAllocated){
        this.product     = product;
        this.quantity     = quantity;
        this.unitPrice    = unitPrice;
        this.discount     = discount;
        this.dateAllocated=dateAllocated;
        this.orderItemStatus =orderItemStatus;
    }
}