package com.app.lhgame.config.character;

import com.app.lhgame.config.ConfigObject;
import com.app.lhgame.config.IConfig;
import lombok.Getter;

import java.util.ArrayList;

public class JobClassConfig {
    private static ArrayList<ConfigObject> list;
    static {
        list = new ArrayList<>();
        list.add(new ConfigObject(1, "Warrior", "전사직"));
        list.add(new ConfigObject(2, "WeaponAttack", "무기 공격직"));
        list.add(new ConfigObject(3, "Recovery", "회복직"));
        list.add(new ConfigObject(4, "MagicAttack", "마법 공격직"));
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
