package lg.cns.restaurent_management_system.controller;

import lg.cns.restaurent_management_system.response.baseResponse.BaseResponse;
import lg.cns.restaurent_management_system.dto.categoryDTO.GetAllCategoryDTO;
import lg.cns.restaurent_management_system.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category-list")
    public ResponseEntity<Object> getAllCategory(){
        List<GetAllCategoryDTO> categoryDTOList = categoryService.getAllCategoryDtoList();
        return new ResponseEntity<>(new BaseResponse<>("OK", 200, categoryDTOList), HttpStatus.OK);
    }
}
