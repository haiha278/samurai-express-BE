package lg.cns.restaurent_management_system.dto.categoryDTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GetAllCategoryDTO {
    private Integer categoryId;

    private String categoryName;
}
