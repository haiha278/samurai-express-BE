package lg.cns.restaurent_management_system.service;

import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<GetAllProductByCategoryDTO> getAllProductByCategory(String categoryName);

    String uploadProductImage(MultipartFile multipartFile) throws IOException;
}
