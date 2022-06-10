package edu.sdp.ntcc.i2.controller;

import edu.sdp.ntcc.i2.payload.UserPayload;
import edu.sdp.ntcc.i2.model.User;
import edu.sdp.ntcc.i2.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/")
    public String home(){
        System.out.println(userDetailService.getUserDetails());
        return "home";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user", new UserPayload());
        return "signup";
    }

    @PostMapping("/signupsubmission")
    public String signUpSubmission(@ModelAttribute("user") UserPayload user) {
        userDetailService.saveUserDetails(new User(user.getName(), user.getPassword(), user.getEmail(), user.getRole()));
        return "login";
    }

}
