package com.app.lhgame.config;

public interface IConfig {
    ConfigObject findObject(String name);
    ConfigObject findObject(int key);
}
