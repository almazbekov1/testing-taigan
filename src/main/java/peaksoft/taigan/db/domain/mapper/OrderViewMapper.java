package peaksoft.taigan.db.domain.mapper;

import org.springframework.stereotype.Component;
import peaksoft.taigan.db.domain.dto.OrderView;
import peaksoft.taigan.db.domain.model.Order;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderViewMapper {


    public OrderView toOrderView(Order order){

        if (order == null) {
            return null;
        }

        OrderView orderView = new OrderView();

        if (order.getId() != null) {
            orderView.setId(order.getId());
        }

        orderView.setId(order.getId());
        orderView.setOrderTo(order.getOrderTo());
        orderView.setOrderFrom(order.getOrderFrom());
        orderView.setDirection(order.getDirection().name());
        orderView.setState(order.getState().name());
        orderView.setComment(order.getComment());


        return orderView;

    }

    public List<OrderView> toOrderView(List<Order> orders){
        List<OrderView> orderViews = new ArrayList<>();
        for (Order order:orders) {
            orderViews.add(toOrderView(order));
        }
        return orderViews;
    }


}
