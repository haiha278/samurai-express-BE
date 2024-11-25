package lg.cns.restaurent_management_system.controller;

import lg.cns.restaurent_management_system.dto.BaseResponse.BaseResponse;
import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product-list")
    public ResponseEntity<Object> getAllProductByCategory(@RequestParam String categoryName) {
        List<GetAllProductByCategoryDTO> productList = productService.getAllProductByCategory(categoryName);
        return new ResponseEntity<>(new BaseResponse<>("OK", 200, productList), HttpStatus.OK);
    }
}
