package lg.cns.restaurent_management_system.controller;

import lg.cns.restaurent_management_system.dto.requestObject.orderRequestObject.CreatedOrderDTO;
import lg.cns.restaurent_management_system.response.baseResponse.BaseResponse;
import lg.cns.restaurent_management_system.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create_order")
    public ResponseEntity<Object> createOrder(@RequestBody CreatedOrderDTO createdOrderDTO) {
        CreatedOrderDTO createdOrder = orderService.createOrder(createdOrderDTO);
        return new ResponseEntity<>(new BaseResponse<>("Created Order Successfully", HttpStatus.CREATED.value(), createdOrder), HttpStatus.CREATED);
    }
}
