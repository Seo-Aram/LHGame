package com.app.lhgame.spring.security;

import com.app.lhgame.entity.Member;
import com.app.lhgame.entity.MemberRole;
import com.app.lhgame.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("userLogin");

        Optional<Member> result = memberRepository.findById(username);
        log.info("select by id : " + result.isEmpty());

        if(result.isEmpty()) {
            throw new UsernameNotFoundException("Check Email or Password");
        }
        Member member = result.get();
        log.info(member);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(MemberRole role : member.getRoleSet()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        }

        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                authorities,
                member.getName()
        );

        return authMemberDTO;
    }
}
