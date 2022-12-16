package com.app.lhgame.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndex() {
        log.info("Index PAGE");

        return "index";
    }
}
