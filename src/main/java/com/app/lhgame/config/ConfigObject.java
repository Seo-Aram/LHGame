package com.app.lhgame.config;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ConfigObject {
    private int code;
    private String Name;
    private String KrName;
}
