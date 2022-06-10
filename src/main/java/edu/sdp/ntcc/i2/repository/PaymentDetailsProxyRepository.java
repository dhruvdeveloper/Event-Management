package edu.sdp.ntcc.i2.repository;

import edu.sdp.ntcc.i2.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentDetailsProxyRepository extends JpaRepository<Payments, Integer> {
    Optional<Payments> getPaymentsByEventId(int eventId);
}
