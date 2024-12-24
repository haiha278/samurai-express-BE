package lg.cns.restaurent_management_system.service;

import lg.cns.restaurent_management_system.dto.categoryDTO.GetAllCategoryDTO;
import lg.cns.restaurent_management_system.entity.Category;
import lg.cns.restaurent_management_system.exception.ResourceNotFoundException;
import lg.cns.restaurent_management_system.mapper.Mapper;
import lg.cns.restaurent_management_system.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<GetAllCategoryDTO> getAllCategoryDtoList() {
        List<Category> categoryList = categoryRepository.findAllCategory();
        if (categoryList == null){
            throw new ResourceNotFoundException("Can not found any category");
        }
        List<GetAllCategoryDTO> categoryDTOList = categoryList.stream().map(category -> {
            GetAllCategoryDTO categoryDTO = Mapper.mapEntityToDto(category, GetAllCategoryDTO.class);
            return categoryDTO;
        }).collect(Collectors.toList());
        return categoryDTOList;
    }
}
