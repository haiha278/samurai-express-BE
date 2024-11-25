package lg.cns.restaurent_management_system.service;

import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;

import java.util.List;

public interface ProductService {
    List<GetAllProductByCategoryDTO> getAllProductByCategory(String categoryName);
}
