package lg.cns.restaurent_management_system.dto.requestObject.orderRequestObject;

import lombok.Data;

@Data
public class CreatedOrderDTO {

    private Double amount;

    private String customerName;

    private String address;

    private String phoneNumber;

    private String note;

}
