package lg.cns.restaurent_management_system.controller;

import lg.cns.restaurent_management_system.dto.BaseResponse.BaseResponse;
import lg.cns.restaurent_management_system.dto.categoryDTO.GetAllCategoryDTO;
import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.exception.ResourceNotFoundException;
import lg.cns.restaurent_management_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new BaseResponse<>(e.getMessage(), 404), HttpStatus.NOT_FOUND);
    }
    @GetMapping("/category-list")
    public ResponseEntity<Object> getAllCategory(){
        List<GetAllCategoryDTO> categoryDTOList = categoryService.getAllCategoryDtoList();
        return new ResponseEntity<>(new BaseResponse<>("OK", 200, categoryDTOList), HttpStatus.OK);
    }
}
