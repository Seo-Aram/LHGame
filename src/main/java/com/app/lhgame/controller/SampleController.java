package com.app.lhgame.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/member")
    public String pageMember() {
        return "/view/sample/member";
    }

    @GetMapping("/login")
    public String login() {
        return "/view/sample/login";
    }

    @GetMapping("/logout")
    public void logout() {}
}
