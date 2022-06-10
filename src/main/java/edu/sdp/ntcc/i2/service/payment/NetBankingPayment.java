package edu.sdp.ntcc.i2.service.payment;

public class NetBankingPayment implements Payment{
    @Override
    public void process() {
        System.out.println("Net Banking payment successfully processed.");
    }
}
