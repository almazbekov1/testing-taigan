package peaksoft.taigan.db.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "clients")
public class Client extends User {

    private String avatar;

    @OneToMany(cascade = CascadeType.ALL
            ,mappedBy = "client"
            ,fetch = FetchType.LAZY
    )
    private List<Order> orders;

    private String info;

    public void addOrderToClient(Order order){
        if (orders == null){
            orders = new ArrayList<>();
        }
        orders.add(order);
        order.setClient(this);
    }








}
