package lg.cns.restaurent_management_system.dto.productDTO;

import lombok.Data;

@Data

public class GetAllProductByCategoryDTO {
    private String productName;

    private String description;

    private Double price;

    private String image;

    private String categoryName;
}
