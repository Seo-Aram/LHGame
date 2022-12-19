package com.app.lhgame.controller.character;

import com.app.lhgame.config.character.JobClassConfig;
import com.app.lhgame.config.character.RacesConfig;
import com.app.lhgame.config.character.SubClassConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@Controller
@RequestMapping("/character")
public class CharacterController {

    @GetMapping("/setting/{page}")
    public ModelAndView getCharacterSettingPage(
            @PathVariable("page") int settingPage,
            ModelAndView model
    ) {
        if(settingPage == 1) { // 1page-> 캐릭터 기본 정보
            model.addObject("races", RacesConfig.getList());
            model.addObject("mainClass", JobClassConfig.getList());
            model.addObject("subClass", SubClassConfig.getList());
            model.setViewName("view/character/setting1");
        }

        return model;
    }
}
