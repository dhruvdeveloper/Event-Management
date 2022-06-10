package edu.sdp.ntcc.i2.payload;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPayload {

    private Integer id;
    private Integer userId;
    private Integer eventId;
    private String paymentType;
    private Integer amount;



}
