package com.app.lhgame;

import com.app.lhgame.entity.Member;
import com.app.lhgame.entity.MemberRole;
import com.app.lhgame.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMember() {
        Member member = Member.builder()
                .email("test1@email")
                .password(passwordEncoder.encode("test1234"))
                .name("TEST2")
                .roleSet(new HashSet<MemberRole>())
                .build();

        member.addMemberRole(MemberRole.USER);

        memberRepository.save(member);
    }
}
