package lg.cns.restaurent_management_system.service.order;

import lg.cns.restaurent_management_system.dto.requestObject.orderRequestObject.CreatedOrderDTO;
import lg.cns.restaurent_management_system.entity.Order;
import lg.cns.restaurent_management_system.exception.ResourceIsNotCreatedException;
import lg.cns.restaurent_management_system.mapper.Mapper;
import lg.cns.restaurent_management_system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public CreatedOrderDTO createOrder(CreatedOrderDTO createdOrderDTO) {
        Order order = Mapper.mapDtoToEntity(createdOrderDTO, Order.class);
        order.setOrderDate(LocalDateTime.now());
        CreatedOrderDTO createdOrder = Mapper.mapEntityToDto(orderRepository.saveAndFlush(order), CreatedOrderDTO.class);
        if (createdOrder != null) {
            return createdOrder;
        } else {
            throw new ResourceIsNotCreatedException("Order is not created");
        }
    }
}
