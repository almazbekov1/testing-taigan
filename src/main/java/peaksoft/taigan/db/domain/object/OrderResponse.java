package peaksoft.taigan.db.domain.object;

import lombok.Data;
import peaksoft.taigan.db.domain.dto.OrderView;

import java.util.List;

@Data
public class OrderResponse {

    private List<OrderView> orders;
    private Long total;
}
