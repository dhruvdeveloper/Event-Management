package edu.sdp.ntcc.i2.service.payment;

public class CardPayment implements Payment{
    @Override
    public void process() {
        System.out.println("Credit card payment successfully processed.");
    }
}
