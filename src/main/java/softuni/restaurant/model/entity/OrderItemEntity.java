package softuni.restaurant.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "order_single_item_details")
public class OrderItemEntity extends BaseEntity {
    @ManyToOne
    private ItemEntity item;
    @Column(nullable = false)
    @Positive
    private Integer quantity;
    @Column(nullable = false)
    private BigDecimal itemPrice;
    private BigDecimal subtotal;

    public OrderItemEntity() {
    }

    public ItemEntity getItem() {
        return item;
    }

    public OrderItemEntity setItem(ItemEntity item) {
        this.item = item;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemEntity setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public OrderItemEntity setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
        return this;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public OrderItemEntity setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
        return this;
    }


    @PrePersist
    public void beforeCreate() {
        this.itemPrice = item.getPrice();
        this.subtotal = itemPrice.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return
                item.getName() + " x " + quantity;

    }
}
