package edu.sdp.ntcc.i2.controller;

import edu.sdp.ntcc.i2.model.User;
import edu.sdp.ntcc.i2.payload.UserPayload;
import edu.sdp.ntcc.i2.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new UserPayload());
        return "login";
    }

    @PostMapping("/loginsubmission")
    public String loginSubmission(@ModelAttribute("user") UserPayload user) {
        if(userDetailService.validateCredentials(new User(user.getEmail(), user.getPassword()))){
            return "redirect:/events";
        }
        return "redirect:/login";
    }
}
