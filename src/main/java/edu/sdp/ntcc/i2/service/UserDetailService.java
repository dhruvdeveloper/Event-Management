package edu.sdp.ntcc.i2.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import edu.sdp.ntcc.i2.model.User;
import edu.sdp.ntcc.i2.repository.UserDetailsProxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService {

    @Autowired
    private UserDetailsProxyRepository userDetailsProxyRepository;

    public List<User> getUserDetails(){
        return userDetailsProxyRepository.findAll();
    }

    public Boolean validateCredentials(User user) {

        Optional<User> fromDB = userDetailsProxyRepository.getUserByEmail(user.getEmail());

        if(fromDB.isPresent()){
            if(user.getEmail().equalsIgnoreCase(fromDB.get().getEmail())
                    && user.getPassword().equals(fromDB.get().getPassword())){
                return true;
            }
        }
        return false;
    }

    public void saveUserDetails(User user) {
        userDetailsProxyRepository.save(user);
    }
}
