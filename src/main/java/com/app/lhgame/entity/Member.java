package com.app.lhgame.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Member {

    @Id
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<MemberRole> roleSet;

    public void addMemberRole(MemberRole role) {
        roleSet.add(role);
    }
}
