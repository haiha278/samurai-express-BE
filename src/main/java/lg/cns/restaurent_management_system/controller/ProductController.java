package lg.cns.restaurent_management_system.controller;

import lg.cns.restaurent_management_system.dto.BaseResponse.BaseResponse;
import lg.cns.restaurent_management_system.dto.RequestObject.ProductRequestObject.ProductDetailRequestDTO;
import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.exception.ResourceNotFoundException;
import lg.cns.restaurent_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handlerResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new BaseResponse<>(e.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product-list")
    public ResponseEntity<Object> getAllProductByCategory(@RequestParam String categoryName) {
        List<GetAllProductByCategoryDTO> productList = productService.getAllProductByCategory(categoryName);
        return new ResponseEntity<>(new BaseResponse<>("OK", 200, productList), HttpStatus.OK);
    }

    @GetMapping("/product-detail")
    public ResponseEntity<Object> getProductDetailById(@RequestBody ProductDetailRequestDTO productDetailRequestDTO) {
        return new ResponseEntity<>(new BaseResponse<>("OK", 200, productService.getProductDetailByProductId(productDetailRequestDTO.getProductId())), HttpStatus.OK);
    }
}
