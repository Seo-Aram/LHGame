package com.app.lhgame.config.character;

import com.app.lhgame.config.ConfigObject;
import lombok.Getter;

import java.util.ArrayList;

public class SubClassConfig {
    private static ArrayList<ConfigObject> list;
    static {
        list = new ArrayList<>();
        list.add(new ConfigObject(11, "Guardian", "가디언"));
        list.add(new ConfigObject(12, "Samurai", "무사"));
        list.add(new ConfigObject(13, "Monk", "몽크"));
        list.add(new ConfigObject(14, "Hwarang", "화랑"));
        list.add(new ConfigObject(21, "Assassin", "어쌔신"));
        list.add(new ConfigObject(22, "Swashbuckler", "스워시 버클러"));
        list.add(new ConfigObject(23, "Bard", "바드"));
        list.add(new ConfigObject(31, "Cleric", "클레릭"));
        list.add(new ConfigObject(32, "Druid", "드루이드"));
        list.add(new ConfigObject(33, "Kannagi", "칸나기"));
        list.add(new ConfigObject(41, "Sorcerer", "소서러"));
        list.add(new ConfigObject(42, "Summoner", "서모너"));
        list.add(new ConfigObject(43, "Enchanter", "인챈터"));

    }

    public static ArrayList<ConfigObject> getList() {return list;}

    public static ConfigObject findObject(String name) {
        for(ConfigObject obj : list) {
            if(obj.getName().equals(name))
                return obj;
        }
        return null;
    }

    public static ConfigObject findObject(int key) {
        for(ConfigObject obj : list) {
            if(obj.getCode() == key)
                return obj;
        }
        return null;
    }
}
