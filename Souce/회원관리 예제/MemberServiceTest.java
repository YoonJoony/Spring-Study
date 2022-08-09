package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    @Test
    void 회원가입() { //테스트는 과감하게 한글로 바꿔도 됨
        //given 뭔가 주어 졌을 때
        Member member = new Member();
        member.setName("Hello"); //객체 생성 후 Hello 이름 지정



        //when 이거를 실행 했을 때
        Long saveId = memberService.join(member); //생성한 member객체의 id 반환받음
                                                  //여기서 MemberService 클래스의 join 메소드로 member의 name이 중복되는지 검사 
                                                  //검사 후 저장

        //then 결과가 이게 나와야 한다
        Member findMember = memberService.findOne(saveId).get(); //키 값이 saveId인 객체 반환받음
        assertThat(member.getName()).isEqualTo(findMember.getName()); //반환받은 findMember 객체와 선언한 member객체의 name이 같은지 검사
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
