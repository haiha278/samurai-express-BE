package lg.cns.restaurent_management_system.dto.orderDetailDTO;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private Double price;
}
