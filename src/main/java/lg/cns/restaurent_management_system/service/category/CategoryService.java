package lg.cns.restaurent_management_system.service.category;

import lg.cns.restaurent_management_system.dto.categoryDTO.GetAllCategoryDTO;
import lg.cns.restaurent_management_system.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {

    List<GetAllCategoryDTO> getAllCategoryDtoList();
}
