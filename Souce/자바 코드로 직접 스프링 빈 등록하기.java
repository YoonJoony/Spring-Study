package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //MemberService와 MemberRepository를 스프링 빈으로 컨테이너에 넣어준다.
    @Bean //스프링 빈에 등록 하라는 뜻
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    //return new MemberService();만 적으면 오류가 난다.
    //MemberService가 MemberRepository를 사용하니 MemberService에 MemberRepository 추가를 해 줘야 한다.
    //return new MemberService(memberRepository()); 로 수정

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
