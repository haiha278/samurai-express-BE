package lg.cns.restaurent_management_system.controller;

import lg.cns.restaurent_management_system.response.baseResponse.BaseResponse;
import lg.cns.restaurent_management_system.dto.requestObject.productRequestObject.ProductDetailRequestDTO;
import lg.cns.restaurent_management_system.dto.productDTO.GetAllProductByCategoryDTO;
import lg.cns.restaurent_management_system.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

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
