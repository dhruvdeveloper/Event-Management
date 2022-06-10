package edu.sdp.ntcc.i2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@Getter
@Setter
public class Payments {

    public Payments(Integer userId, Integer eventId, String paymentType, Integer amount) {
        this.userId = userId;
        this.eventId = eventId;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "amount")
    private Integer amount;

}
