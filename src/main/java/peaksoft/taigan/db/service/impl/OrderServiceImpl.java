package peaksoft.taigan.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.taigan.db.domain.dto.OrderView;
import peaksoft.taigan.db.domain.mapper.OrderViewMapper;
import peaksoft.taigan.db.domain.model.Order;
import peaksoft.taigan.db.domain.object.OrderResponse;
import peaksoft.taigan.db.repo.OrderRepo;
import peaksoft.taigan.db.service.OrderService;
import peaksoft.taigan.enums.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderViewMapper orderViewMapper;
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo, OrderViewMapper orderViewMapper) {
        this.orderRepo = orderRepo;
        this.orderViewMapper = orderViewMapper;
    }


    @Override
    public Order get(String code, Long id) {
        Optional<Order> optionalOrder = orderRepo.findByCodeword(code);
        if (optionalOrder.isEmpty()) {
            Order order = orderRepo.findById(id).get();
            order.setCodeword(code);
            order.setState(State.BOOKED);
            orderRepo.save(order);
            return order;
        } else {
            Order order = optionalOrder.get();

            switch (optionalOrder.get().getState()) {
                case BOOKED:
                    order.setState(State.PICKED_UP);
                    break;
                case PICKED_UP:
                    order.setState(State.ON_ROUTE);
                    break;
                case ON_ROUTE:
                    order.setState(State.REGION_WAREHOUSE);
                    break;
                case REGION_WAREHOUSE:
                    order.setState(State.PICKED_UP_REGION);
                    break;
                case PICKED_UP_REGION:
                    order.setState(State.DELIVERED);
                    break;
                case DELIVERED:

                    break;
            }
            orderRepo.save(order);
            return order;
/**PICKED_UP,
 BISHKEK_WAREHOUSE,
 ON_ROUTE,
 REGION_WAREHOUSE,
 PICKED_UP_REGION,
 DELIVERED
 */
        }
    }


    @Override
    public OrderResponse getAllOrders(Integer page, Integer size) {

        OrderResponse orderResponse = new OrderResponse();
        long total = 0;
        List<OrderView> orderViews = orderViewMapper.toOrderView(orderRepo.findAll());
        total = orderViews.size();
        List<OrderView> orderViews1 = new ArrayList<>();
        for (int i = size * (page - 1); i < size * page; i++) {
            orderViews1.add(orderViews.get(i));
        }
        orderResponse.setOrders(orderViews1);
        orderResponse.setTotal(total);

        return orderResponse;
    }


    @Override
    public List<Order> getAllOrdersClients(Long id) {
        return orderRepo.findOrdersByClient(id);
    }

    @Override
    public List<Order> getAllOrdersDrivers(Long id) {
        return orderRepo.findOrdersByDriver(id);
    }

    @Override
    public OrderView getOrderById(Long id) {
        return orderViewMapper.toOrderView(orderRepo.getById(id));
    }

}
