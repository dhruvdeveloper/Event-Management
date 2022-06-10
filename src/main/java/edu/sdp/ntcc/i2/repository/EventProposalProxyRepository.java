package edu.sdp.ntcc.i2.repository;

import edu.sdp.ntcc.i2.model.EventProposal;
import edu.sdp.ntcc.i2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventProposalProxyRepository extends JpaRepository<EventProposal, Integer> {


}
