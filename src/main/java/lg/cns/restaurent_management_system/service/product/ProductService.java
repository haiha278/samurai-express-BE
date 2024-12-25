package lg.cns.restaurent_management_system.service.product;

import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.dto.productDTO.ProductDetailDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<GetAllProductByCategoryDTO> getAllProductByCategory(String categoryName);

    String uploadProductImage(MultipartFile multipartFile) throws IOException;

    ProductDetailDTO getProductDetailByProductId(Integer productId);
}
