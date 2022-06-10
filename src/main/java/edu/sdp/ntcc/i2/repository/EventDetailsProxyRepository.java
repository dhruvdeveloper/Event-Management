package edu.sdp.ntcc.i2.repository;

import edu.sdp.ntcc.i2.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDetailsProxyRepository extends JpaRepository<Events, Integer> {

    Events getByEventId(Integer eventId);


}
