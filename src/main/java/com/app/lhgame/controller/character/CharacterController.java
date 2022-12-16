package com.app.lhgame.controller.character;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/character")
public class CharacterController {

    @GetMapping("/setting/{page}")
    public void getCharacterSettingPage(
            @PathVariable("page") int settingPage,
            Model model
    ) {
        if(settingPage == 1) { // 1page-> 캐릭터 기본 정보
            
        }
    }
}
