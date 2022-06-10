package edu.sdp.ntcc.i2.service;

import edu.sdp.ntcc.i2.model.Payments;
import edu.sdp.ntcc.i2.payload.PaymentPayload;
import edu.sdp.ntcc.i2.repository.PaymentDetailsProxyRepository;
import edu.sdp.ntcc.i2.service.payment.CardPayment;
import edu.sdp.ntcc.i2.service.payment.NetBankingPayment;
import edu.sdp.ntcc.i2.service.payment.Payment;
import edu.sdp.ntcc.i2.service.payment.WalletPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentDetailsProxyRepository paymentDetailsProxyRepository;

    public Object fetchEventAmount(int eventId) {
        Optional<Payments> paymentAmount = paymentDetailsProxyRepository.getPaymentsByEventId(eventId);
        return paymentAmount.map(Payments::getAmount).orElse(null);
    }

    public Payments fetchPaymentDetails(int eventId) {
        return paymentDetailsProxyRepository.getPaymentsByEventId(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Payment Details Not Found"));
    }

    public void savePaymentDetails(Payments payments) {
        paymentDetailsProxyRepository.save(payments);
    }

    public void processPayment(PaymentPayload paymentPayload){

        Payment payment;

        switch (paymentPayload.getPaymentType()){
            case "card":
                payment = new CardPayment();
                break;
            case "net banking":
                payment = new NetBankingPayment();
                break;
            case "wallet":
                payment = new WalletPayment();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + paymentPayload.getPaymentType());
        }

        payment.process();
        savePaymentDetails(new Payments(paymentPayload.getUserId(), paymentPayload.getEventId(),
                paymentPayload.getPaymentType(), paymentPayload.getAmount()));
    }
}
