package shop.domain;

import java.util.*;
import lombok.*;
import shop.domain.*;
import shop.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private String phoneNumber;
    private String address;
    private String productId;
    private Integer qty;
    private String orderId;
}
