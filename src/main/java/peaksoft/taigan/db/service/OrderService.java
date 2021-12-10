package peaksoft.taigan.db.service;

import peaksoft.taigan.db.domain.dto.OrderView;
import peaksoft.taigan.db.domain.model.Order;
import peaksoft.taigan.db.domain.object.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse getAllOrders(Integer page, Integer size);
    List<Order> getAllOrdersClients(Long id);
    List<Order> getAllOrdersDrivers(Long id);
    OrderView getOrderById(Long id);
    Order get(String name,Long id);

}
