package com.ohgiraffers.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20,"110-234-56789");
    }

    @Bean
    public MemberDTO memberGenerator() {
        /* [ 생성자 주입 ] */
//        return new MemberDTO(1, "코알라", accountGenerator()); // 위의 accountGenerator를 인자로 전달.

        /* [ Setter 주입 ] */
        MemberDTO member = new MemberDTO();
        member.setSequence(1);
        member.setName("기린");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}
