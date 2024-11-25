package lg.cns.restaurent_management_system.service;

import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.mapper.Mapper;
import lg.cns.restaurent_management_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<GetAllProductByCategoryDTO> getAllProductByCategory(String categoryName) {
        List<GetAllProductByCategoryDTO> productList = productRepository.findAllByCategoryCategoryName(categoryName).stream().map(product -> {
            GetAllProductByCategoryDTO productDTO = Mapper.mapEntityToDto(product, GetAllProductByCategoryDTO.class);
            return productDTO;
        }).collect(Collectors.toList());
        return productList;
    }
}
