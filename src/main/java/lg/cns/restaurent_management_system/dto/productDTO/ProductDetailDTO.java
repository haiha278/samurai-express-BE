package lg.cns.restaurent_management_system.dto.productDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDetailDTO {
    private Integer productId;
    private String productName;

    private String description;

    private Double price;

    private String image;
}
