package com.app.lhgame.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "view/sign/login";
    }
}
