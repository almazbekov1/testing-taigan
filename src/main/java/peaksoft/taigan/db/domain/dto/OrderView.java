package peaksoft.taigan.db.domain.dto;

import lombok.Data;

@Data
public class OrderView {

    private Long id;
    private String orderTo;
    private String orderFrom;
    private String comment;
    private String direction;
    private String state;

}
