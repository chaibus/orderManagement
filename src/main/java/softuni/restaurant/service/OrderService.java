package softuni.restaurant.service;

import softuni.restaurant.model.entity.OrderEntity;
import softuni.restaurant.model.entity.UserEntity;

import java.util.List;

public interface OrderService {
    void initializeOrders();
    List<OrderEntity> getAllOrders();

    void setNewStatus(Long id, UserEntity userEntity);

    OrderEntity findOrderById(Long id);
    void deleteOrder(OrderEntity orderEntity);

    void deleteAllOldOrders();

    void saveOrder(OrderEntity order);
}