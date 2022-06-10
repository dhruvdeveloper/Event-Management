package edu.sdp.ntcc.i2.repository;

import edu.sdp.ntcc.i2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsProxyRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByEmail(String emailId);
}
