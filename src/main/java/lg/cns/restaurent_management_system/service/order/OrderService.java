package lg.cns.restaurent_management_system.service.order;

import lg.cns.restaurent_management_system.dto.requestObject.orderRequestObject.CreatedOrderDTO;

public interface OrderService {
    CreatedOrderDTO createOrder(CreatedOrderDTO createdOrderDTO);
}
