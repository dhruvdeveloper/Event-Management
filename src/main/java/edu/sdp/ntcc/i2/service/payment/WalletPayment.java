package edu.sdp.ntcc.i2.service.payment;

public class WalletPayment implements Payment{
    @Override
    public void process() {
        System.out.println("Wallet payment successfully processed.");
    }
}
