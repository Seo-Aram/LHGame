package com.app.lhgame.config.character;

import com.app.lhgame.config.ConfigObject;
import lombok.Getter;

import java.util.ArrayList;

public class RacesConfig {
    private static ArrayList<ConfigObject> list;
    static {
        list = new ArrayList<>();
        list.add(new ConfigObject(1, "Human", "휴먼"));
        list.add(new ConfigObject(2, "Elf", "엘프"));
        list.add(new ConfigObject(3, "Dwarf", "드워프"));
        list.add(new ConfigObject(4, "HalfAlv", "하프알브"));
        list.add(new ConfigObject(5, "Felinoid", "묘인족"));
        list.add(new ConfigObject(6, "WolfFang", "낭아족"));
        list.add(new ConfigObject(7, "FoxTail", "호미족"));
        list.add(new ConfigObject(8, "Ritian", "법의족"));

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
