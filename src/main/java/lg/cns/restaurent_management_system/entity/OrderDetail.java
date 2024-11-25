package lg.cns.restaurent_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderDetail")
@Data
public class OrderDetail {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order orderId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodcutId")
    private Product productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;
}